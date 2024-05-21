package com.exasol.exasoltestsetup.testcontainers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

import org.testcontainers.containers.Container;

import com.exasol.bucketfs.Bucket;
import com.exasol.containers.ExasolContainer;
import com.exasol.containers.ExasolDockerImageReference;
import com.exasol.errorreporting.ExaError;
import com.exasol.exasoltestsetup.*;
import com.exasol.exasoltestsetup.identity.IdentityProvider;
import com.jcraft.jsch.*;

/**
 * {@link ExasolTestSetup} implementation using test containers.
 */
public class ExasolTestcontainerTestSetup implements ExasolTestSetup {
    private static final String DEFAULT_EXASOL_VERSION = "8.27.0";
    private static final int SSH_PORT_CLASSIC = 22;
    private static final int SSH_PORT_NEW = 20002;
    private final ExasolContainer<? extends ExasolContainer<?>> exasolContainer;
    private final SshConnection sshConnection;

    private ExasolTestcontainerTestSetup(final ExasolContainer<? extends ExasolContainer<?>> exasolContainer,
            final SshConnection sshConnection) {
        this.exasolContainer = exasolContainer;
        this.sshConnection = sshConnection;
    }

    /**
     * Start a new Exasol test setup using exasol-testcontainers.
     * 
     * @return a started Exasol test setup
     */
    public static ExasolTestcontainerTestSetup start() {
        return new SetupBuilder(DEFAULT_EXASOL_VERSION).build();
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
    public InetSocketAddress makeLocalTcpServiceAccessibleFromDatabase(final int localPort) {
        final int remotePort = this.sshConnection.addReversePortForwarding(localPort);
        return new InetSocketAddress("localhost", remotePort);
    }

    @Override
    public List<Integer> makeDatabaseTcpServiceAccessibleFromLocalhost(final int databasePort) {
        final int localPort = this.sshConnection.addForwardPortForwarding(databasePort);
        return List.of(localPort);
    }

    @Override
    public void close() {
        this.sshConnection.close();
        this.exasolContainer.stop();
    }

    private static class SetupBuilder {
        final ExasolContainer<? extends ExasolContainer<?>> exasolContainer;
        final KeyPair keyPair;

        @SuppressWarnings("resource") // Resources will be closed in close method.
        SetupBuilder(final String defaultExasolVersion) {
            exasolContainer = new ExasolContainer<>(defaultExasolVersion).withReuse(true);
            this.keyPair = generateKeyPair();
        }

        private static KeyPair generateKeyPair() {
            try {
                return KeyPair.genKeyPair(new JSch(), KeyPair.RSA, 3072);
            } catch (final JSchException exception) {
                throw new IllegalStateException(ExaError.messageBuilder("F-ETAJ-36")
                        .message("Failed to generate temporary ssh-key.").ticketMitigation().toString(), exception);
            }
        }

        ExasolTestcontainerTestSetup build() {
            exasolContainer.addExposedPort(getSshPort());
            exasolContainer.start();
            installSshKeyInDatabase();
            @SuppressWarnings("resource") // Resources will be closed in close method.
            final SshConnection sshConnection = new SshConnection(sessionBuilder());
            return new ExasolTestcontainerTestSetup(exasolContainer, sshConnection);
        }

        private void installSshKeyInDatabase() {
            try {
                final String publicKey = Base64.getEncoder().encodeToString(keyPair.getPublicKeyBlob());
                final String keyType = "ssh-rsa";
                runInContainerWithCheck("bash", "-c",
                        "echo '" + keyType + " " + publicKey + "' >> /root/.ssh/authorized_keys");
            } catch (final IOException exception) {
                throw new IllegalStateException(ExaError.messageBuilder("F-ETAJ-16")
                        .message("Failed to upload ssh-public-key to container. This is required for login in via SSH.")
                        .ticketMitigation().toString(), exception);
            } catch (final InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
        }

        void runInContainerWithCheck(final String... commands) throws IOException, InterruptedException {
            final Container.ExecResult execResult = exasolContainer.execInContainer(commands);
            if (execResult.getExitCode() != 0) {
                throw new IOException(ExaError.messageBuilder("F-ETAJ-17").message(
                        "Failed to exit exaconf in container. The program had an exit code != 0. Error message:\n {{message|uq}}",
                        execResult.getStderr()).toString());
            }
        }

        SessionBuilder sessionBuilder() {
            final ByteArrayOutputStream privateKey = new ByteArrayOutputStream();
            keyPair.writePrivateKey(privateKey);
            return new SessionBuilder() //
                    .user("root") //
                    .host(exasolContainer.getHost()) //
                    .port(exasolContainer.getMappedPort(getSshPort())) //
                    .identity(IdentityProvider.builder() //
                            .identityName("tmp-key") //
                            .publicKey(keyPair.getPublicKeyBlob()) //
                            .privateKey(privateKey.toByteArray()) //
                            .build());
        }

        int getSshPort() {
            return ExasolTestcontainerTestSetup.getSshPort(this.exasolContainer.getDockerImageReference());
        }
    }

    static int getSshPort(final ExasolDockerImageReference exasolVersion) {
        if (exasolVersion.getMajor() >= 8 && exasolVersion.getMinor() >= 27) {
            return SSH_PORT_NEW;
        } else {
            return SSH_PORT_CLASSIC;
        }
    }
}
