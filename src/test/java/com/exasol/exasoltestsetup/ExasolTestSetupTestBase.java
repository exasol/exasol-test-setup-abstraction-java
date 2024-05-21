package com.exasol.exasoltestsetup;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.io.TempDir;

import com.exasol.bucketfs.Bucket;
import com.exasol.bucketfs.BucketAccessException;
import com.exasol.errorreporting.ExaError;

public abstract class ExasolTestSetupTestBase {
    private static final Logger LOGGER = Logger.getLogger(ExasolTestSetupTestBase.class.getName());
    private static final String TEST_FILE_NAME = "testFile.txt";
    private static final String TEST_CONTENT = "my test string";
    private static final int TEST_SOCKET_PORT = 5111;
    private ExasolTestSetup testSetup;
    private Connection connection;
    private Statement statement;

    public ExasolTestSetupTestBase() {
    }

    protected abstract ExasolTestSetup getExasolTestSetup();

    @BeforeEach
    void beforeEach() throws SQLException {
        this.testSetup = this.getExasolTestSetup();
        this.connection = this.testSetup.createConnection();
        this.statement = this.connection.createStatement();
    }

    @AfterEach
    void afterEach() throws Exception {
        if (this.statement != null) {
            this.statement.close();
        }
        if (this.connection != null) {
            this.connection.close();
        }
        if (this.testSetup != null) {
            this.testSetup.close();
        }
    }

    @Test
    void testDatabaseConnection() throws SQLException {
        try (final ResultSet resultSet = this.statement.executeQuery("SELECT 1 FROM DUAL")) {
            resultSet.next();
            assertThat(resultSet.getInt(1), equalTo(1));
        }
    }

    @Test
    void testGetConnectionDetails() throws SQLException {
        final SqlConnectionInfo connectionInfo = this.testSetup.getConnectionInfo();
        try (final Connection conn = DriverManager
                .getConnection(
                        "jdbc:exa:" + connectionInfo.getHost() + ":" + connectionInfo.getPort()
                                + ";validateservercertificate=0",
                        connectionInfo.getUser(), connectionInfo.getPassword());
                final Statement stmt = conn.createStatement();
                final ResultSet resultSet = stmt.executeQuery("SELECT 1 FROM DUAL");) {
            resultSet.next();
            assertThat(resultSet.getInt(1), equalTo(1));
        }
    }

    @Test
    void testBucketFS(@TempDir final Path tempDir)
            throws InterruptedException, BucketAccessException, TimeoutException, IOException {
        final Bucket bucket = this.testSetup.getDefaultBucket();
        bucket.uploadStringContent(TEST_CONTENT, TEST_FILE_NAME);
        final Path localFile = tempDir.resolve(TEST_FILE_NAME);
        bucket.downloadFile(TEST_FILE_NAME, localFile);
        assertThat(Files.readString(localFile), equalTo(TEST_CONTENT));
    }

    @Test
    void testMakeLocalServiceAvailableInDatabase() throws Exception {
        final InetSocketAddress inDbAddress = this.testSetup
                .makeLocalTcpServiceAccessibleFromDatabase(TEST_SOCKET_PORT);
        assertLocalServiceIsAvailableFromDatabase(inDbAddress);
    }

    @Test
    void testMakeServiceAvailableInDatabaseWithLocalService() throws Exception {
        final InetSocketAddress inDbAddress = this.testSetup
                .makeTcpServiceAccessibleFromDatabase(new InetSocketAddress("localhost", TEST_SOCKET_PORT));
        assertLocalServiceIsAvailableFromDatabase(inDbAddress);
    }

    @Test
    void testMakeServiceAvailableInDatabaseWithExternalService() {
        final InetSocketAddress serviceAddress = new InetSocketAddress("my-web-server.de", TEST_SOCKET_PORT);
        final InetSocketAddress inDbAddress = this.testSetup.makeTcpServiceAccessibleFromDatabase(serviceAddress);
        assertThat(inDbAddress, equalTo(serviceAddress));
    }

    private void assertLocalServiceIsAvailableFromDatabase(final InetSocketAddress inDbAddress) throws SQLException {
        final ExasolTestSetupTestBase.DummySocketServer dummySocketServer = new ExasolTestSetupTestBase.DummySocketServer();
        try {
            pingFromUdf(inDbAddress);
            Assertions.assertTrue(dummySocketServer.hasClient.get());
        } finally {
            dummySocketServer.shutdown();
        }
    }

