package com.exasol.exasoltestsetup;

import java.io.IOException;
import java.net.ServerSocket;

import com.exasol.errorreporting.ExaError;
import com.jcraft.jsch.*;

/**
 * This class sets up a SSH port forwarding.
 */
public class SshConnection implements AutoCloseable {
    private final Session sshSession;

    /**
     * Create a new {@link SshConnection}.
     * <p>
     * It automatically opens an SSH connection for forwarding.
     * </p>
     * 
     * @param sshSessionSupplier function that fills the login information
     */
    public SshConnection(final SshConfigurator sshSessionSupplier) {
        this.sshSession = createSession(sshSessionSupplier);
    }

    /**
     * Add a reverse port forwarding.
     * 
     * @param localPort local port to expose
     * @return port number on the server
     */
    public int addReversePortForwarding(final int localPort) {
        final int remotePort = findFreePortOnServer();
        try {
            this.sshSession.setPortForwardingR("*", remotePort, "localhost", localPort);
            return remotePort;
        } catch (final JSchException exception) {
            throw new IllegalStateException(
                    ExaError.messageBuilder("E-ETAJ-22").message("Failed to setup reverse port forwarding.").toString(),
                    exception);
        }
    }

    /**
     * Add a forward port forwarding.
     * 
     * @param remotePort port of the the server to connect to
     * @return local port
     */
    public int addForwardPortForwarding(final int remotePort) {
        return addForwardPortForwarding(remotePort, "localhost");
    }

    public int addForwardPortForwarding(final int remotePort, final String targetHost) {
        final int localPort = findFreeLocalPort();
        try {
            this.sshSession.setPortForwardingL("localhost", localPort, targetHost, remotePort);
            return localPort;
        } catch (final JSchException exception) {
            throw new IllegalStateException(
                    ExaError.messageBuilder("E-ETAJ-24").message("Failed to setup forward port forwarding.").toString(),
                    exception);
        }
    }

    private Session createSession(final SshConfigurator sshSessionSupplier) {
        final Session session;
        try {
            session = sshSessionSupplier.configSshAuth(new JSch());
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect(5000);
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
        return session;
    }

    /**
     * Run a shell command as root.
     * <p>
     * This is a synchronous method. It will block until the command is finished.
     * </p>
     * 
     * @param command command to run
     * @return command output (stdout)
     */
    public SshExecution runCommandAsRoot(final String command) {
        return runCommand("echo \"" + command.replace("\"", "\\\"") + "\" | sudo sh");
    }

    /**
     * Run a shell command.
     *
     * @param command command to run
     * @return ssh execution
     */
    public SshExecution runCommand(final String command) {
        return new SshExecution(this.sshSession, command);
    }

    /**
     * Find a free port on the server.
     * 
     * @return free port number
     */
    public int findFreePortOnServer() {
        final String netstatOutput = runCommand("netstat -tunlep | grep LISTEN | awk '{print $4}'").whenFinished()
                .assertExitCodeIsZero().getStdout();
        final String[] netstatRows = netstatOutput.split("\n");
        int maxUsedPort = 0;
        for (final String netstatRow : netstatRows) {
            final String[] parts = netstatRow.split(":");
            if (parts.length < 2) {
                continue;
            }
            final int usedPort = Integer.parseInt(parts[parts.length - 1]);
            maxUsedPort = Math.max(maxUsedPort, usedPort);
        }
        return maxUsedPort + 1;
    }

    private int findFreeLocalPort() {
        try (final ServerSocket socket = new ServerSocket(0);) {
            return socket.getLocalPort();
        } catch (final IOException exception) {
            throw new IllegalStateException(ExaError.messageBuilder("F-ETAJ-23")
                    .message("Failed to search for a free local port.").ticketMitigation().toString(), exception);
        }
    }

    @Override
    public void close() {
        this.sshSession.disconnect();
    }

    /**
     * Functional interface that configures ssh auth.
     */
    @FunctionalInterface
    public interface SshConfigurator {
        /**
         * Get a ssh session configured with credentials.
         * 
         * @param ssh {@link JSch} ssh client
         * @return ssh sessions with configured auth
         * @throws JSchException if configuring went wrong
         */
        public Session configSshAuth(JSch ssh) throws JSchException;
    }
}
