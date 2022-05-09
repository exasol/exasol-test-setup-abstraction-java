package com.exasol.exasoltestsetup.standalone;

import static com.exasol.exasoltestsetup.PasswordGenerator.generatePassword;
import static com.exasol.exasoltestsetup.WaitHelper.waitFor;
import static com.exasol.exasoltestsetup.WaitHelper.waitUntil;

import java.sql.*;
import java.util.*;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.exasol.bucketfs.*;
import com.exasol.dbcleaner.ExasolDatabaseCleaner;
import com.exasol.errorreporting.ExaError;
import com.exasol.exasoltestsetup.*;
import com.jcraft.jsch.*;

/**
 * This class implements the {@link ExasolTestSetup} interface for Exasol databases that are running in the Cloud or in
 * a VM.
 */
public class StandaloneExasolTestSetup implements ExasolTestSetup {
    private static final java.util.logging.Logger LOGGER = Logger.getLogger(StandaloneExasolTestSetup.class.getName());
    private static final int BUCKET_FS_PORT = 2580;
    private static final int DATABASE_PORT = 8563;
    private static final int EXA_OPERATION_PORT = 443;
    private final ConnectionDetails connectionDetails;
    private final String bucketFsReadPassword;
    private final String bucketFsWritePassword;
    private final SshConnection sshConnection;
    private final int localBucketFsPort;
    private final int localDatabasePort;
    private final List<String> dataNodeIds;

    /**
     * Create a new instance of {@link StandaloneExasolTestSetup}.
     *
     * @param connectionDetails connection details for the Exasol database
     */
    public StandaloneExasolTestSetup(final ConnectionDetails connectionDetails) {
        this.connectionDetails = connectionDetails;
        this.sshConnection = createConfiguredSshConnection();
        this.dataNodeIds = fetchDataNodeIds();
        this.localBucketFsPort = this.sshConnection.addForwardPortForwarding(BUCKET_FS_PORT, getADataNode());
        final int localHttpsPort = this.sshConnection.addForwardPortForwarding(EXA_OPERATION_PORT);
        this.localDatabasePort = this.sshConnection.addForwardPortForwarding(DATABASE_PORT, getADataNode());
        final ExaOperationGateway exaOperationGateway = new ExaOperationGateway("localhost:" + localHttpsPort,
                connectionDetails.getAdminCredentials());
        exaOperationGateway.startStorageServiceIfNotRunning();
        exaOperationGateway.startAllDatabases();
        exaOperationGateway.setBucketFsPort("bfsdefault", BUCKET_FS_PORT);
        this.bucketFsReadPassword = generatePassword();
        this.bucketFsWritePassword = generatePassword();
        setBucketsPasswordWithWorkaround(exaOperationGateway);
        waitUntil(this::isSqlInterfaceAvailable, 120, "SQL interface");
        cleanTheDatabase();
    }

    /**
     * The changing of the password fails from time to time without an error (with just ni change). As a workaround we
     * try it multiple times and check if it worked.
     * 
     * @param exaOperationGateway ExaOperation
     */
    private void setBucketsPasswordWithWorkaround(final ExaOperationGateway exaOperationGateway) {
        int tryCounter = 0;
        do {
            exaOperationGateway.setBucketPasswords(this.bucketFsReadPassword, this.bucketFsWritePassword);
            waitFor(100);
            tryCounter++;
            if (tryCounter > 10) {
                throw new IllegalStateException(
                        ExaError.messageBuilder("E-ETAJ-32").message("Failed to set BucketFS password.").toString());
            }
        } while (!this.isBucketFsIsAvailable());
    }

