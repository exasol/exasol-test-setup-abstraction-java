package com.exasol.exasoltestsetup;

import static java.util.logging.Level.INFO;

import java.util.logging.Logger;

import com.exasol.exasoltestsetup.standalone.EnvVarConnectionDetailProvider;
import com.exasol.exasoltestsetup.standalone.StandaloneExasolTestSetup;
import com.exasol.exasoltestsetup.testcontainers.ExasolTestcontainerTestSetup;

/**
 * This class decides which {@link ExasolTestSetup} to use based on a system property switch.
 */
public class ExasolTestSetupFactory {
    private static final Logger LOGGER = Logger.getLogger(ExasolTestSetupFactory.class.getName());

    /**
     * Get an {@link ExasolTestSetup} based on a environment variable switch.
     * 
     * @return {@link ExasolTestSetup}
     */
    public ExasolTestSetup getTestSetup() {
        final String property = System.getenv("EXASOL_TEST_BACKEND");
        if (property != null && property.equalsIgnoreCase("aws")) {
            LOGGER.log(INFO, "Using AWS exasol test setup.");
            return new StandaloneExasolTestSetup(new EnvVarConnectionDetailProvider());
        } else {
            LOGGER.log(INFO, "Using testcontainer exasol test setup.");
            return new ExasolTestcontainerTestSetup();
        }
    }
}
