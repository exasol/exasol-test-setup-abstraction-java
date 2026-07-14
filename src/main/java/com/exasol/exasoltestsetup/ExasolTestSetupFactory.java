package com.exasol.exasoltestsetup;

import java.nio.file.Path;
import java.util.logging.Logger;

import com.exasol.errorreporting.ExaError;
import com.exasol.exasoltestsetup.testcontainers.ExasolTestcontainerTestSetup;

/**
 * This class creates either Standalone (AWS) test setup and a test container test setup.
 * <p>
 * As a decision criteria it uses the existence of the test config file for the standalone setup.
 * </p>
 */
public class ExasolTestSetupFactory {
    private static final Logger LOGGER = Logger.getLogger(ExasolTestSetupFactory.class.getName());
    private final Path standaloneConfigurationPath;
    private final DispatchMode dispatchMode;

    /**
     * Dispatching modes for the test setup.
     */
    public enum DispatchMode {
        /** Dispatch depending on the existence of the configuration file */
        AUTO,
        /** Force test container setup */
        CONTAINER,
        /** Force standalone setup */
        STANDALONE
    }

    /**
     * Create a new instance of an {@link ExasolTestSetupFactory}.
     * <p>
     * Note that if you use this constructor, the factory will decide whether to start a container or a cloud setup
     * based on the existence of the configuration file at the given path. If the file is not there, we automatically
     * fall back to an Exasol container.
     * </p>
     * <p>
     * Please use {@link ExasolTestSetupFactory#ExasolTestSetupFactory(Path, DispatchMode)} with dispatching mode set to
     * {@link DispatchMode#STANDALONE} if you want to enforce using a cloud setup instead.
     * </p>
     *
     * @param standaloneConfigurationPath path to the standalone configuration file
     */
    public ExasolTestSetupFactory(final Path standaloneConfigurationPath) {
        this(standaloneConfigurationPath, DispatchMode.AUTO);
    }

    /**
     * Create a new instance of an {@link ExasolTestSetupFactory}.
     * <p>
     * Creates a test setup based on the Exasol Test Container.
     * </p>
     */
    public ExasolTestSetupFactory() {
        this(null, DispatchMode.CONTAINER);
    }

    /**
     * Create a new instance of an {@link ExasolTestSetupFactory}.
     *
     * @param standaloneConfigurationPath path to the standalone configuration file
     * @param dispatchMode                defines a rule for how the test setup should be determined
     */
    public ExasolTestSetupFactory(final Path standaloneConfigurationPath, final DispatchMode dispatchMode) {
        if (dispatchMode == DispatchMode.STANDALONE) {
            if (standaloneConfigurationPath == null) {
                throw new IllegalArgumentException(ExaError.messageBuilder("E-ETAJ-37")
                        .message("The configuration file parameter must not be NULL "
                                + "for a for a standalone test setup does not exist.")
                        .mitigation("Create the configuration file and make sure the path is provided.")
                        .mitigation("Pick a dispatch mode that does not depend on this file (either CONTAINER or AUTO)")
                        .toString());
            } else {
                throw new IllegalArgumentException(ExaError.messageBuilder("E-ETAJ-38")
                        .message("The configuration file {{file}} "
                                + "required for a for a standalone test setup does not exist.")
                        .parameter("file", standaloneConfigurationPath.toString(), "path to the configuration file")
                        .mitigation("Create the configuration file and make sure the path is correct.")
                        .mitigation("Pick a dispatch mode that does not depend on this file (either CONTAINER or AUTO)")
                        .toString());

            }
        } else {
            this.standaloneConfigurationPath = standaloneConfigurationPath;
            this.dispatchMode = dispatchMode;
        }
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
        switch (this.dispatchMode) {
        case CONTAINER:
            LOGGER.info(() -> "Using Exasol test container setup (forced container mode)");
            return ExasolTestcontainerTestSetup.start();
        case STANDALONE:
        case AUTO: // Currently only test containers are supported
            LOGGER.info(() -> "Using Exasol standalone test setup (forced standalone mode)");
            return ExasolTestcontainerTestSetup.start();
        default:
            throw new IllegalArgumentException(
                    "Unknown Dispatcher Mode '" + this.dispatchMode + "' trying to create test setup");
        }
    }

    /**
     * Check if the path to the standalone configuration was provided.
     *
     * @return {@code true} if the path to the configuration file was provided
     */
    public boolean hasStandaloneConfigurationPath() {
        return this.standaloneConfigurationPath != null;
    }
}
