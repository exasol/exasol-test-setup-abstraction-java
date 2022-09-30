package com.exasol.exasoltestsetup.testcontainers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

import org.testcontainers.containers.Container;

import com.exasol.bucketfs.Bucket;
import com.exasol.containers.ExasolContainer;
import com.exasol.errorreporting.ExaError;
import com.exasol.exasoltestsetup.*;
import com.exasol.exasoltestsetup.identity.IdentityProvider;
import com.jcraft.jsch.*;

/**
 * {@link ExasolTestSetup} implementation using test containers.
 */
public class ExasolTestcontainerTestSetup implements ExasolTestSetup {
    private static final int SSH_PORT = 22;
    private final ExasolContainer<? extends ExasolContainer<?>> exasolContainer = new ExasolContainer<>("7.1.14")
            .withReuse(true);
    private final SshConnection sshConnection;
    private final KeyPair keyPair;

    /**
     * Test-setup using exasol-testcontainers.
     */
    public ExasolTestcontainerTestSetup() {
        this.exasolContainer.addExposedPort(SSH_PORT);
        this.exasolContainer.start();
        try {
            this.keyPair = KeyPair.genKeyPair(new JSch(), KeyPair.RSA);
        } catch (final JSchException exception) {
            throw new IllegalStateException(ExaError.messageBuilder("F-ETAJ-36")
                    .message("Failed to generate temporary ssh-key.").ticketMitigation().toString(), exception);
        }
        installSshKeyInDatabase();
        this.sshConnection = new SshConnection(sessionBuilder());
    }

    @Override
    public Connection createConnection() throws SQLException {
        return this.exasolContainer.createConnection();
    }

    @Override
    public SqlConnectionInfo getConnectionInfo() {
        return new SqlConnectionInfo(this.exasolContainer.getHost(), this.exasolContainer.getFirstMappedDatabasePort(),
                this.exasolContainer.getUsername(), this.exasolContainer.getPassword());
    }

    @Override
    public Bucket getDefaultBucket() {
        return this.exasolContainer.getDefaultBucket();
    }

    @Override
    public ServiceAddress makeLocalTcpServiceAccessibleFromDatabase(final int localPort) {
        final int remotePort = this.sshConnection.addReversePortForwarding(localPort);
        return ServiceAddress.local(remotePort);
    }

    @Override
    public List<Integer> makeDatabaseTcpServiceAccessibleFromLocalhost(final int databasePort) {
        final int localPort = this.sshConnection.addForwardPortForwarding(databasePort);
        return List.of(localPort);
    }

    private void installSshKeyInDatabase() {
        try {
            runInContainerWithCheck("bash", "-c",
                    "echo \"ssh-rsa " + Base64.getEncoder().encodeToString(this.keyPair.getPublicKeyBlob())
                            + "\" >> /root/.ssh/authorized_keys");
        } catch (final IOException exception) {
            throw new IllegalStateException(ExaError.messageBuilder("F-ETAJ-16")
                    .message("Failed to upload ssh-public-key to container. This is required for login in via SSH.")
                    .ticketMitigation().toString(), exception);
        } catch (final InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
    }

    private void runInContainerWithCheck(final String... commands) throws IOException, InterruptedException {
        final Container.ExecResult execResult = this.exasolContainer.execInContainer(commands);
        if (execResult.getExitCode() != 0) {
            throw new IOException(ExaError.messageBuilder("F-ETAJ-17").message(
                    "Failed to exit exaconf in container. The program had an exit code != 0. Error message:\n {{message|uq}}",
                    execResult.getStderr()).toString());
        }
    }

    @Override
    public void close() throws Exception {
        this.sshConnection.close();
        this.exasolContainer.stop();
    }

    private SessionBuilder sessionBuilder() {
        final ByteArrayOutputStream privateKey = new ByteArrayOutputStream();
        this.keyPair.writePrivateKey(privateKey);
        return new SessionBuilder() //
                .user("root") //
                .host(this.exasolContainer.getHost()) //
                .port(this.exasolContainer.getMappedPort(SSH_PORT)) //
                .identity(IdentityProvider.builder() //
                        .identityName("tmp-key") //
                        .publicKey(this.keyPair.getPublicKeyBlob()) //
                        .privateKey(privateKey.toByteArray()) //
                        .build());
    }
}
