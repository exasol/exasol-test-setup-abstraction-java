package com.exasol.exasoltestsetup;

import static java.util.logging.Level.INFO;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Logger;

import com.exasol.exasoltestsetup.standalone.JsonConnectionDetailsReader;
import com.exasol.exasoltestsetup.standalone.StandaloneExasolTestSetup;
import com.exasol.exasoltestsetup.testcontainers.ExasolTestcontainerTestSetup;

/**
 * This class checks dispatches between and Standalone (AWS) test-setup and a test container test setup.
 * <p>
 * As a decision criteria it uses the existence of the test config file for the standalone setup.
 * </p>
 */
public class ExasolTestSetupFactory {
    private static final Logger LOGGER = Logger.getLogger(ExasolTestSetupFactory.class.getName());
    private final Path standaloneConfig;

    /**
     * Create a new instance of {@link ExasolTestSetupFactory}.
     * 
     * @param standaloneConfig path to the standalone config file.s
     */
    public ExasolTestSetupFactory(final Path standaloneConfig) {
        this.standaloneConfig = standaloneConfig;
    }

    /**
     * Get an {@link ExasolTestSetup}.
     * <p>
     * If the specified standalone config file exists this method returns a Standalone test setup. Otherwise a
     * test-container test setup.
     * </p>
     * 
     * @return {@link ExasolTestSetup}
     */
    public ExasolTestSetup getTestSetup() {
        if (Files.exists(this.standaloneConfig)) {
            LOGGER.log(INFO, "Using Standalone test-setup.");
            return new StandaloneExasolTestSetup(new JsonConnectionDetailsReader().read(this.standaloneConfig));
        } else {
            LOGGER.log(INFO, "Using testcontainer exasol test setup since config file {0} does not exist.",
                    this.standaloneConfig);
            return new ExasolTestcontainerTestSetup();
        }
    }
}
