package com.exasol.exasoltestsetup;

import com.exasol.errorreporting.ExaError;
import com.jcraft.jsch.*;

/**
 * This class sets uo an ssh port forwarding.
 */
public class SshPortForwarding implements AutoCloseable {
    private final Session sshSession;

    /**
     * Create a new {@link SshPortForwarding}.
     * 
     * @param sshSessionSupplier function that fills the login information
     * @param localPort          local port
     * @param remotePort         remote port
     * @param reverse            {@code true} --> reverse tunnel
     */
    public SshPortForwarding(final SshConfigurator sshSessionSupplier, final int localPort, final int remotePort,
            final boolean reverse) {
        try {
            this.sshSession = sshSessionSupplier.configSshAuth(new JSch());
            this.sshSession.setConfig("StrictHostKeyChecking", "no");
            this.sshSession.connect(5000);
            if (reverse) {
                this.sshSession.setPortForwardingR("*", remotePort, "127.0.0.1", localPort);
            } else {
                this.sshSession.setPortForwardingL("localhost", localPort, "*", remotePort);
            }
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
    }

    @Override
    public void close() throws Exception {
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
         */
        public Session configSshAuth(JSch ssh) throws JSchException;
    }
}
