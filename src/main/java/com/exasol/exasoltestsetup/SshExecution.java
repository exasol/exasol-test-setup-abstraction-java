package com.exasol.exasoltestsetup;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import com.exasol.errorreporting.ExaError;
import com.exasol.exasoltestsetup.standalone.WaitHelper;
import com.jcraft.jsch.*;

/**
 * This class represent the execution of an SSH command.
 */
public class SshExecution {
    private final Channel channel;
    private final String command;
    private final InputStream stdErrStream;
    private final InputStream stdOutStream;

    /**
     * Create a new {@link SshExecution}.
     * 
     * @param session ssh session
     * @param command command to execute (on a sh shell)
     */
    SshExecution(final Session session, final String command) {
        this.command = command;
        try {
            this.channel = session.openChannel("exec");
            ((ChannelExec) this.channel).setCommand(command);
            this.channel.setInputStream(null);
            this.stdErrStream = ((ChannelExec) this.channel).getErrStream();
            this.stdOutStream = this.channel.getInputStream();
            this.channel.connect();
        } catch (final JSchException | IOException exception) {
            throw new IllegalStateException(
                    ExaError.messageBuilder("E-ETAJ-20").message("Failed to run command via ssh.").toString(),
                    exception);
        }
    }

    private SshExecutionResult readAllOutputAndWaitForExit(final String command, final Channel channel,
            final InputStream stdErrStream, final InputStream stdOutStream) {
        try {
            final StringBuilder stdout = new StringBuilder();
            while (channel.isClosed()) {
                stdout.append(new String(stdOutStream.readAllBytes(), StandardCharsets.UTF_8));
                WaitHelper.waitFor(100);
            }
            stdout.append(new String(stdOutStream.readAllBytes(), StandardCharsets.UTF_8));// read remaining
            return new SshExecutionResult(stdout.toString(),
                    new String(stdErrStream.readAllBytes(), StandardCharsets.UTF_8), channel.getExitStatus(), command);
        } catch (final IOException exception) {
            throw new IllegalStateException(
                    ExaError.messageBuilder("E-ETAJ-26")
                            .message("Failed to read output of ssh command {{command}}.", command).toString(),
                    exception);
        }
    }

    /**
     * Method to wait until the execution finished.
     * 
     * @return execution result
     */
    public SshExecutionResult whenFinished() {
        final SshExecutionResult result = readAllOutputAndWaitForExit(this.command, this.channel, this.stdErrStream,
                this.stdOutStream);
        this.channel.disconnect();
        return result;
    }
}
