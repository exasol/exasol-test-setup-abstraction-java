package com.exasol.exasoltestsetup;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import com.exasol.errorreporting.ExaError;
import com.exasol.exasoltestsetup.standalone.StandaloneExasolTestSetup;
import com.exasol.exasoltestsetup.testcontainers.ExasolTestcontainerTestSetup;

class ExasolTestSetupFactoryTest {

    @Test
    void testGetStandaloneTestSetup() {
        final Path configFile = Path.of("cloudSetup/generated/testConfig.json");
        if (!Files.exists(configFile)) {
            throw new IllegalStateException(ExaError.messageBuilder("E-ETAJ-35")
                    .message("Precondition failed: Missing test config file {{file}}.", configFile)
                    .mitigation("Deploy the terraform setup in /cloudSetup before running this test.").toString());
        }
        final ExasolTestSetup testSetup = new ExasolTestSetupFactory(configFile).getTestSetup();
        assertThat(testSetup, instanceOf(StandaloneExasolTestSetup.class));
    }

    @Test
    void testGetTestcontainerSetup(@TempDir final Path tempDir) {
        final ExasolTestSetup testSetup = new ExasolTestSetupFactory(tempDir.resolve("config.json")).getTestSetup();
        assertThat(testSetup, instanceOf(ExasolTestcontainerTestSetup.class));
    }
}