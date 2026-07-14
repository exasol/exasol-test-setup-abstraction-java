package com.exasol.exasoltestsetup;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import com.exasol.exasoltestsetup.testcontainers.ExasolTestcontainerTestSetup;

class ExasolTestSetupFactoryIT {
    @Test
    void testGetTestcontainerSetup(@TempDir final Path tempDir) {
        final ExasolTestSetup testSetup = new ExasolTestSetupFactory(tempDir.resolve("config.json")).getTestSetup();
        assertThat(testSetup, instanceOf(ExasolTestcontainerTestSetup.class));
    }
}