    private void pingFromUdf(final InetSocketAddress inDbAddress) throws SQLException {
        this.statement.executeUpdate("CREATE SCHEMA TEST");
        final String pingUdf = "CREATE OR REPLACE PYTHON3 SCALAR SCRIPT TEST.PING() RETURNS INT AS\n" + //
                "def run(ctx):\n" + //
                "  import socket\n" + //
                "  s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)\n" + //
                "  s.connect((\"" + inDbAddress.getHostName() + "\", " + inDbAddress.getPort() + "))\n" + "" + //
                "  return 1" + //
                "\n/\n";
        this.statement.executeUpdate(pingUdf);
        this.statement.executeQuery("SELECT TEST.PING();");
    }

    @Test
    void testMakeDatabaseServiceAvailableAtLocalhost() throws SQLException, InterruptedException {
        final List<Integer> localPorts = this.testSetup.makeDatabaseTcpServiceAccessibleFromLocalhost(8001);
        assertThat(localPorts.size(), greaterThanOrEqualTo(1));
        final ConnectionTester connectionTester = new ConnectionTester(localPorts);
        createTcpServerInUdf();// blocking until received a connection or timeout
        waitForConnectionTesterToReceive();
        Assertions.assertTrue(connectionTester.success.get());
    }

    /**
     * Since the connection tester runs in a dedicated thread we need to wait a bit so that it will also run on single
     * core CPUs.
     *
     * @throws InterruptedException if interrupted
     */
    @SuppressWarnings("java:S2925") // sleep required for testing
    private void waitForConnectionTesterToReceive() throws InterruptedException {
        Thread.sleep(100);
    }

    private void createTcpServerInUdf() throws SQLException {
        this.statement.executeUpdate("CREATE SCHEMA TEST");
        final String serverUdf = "CREATE OR REPLACE PYTHON3 SCALAR SCRIPT TEST.SERVE() RETURNS INT AS\n" + //
                "def run(ctx):\n" + //
                "  hadClient = 0\n" + //
                "  from socketserver import BaseRequestHandler, TCPServer\n" + //
                "  class handler(BaseRequestHandler):\n" + //
                "    def handle(self):\n" + //
                "      hadClient = 1\n" + //
                "      self.request.sendall(b'hallo')\n" + //
                "  TCPServer.allow_reuse_address = True\n" + //
                "  with TCPServer(('', 8001), handler) as server:\n" + //
                "    server.timeout = 100\n" + //
                "    server.handle_request()\n" + //
                "    server.server_close()\n" + //
                "  return hadClient" + //
                "\n/\n";
        this.statement.executeUpdate(serverUdf);
        this.statement.executeQuery("SELECT TEST.SERVE();");
    }

    private static class ConnectionTester extends Thread {
        private final long start;
        private final List<Integer> ports;
        private final AtomicBoolean success = new AtomicBoolean(false);

        public ConnectionTester(final List<Integer> ports) {
            this.ports = ports;
            this.start = System.currentTimeMillis();
            this.start();
        }

        @Override
        public void run() {
            while (((System.currentTimeMillis() - this.start) < (1000 * 20)) && !this.success.get()) {
                for (final Integer port : this.ports) {
                    try {
                        final Socket socket = new Socket("localhost", port);
                        final String message = new String(socket.getInputStream().readAllBytes(),
                                StandardCharsets.UTF_8);
                        if (message.equals("hallo")) {
                            this.success.set(true);
                        }
                        socket.close();
                        break;
                    } catch (final IOException e) {
                        // ignore
                    }
                }
            }
        }
    }

    private static class DummySocketServer extends Thread {
        private final AtomicBoolean hasClient = new AtomicBoolean(false);
        private ServerSocket serverSocket;

        private DummySocketServer() {
            LOGGER.info("Starting dummy socket server on part " + TEST_SOCKET_PORT);
            this.start();
        }

        public void shutdown() {
            LOGGER.info("Shutting down dummy socket server");
            if (this.serverSocket != null) {
                try {
                    this.serverSocket.close();
                } catch (final IOException exception) {
                    // ignore
                }
            }
        }

        @Override
        public void run() {
            createSocket();
            try {
                this.serverSocket.accept();
                this.hasClient.set(true);
            } catch (final IOException exception) {
                throw new IllegalStateException(exception);
            }
        }

        private void createSocket() {
            try {
                this.serverSocket = new ServerSocket(TEST_SOCKET_PORT);
            } catch (final IOException exception) {
                throw new IllegalStateException(
                        ExaError.messageBuilder("E-ETAJ-11").message("Failed to start a socket server for testing.")
                                .mitigation("Make sure that port {{port}} is free.", TEST_SOCKET_PORT).toString(),
                        exception);
            }
        }
    }
}
