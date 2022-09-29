package com.exasol.exasoltestsetup;

import java.io.IOException;
import java.net.ServerSocket;

import com.exasol.errorreporting.ExaError;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

/**
 * This class sets up a SSH port forwarding.
 */
public class SshConnection implements AutoCloseable {
    private static final String PORT_FINDER_PYTHON_SCRIPT = "import socket\n" + //
            "from contextlib import closing\n" + //
            "with closing(socket.socket(socket.AF_INET, socket.SOCK_STREAM)) as s:\n" + //
            "    s.bind(('', 0))\n" + //
            "    s.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)\n" + //
            "    print(s.getsockname()[1])\n\n";
    private final Session sshSession;

    /**
     * Create a new {@link SshConnection}.
     * <p>
     * It automatically opens an SSH connection for forwarding.
     * </p>
     *
     * @param sshSessionSupplier function that fills the login information
     */
    public SshConnection(final SessionBuilder sessionBuilder) {
        this.sshSession = createSession(sessionBuilder);
    }

    private Session createSession(final SessionBuilder sessionBuilder) {
        final Session session;
        try {
            session = sessionBuilder.build();
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
        } catch (final JSchException exception) {
            if (exception.getMessage().startsWith("invalid privatekey")) {
                throw new IllegalStateException(ExaError.messageBuilder("E-ETAJ-13")
                        .message("The format of your privatekey is not supported.")
                        .mitigation("Convert using `ssh-keygen -p -f id_rsa -m pem -P \"\" -N \"\"\n`").toString(),
                        exception);
            } else {
                throw new IllegalStateException(ExaError.messageBuilder("E-ETAJ-12")
                        .message("Failed to ssh to the exasol database. This is required for redirecting a host port.")
                        .mitigation("Make sure the database is reachable, i.e. port {{port}} open on host {{host}}.", //
                                sessionBuilder.getPort(), sessionBuilder.getHost())
                        .mitigation("Make sure user {{user}} can login to the database using your ssh-key.",
                                sessionBuilder.getUser())
                        .toString(), exception);
            }
        }
        return session;
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

    /**
     * Add a forward port forwarding.
     *
     * @param remotePort port of the the server to connect to
     * @param targetHost the host to forward the request to
     * @return local port
     */
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
        final String portOutput = runCommand("python <<HEREDOC\n" + PORT_FINDER_PYTHON_SCRIPT + "HEREDOC")
                .whenFinished().assertExitCodeIsZero().getStdout();
        try {
            return Integer.parseInt(portOutput.trim());
        } catch (final NumberFormatException exception) {
            throw new IllegalStateException(ExaError.messageBuilder("F-ETAJ-29")
                    .message("Failed to find free port on server. The python script had an invalid output: {{output}}.",
                            portOutput)
                    .ticketMitigation().toString(), exception);
        }
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
}
