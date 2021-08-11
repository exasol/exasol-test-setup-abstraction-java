package com.exasol.exasoltestsetup;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SshExecutionResultTest {
    @Test
    void testAssertExitCodeIsZero() {
        final SshExecutionResult result = new SshExecutionResult("", "", 0, "ls -l");
        assertDoesNotThrow(result::assertExitCodeIsZero);
    }

    @Test
    void testAssertExitCodeIsZeroException() {
        final SshExecutionResult result = new SshExecutionResult("", "something went wrong", 1, "ls -l");
        final IllegalStateException exception = assertThrows(IllegalStateException.class, result::assertExitCodeIsZero);
        assertThat(exception.getMessage(), equalTo(
                "E-ETAJ-19: Failed to run command 'ls -l' in database cluster. The command had a return code != 0. See log output above."));
    }

    @ParameterizedTest
    @ValueSource(ints = { 0, 1 })
    void testGetExitCode(final int exitCode) {
        final SshExecutionResult result = new SshExecutionResult("", "", exitCode, "");
        assertThat(result.getExitCode(), equalTo(exitCode));
    }
}