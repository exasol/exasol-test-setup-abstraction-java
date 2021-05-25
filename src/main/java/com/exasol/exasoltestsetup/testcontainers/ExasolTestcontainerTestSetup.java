package com.exasol.exasoltestsetup.testcontainers;

import static com.exasol.exasoltestsetup.PasswordGenerator.generatePassword;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.testcontainers.containers.Container;

import com.exasol.bucketfs.Bucket;
import com.exasol.containers.ExasolContainer;
import com.exasol.errorreporting.ExaError;
import com.exasol.exasoltestsetup.ExasolTestSetup;
import com.exasol.exasoltestsetup.SshPortForwarding;
import com.jcraft.jsch.*;

public class ExasolTestcontainerTestSetup implements ExasolTestSetup {
    private static final int SSH_PORT = 22;
    private final ExasolContainer<? extends ExasolContainer<?>> exasolContainer = new ExasolContainer<>()
            .withReuse(true);
    private final List<SshPortForwarding> portForwards = new ArrayList<>();
    private String rootPassword;

    public ExasolTestcontainerTestSetup() {
        this.exasolContainer.addExposedPort(SSH_PORT);
        this.exasolContainer.start();
        setRootPassword();
    }

    @Override
    public Connection createConnection() throws SQLException {
        return this.exasolContainer.createConnection();
    }

    @Override
    public Bucket getDefaultBucket() {
        return this.exasolContainer.getDefaultBucket();
    }

    @Override
    public String makeLocalServiceAvailableInDatabase(final int localPort) {
        this.portForwards.add(new SshPortForwarding(this::configSshAuth, localPort, localPort, true));
        return "localhost";
    }

    @Override
    public List<Integer> makeDatabaseServiceAvailableAtLocalhost(final int databasePort) {
        this.exasolContainer.addExposedPort(databasePort);
        this.portForwards.add(new SshPortForwarding(this::configSshAuth, databasePort, databasePort, false));
        return List.of(databasePort);
    }

    private void setRootPassword() {
        try {
            this.rootPassword = generatePassword();
            runInContainerWithCheck("exaconf", "passwd-user", "-n", "root", "-p", this.rootPassword);
            runInContainerWithCheck("exaconf", "commit");
        } catch (final IOException exception) {
            throw new IllegalStateException(ExaError.messageBuilder("F-ETAJ-16")
                    .message("Failed to set root password of docker container. This is required for login in via SSH.")
                    .ticketMitigation().toString(), exception);
        } catch (final InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
    }

    private void runInContainerWithCheck(final String... commands) throws IOException, InterruptedException {
        final Container.ExecResult execResult = this.exasolContainer.execInContainer(commands);
        if (execResult.getExitCode() != 0) {
            throw new IOException(ExaError.messageBuilder("F-ETAJ-17").message(
                    "Filed to exit exaconf in container. The program had an exit code != 0. Error message:\n {{message|uq}}",
                    execResult.getStderr()).toString());
        }
    }

    @Override
    public void close() throws Exception {
        for (final SshPortForwarding portForward : this.portForwards) {
            portForward.close();
        }
        this.exasolContainer.stop();
    }

    private Session configSshAuth(final JSch ssh) throws JSchException {
        final Session session = ssh.getSession("root", "localhost", this.exasolContainer.getMappedPort(SSH_PORT));
        session.setConfig("PreferredAuthentications", "publickey,keyboard-interactive,password");
        session.setPassword(this.rootPassword);
        return session;
    }
}
