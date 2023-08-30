package com.exasol.exasoltestsetup;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import com.exasol.exasoltestsetup.ExasolTestSetupFactory.DispatchMode;

/**
 * Unit test for the test setup factory.
 * <p>
 * Note that this test only checks the construction of the factory itself. Since the method
 * {@link ExasolTestSetupFactory#getTestSetup()} automatically spins up a real test environment, the corresponding test
 * is an integration test that you can find in {@code ExasolTestSetupFactoryIT}.
 * </p>
 */
class ExasolTestSetupFactoryTest {
    @Test
    void testHasStandaloneConfigurationPathFalse() {
        final ExasolTestSetupFactory factory = new ExasolTestSetupFactory();
        assertThat(factory.hasStandaloneConfigurationPath(), equalTo(false));
    }

    @Test
    void testHasStandaloneConfigurationPathTrue(@TempDir final Path tempDir) throws IOException {
        final Path configurationFileDummy = Files.writeString(tempDir.resolve("dummy.conf"), "never mind");
        final ExasolTestSetupFactory factory = new ExasolTestSetupFactory(configurationFileDummy);
        assertThat(factory.hasStandaloneConfigurationPath(), equalTo(true));
    }

    @Test
    void testForcedStandaloneModeThrowsExceptionIfConfigFileIsMissing(@TempDir final Path tempDir) {
        final Path nonExistentConfiguration = tempDir.resolve("missing.conf");
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new ExasolTestSetupFactory(nonExistentConfiguration, DispatchMode.STANDALONE));
        assertThat(exception.getMessage(), containsString("configuration file '" + nonExistentConfiguration
                + "' required for a for a standalone test setup does not exist"));
    }

    @Test
    void testForcedStandaloneModeThrowsExceptionIfConfigFileIsNull() {
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new ExasolTestSetupFactory(null, DispatchMode.STANDALONE));
        assertThat(exception.getMessage(), containsString(
                "configuration file parameter must not be NULL " + "for a for a standalone test setup does not exist"));
    }
}