    private boolean isBucketFsIsAvailable() {
        final String testFile = "bfs-test-" + System.currentTimeMillis() + ".txt";
        final Bucket bucket = getDefaultBucket();
        try {
            bucket.uploadStringContent("1", testFile);
            bucket.downloadFileAsString(testFile);
            bucket.deleteFileNonBlocking(testFile);
            return true;
        } catch (final BucketAccessException | TimeoutException exception) {
            return false;
        } catch (final InterruptedException exception) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException(ExaError.messageBuilder("E-ETAJ-30")
                    .message("Interrupt which checking BucketFs connection.").toString(), exception);
        }
    }

    private String getADataNode() {
        if (this.dataNodeIds.isEmpty()) {
            throw new IllegalStateException(ExaError.messageBuilder("E-ETAJ-27").message("No datanodes available.")
                    .mitigation("Probably the cluster has not started completely. Try to wait a bit.").toString());
        }
        return this.dataNodeIds.get(0);
    }

    private List<String> fetchDataNodeIds() {
        final List<String> nodes = new ArrayList<>(
                Arrays.asList(this.sshConnection.runCommand("/usr/opt/EXASuite-*/EXAClusterOS-*/bin/cosinfo -e")
                        .whenFinished().assertExitCodeIsZero().getStdout().split("\n")));
        nodes.removeIf(nodeId -> nodeId.equals("10"));// remove management node
        return nodes.stream().map(id -> "n" + id).collect(Collectors.toList());
    }

    /**
     * This method creates an SSH connection with the required server side sshd configuration.
     *
     * @return ssh connection
     */
    private SshConnection createConfiguredSshConnection() {
        return addGatewayPortsIfRequired(createSshConnection());
    }

    private SshConnection createSshConnection() {
        return new SshConnection(this::configSshAuth);
    }

    private SshConnection addGatewayPortsIfRequired(SshConnection connection) {
        final String sshConfig = connection.runCommandAsRoot("cat /etc/ssh/sshd_config").whenFinished()
                .assertExitCodeIsZero().getStdout();
        if (!sshConfig.contains("GatewayPorts yes")) {
            LOGGER.warning(() -> ExaError.messageBuilder("W-ETAJ-21").message(
                    "The management nodes ssh configuration did not contain GatewayPorts yes. We will now automatically add it.")
                    .toString());
            connection.runCommandAsRoot("echo GatewayPorts yes >> /etc/ssh/sshd_config");
            try {
                connection.runCommandAsRoot("killall -s HUP sshd");
            } catch (final IllegalStateException exception) {
                // ignore; command will fail since we are killing the ssh server
            }
            connection.close();
            WaitHelper.waitFor(5000);// wait for sshd to restart
            connection = createSshConnection();
        }
        return connection;
    }

    private boolean isSqlInterfaceAvailable() {
        try (final Connection connection = createConnection();
                final Statement statement = connection.createStatement()) {
            statement.executeQuery("SELECT * FROM DUAL;");
            return true;
        } catch (final SQLException exception) {
            return false;
        }
    }

    private void cleanTheDatabase() {
        try (final Connection connection = createConnection();
                final Statement statement = connection.createStatement()) {
            new ExasolDatabaseCleaner(statement).cleanDatabase();
        } catch (final SQLException exception) {
            throw new IllegalStateException(ExaError.messageBuilder("E-ETAJ-28")
                    .message("Failed to connect to the exasol database for cleaning.").toString(), exception);
        }
    }

    @Override
    public Connection createConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:exa:localhost:" + this.localDatabasePort + ";validateservercertificate=0",
                this.connectionDetails.getDatabaseCredentials().getUsername(),
                this.connectionDetails.getDatabaseCredentials().getPassword());
    }

    @Override
    public SqlConnectionInfo getConnectionInfo() {
        return new SqlConnectionInfo("localhost", this.localDatabasePort,
                this.connectionDetails.getDatabaseCredentials().getUsername(),
                this.connectionDetails.getDatabaseCredentials().getPassword());
    }

    @Override
    public Bucket getDefaultBucket() {
        return SyncAwareBucket.builder().ipAddress("localhost").port(this.localBucketFsPort).name("default")
                .serviceName("bfsdefault").readPassword(this.bucketFsReadPassword)
                .writePassword(this.bucketFsWritePassword).monitor(new WaitBucketFsMonitor()).build();
    }

    @Override
    public ServiceAddress makeLocalTcpServiceAccessibleFromDatabase(final int localPort) {
        final int remotePort = this.sshConnection.addReversePortForwarding(localPort);
        return new ServiceAddress("license", remotePort);
    }

    @Override
    public List<Integer> makeDatabaseTcpServiceAccessibleFromLocalhost(final int databasePort) {
        return this.dataNodeIds.stream()
                .map(dataNodeId -> this.sshConnection.addForwardPortForwarding(databasePort, dataNodeId))
                .collect(Collectors.toList());
    }

    @Override
    public void close() {
        this.sshConnection.close();
    }

    private Session configSshAuth(final JSch ssh) throws JSchException {
        ssh.addIdentity("./cloudSetup/generated/exasol_cluster_ssh_key");
        return ssh.getSession("ec2-user", this.connectionDetails.getManagementNodeAddress(),
                this.connectionDetails.getSshPort());
    }
}
