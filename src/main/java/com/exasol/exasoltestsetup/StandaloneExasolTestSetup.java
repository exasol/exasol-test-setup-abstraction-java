package com.exasol.exasoltestsetup;

import static com.exasol.exasoltestsetup.ConditionalWait.waitUntil;

import java.security.SecureRandom;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.exasol.bucketfs.Bucket;
import com.exasol.bucketfs.SyncAwareBucket;
import com.exasol.dbcleaner.ExasolDatabaseCleaner;
import com.exasol.errorreporting.ExaError;
import com.jcraft.jsch.*;

public class StandaloneExasolTestSetup implements ExasolTestSetup {
    private static final int BUCKETFS_PORT = 2580;
    private final String exasolManagementHost;
    private final String exasolDatanodeHost;
    private final String exasolAdminUser = getEnvVarWithCheck("EXASOL_ADMIN_USER");
    private final String exasolAdminPass = getEnvVarWithCheck("EXASOL_ADMIN_PASS");
    private final String exasolUser = getEnvVarWithCheck("EXASOL_USER");
    private final String exasolPass = getEnvVarWithCheck("EXASOL_PASS");
    private final String bucketfsReadPassword;
    private final String bucketfsWritePassword;
    private final List<Session> sshPortForwardingSessions = new ArrayList<>();

    public StandaloneExasolTestSetup(final String exasolManagementHost, final String exasolDatanodeHost) {
        this.exasolManagementHost = exasolManagementHost;
        this.exasolDatanodeHost = exasolDatanodeHost;
        final ExaOperationInterface exaOperationInterface = new ExaOperationInterface(this.exasolManagementHost,
                this.exasolAdminUser, this.exasolAdminPass);
        exaOperationInterface.startStorageServiceIfNotRunning();
        exaOperationInterface.startAllDatabases();
        exaOperationInterface.setBucketfsPort(BUCKETFS_PORT);
        this.bucketfsReadPassword = generatePassword();
        this.bucketfsWritePassword = "mySecureWritePw";
        exaOperationInterface.setBucketPasswords(this.bucketfsReadPassword, this.bucketfsWritePassword);
        waitForExasolToSyncTheSettings();
        waitUntil(this::isSqlInterfaceAvailable);
        cleanTheDatabase();
    }

    private String getEnvVarWithCheck(final String variableName) {
        final String value = System.getenv(variableName);
        if (value == null) {
            throw new IllegalStateException(
                    ExaError.messageBuilder("E-ETSA-15").message("Undeclared environment variable {{variable}}.")
                            .mitigation("Please set the required variable {{variable}}.")
                            .parameter("variable", variableName).toString());
        }
        return value;
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
            throw new IllegalStateException(ExaError.messageBuilder("E-VSAJ-14")
                    .message("Failed to connect to the exasol database for cleaning.").toString(), exception);
        }
    }

    private void waitForExasolToSyncTheSettings() {
        try {
            Thread.sleep(2000);
        } catch (final InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public Connection createConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:exa:" + this.exasolDatanodeHost + ":8563", this.exasolUser,
                this.exasolPass);
    }

    @Override
    public Bucket getDefaultBucket() {
        return SyncAwareBucket.builder().ipAddress(this.exasolDatanodeHost).httpPort(BUCKETFS_PORT).name("default")
                .serviceName("bfsdefault").readPassword(this.bucketfsReadPassword)
                .writePassword(this.bucketfsWritePassword).monitor(new WaitBucketfsMonitor()).build();
    }

    @Override
    public void teardown() {
        for (final Session session : this.sshPortForwardingSessions) {
            session.disconnect();
        }
    }

    @Override
    public String makeLocalServiceAvailableInDatabase(final int hostPort) {
        try {
            final JSch ssh = new JSch();
            ssh.addIdentity("~/.ssh/id_rsa");
            final Session sshSession = ssh.getSession("ec2-user", this.exasolManagementHost, 22);
            sshSession.setConfig("StrictHostKeyChecking", "no");
            sshSession.connect(5000);
            this.sshPortForwardingSessions.add(sshSession);
            sshSession.setPortForwardingR("*", hostPort, "127.0.0.1", hostPort);
        } catch (final JSchException exception) {
            if (exception.getMessage().startsWith("invalid privatekey")) {
                throw new IllegalStateException(ExaError.messageBuilder("E-ETAJ-13")
                        .message("The format of your privatekey is not supported.")
                        .mitigation("Convert using `ssh-keygen -p -f id_rsa -m pem -P \"\" -N \"\"\n`").toString(),
                        exception);
            } else {
                throw new IllegalStateException(ExaError.messageBuilder("E-ETAJ-12")
                        .message("Failed to ssh to the exasol database. This is required for redirecting a host port.")
                        .mitigation("Make sure the database is reachable (port 22 open)")
                        .mitigation("Make sure 'ec2-user' can login to the database using your ssh-key.").toString(),
                        exception);
            }
        }
        return "license";
    }

    @Override
    public int makeDatabaseServiceAvailableAtLocalhost(final int databasePort) {
        throw new IllegalStateException("not yet implemented");
    }

    private String generatePassword() {
        final SecureRandom random = new SecureRandom();
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        return random.ints(25, 0, chars.length()).mapToObj(randomNumber -> String.valueOf(chars.charAt(randomNumber)))
                .collect(Collectors.joining());
    }
}
