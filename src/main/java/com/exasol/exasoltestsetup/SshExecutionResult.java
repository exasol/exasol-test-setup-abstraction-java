package com.exasol.exasoltestsetup;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.exasol.errorreporting.ExaError;

/**
 * This class represents a result of a ssh command execution.
 */
public class SshExecutionResult {
    private static final java.util.logging.Logger LOGGER = Logger.getLogger(SshExecutionResult.class.getName());
    private final String stdout;
    private final String stderr;
    private final int exitCode;
    private final String command;

    /**
     * Create a new instance of {@link SshExecutionResult}.
     * 
     * @param stdout   command output on stdout
     * @param stderr   command output on stderr
     * @param exitCode command exit code
     * @param command  command (for exception message)
     */
    SshExecutionResult(final String stdout, final String stderr, final int exitCode, final String command) {
        this.stdout = stdout;
        this.stderr = stderr;
        this.exitCode = exitCode;
        this.command = command;
    }

    /**
     * Get the stdout output of the command.
     * 
     * @return stdout
     */
    public String getStdout() {
        return this.stdout;
    }

    /**
     * Get the exit code of the command.
     * 
     * @return exit code
     */
    public int getExitCode() {
        return this.exitCode;
    }

    /**
     * Check that the exit code was zero and if not print the stderr output and throw an exception.
     * 
     * @return self for fluent programming
     * @throws IllegalStateException if exit code was != 0
     */
    public SshExecutionResult assertExitCodeIsZero() {
        if (this.exitCode != 0) {
            LOGGER.log(Level.SEVERE, this.stderr);
            throw new IllegalStateException(ExaError.messageBuilder("E-ETAJ-19").message(
                    "Failed to run command {{command}} in database cluster. The command had a return code != 0.",
                    this.command).mitigation("See log output above.").toString());
        }
        return this;
    }
}
