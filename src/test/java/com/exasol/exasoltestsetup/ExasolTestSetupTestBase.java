package com.exasol.exasoltestsetup;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.io.TempDir;

import com.exasol.bucketfs.Bucket;
import com.exasol.bucketfs.BucketAccessException;
import com.exasol.errorreporting.ExaError;

public abstract class ExasolTestSetupTestBase {
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
        this.statement.close();
        this.connection.close();
        this.testSetup.close();
    }

    @Test
    void testDatabaseConnection() throws SQLException {
        try (final ResultSet resultSet = this.statement.executeQuery("SELECT 1 FROM DUAL")) {
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
        final ExasolTestSetupTestBase.DummySocketServer dummySocketServer = new ExasolTestSetupTestBase.DummySocketServer();
        try (final ExasolTestSetup testSetup = this.getExasolTestSetup()) {
            final String mappedHostName = testSetup.makeLocalServiceAvailableInDatabase(TEST_SOCKET_PORT);
            this.statement.executeUpdate("CREATE SCHEMA TEST");
            final String pingUdf = "CREATE OR REPLACE PYTHON SCALAR SCRIPT TEST.PING() RETURNS INT AS\n" + //
                    "def run(ctx):\n" + //
                    "  import socket\n" + //
                    "  s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)\n" + //
                    "  s.connect((\"" + mappedHostName + "\", 5111))\n" + "" + //
                    "  return 1" + //
                    "\n/\n";
            this.statement.executeUpdate(pingUdf);
            final IllegalStateException exception = dummySocketServer.getException();
            if (exception != null) {
                throw exception;
            }
            this.statement.executeQuery("select TEST.PING();");
            Assertions.assertTrue(dummySocketServer.hasClient.get());
        } finally {
            dummySocketServer.shutdown();
        }
    }

    @Test
    void testMakeDatabaseServiceAvailableAtLocalhost() throws SQLException {
        this.statement.executeUpdate("CREATE SCHEMA TEST");
        final List<Integer> localPorts = this.testSetup.makeDatabaseServiceAvailableAtLocalhost(8001);
        assertThat(localPorts.size(), greaterThanOrEqualTo(1));
        final ConnectionTester connectionTester = new ConnectionTester(localPorts);
        final String pingUdf = "CREATE OR REPLACE PYTHON3 SCALAR SCRIPT TEST.SERVE() RETURNS INT AS\n" + //
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
        this.statement.executeUpdate(pingUdf);
        this.statement.executeQuery("select TEST.SERVE();");
        Assertions.assertTrue(connectionTester.success.get());
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
            while (System.currentTimeMillis() - this.start < 1000 * 20 && !this.success) {
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
            this.start();
        }

        public void shutdown() {
            if (this.serverSocket != null) {
                try {
                    this.serverSocket.close();
                } catch (final IOException exception) {
                    // ignore
                }
            }
        }

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
                                .mitigation("Make sure that port 5111 is free.").toString(),
                        exception);
            }
        }
    }
}