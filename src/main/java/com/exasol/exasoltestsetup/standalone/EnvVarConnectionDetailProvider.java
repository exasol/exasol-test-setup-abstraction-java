package com.exasol.exasoltestsetup.standalone;

import java.util.logging.Logger;

import com.exasol.errorreporting.ExaError;

/**
 * This {@link ConnectionDetailProvider} provides connection details for an Exasol database from environment variables.
 */
public class EnvVarConnectionDetailProvider implements ConnectionDetailProvider {
    public static final int SSH_DEFAULT_PORT = 22;
    private static final Logger LOGGER = Logger.getLogger(EnvVarConnectionDetailProvider.class.getName());
    private final String datanodeIp;
    private final String managementIp;
    private final Credentials databaseCredentials;
    private final Credentials adminCredentials;
    private final int sshPort;

    /**
     * Create a new instance of {@link EnvVarConnectionDetailProvider}.
     */
    public EnvVarConnectionDetailProvider() {
        this.databaseCredentials = new Credentials(getEnvVarWithCheck("EXASOL_USER"),
                getEnvVarWithCheck("EXASOL_PASS"));
        this.adminCredentials = new Credentials(getEnvVarWithCheck("EXASOL_ADMIN_USER"),
                getEnvVarWithCheck("EXASOL_ADMIN_PASS"));
        this.datanodeIp = getEnvVarWithCheck("EXASOL_DATANODE_IP");
        this.managementIp = getEnvVarWithCheck("EXASOL_MANAGEMENT_IP");
        this.sshPort = readSshPort();
    }

    private int readSshPort() {
        final String envValue = System.getenv("EXASOL_SSH_PORT");
        if (isUndefined(envValue)) {
            LOGGER.info("The environment variable EXASOL_SSH_PORT was not set. Falling back to default port "
                    + SSH_DEFAULT_PORT + ".");
            return SSH_DEFAULT_PORT;
        } else {
            try {
                return Integer.parseInt(envValue);
            } catch (final NumberFormatException exception) {
                throw new IllegalArgumentException(ExaError.messageBuilder("E-ETAJ-25")
                        .message("Invalid value {{value}} for EXASOL_SSH_PORT environment variable.", envValue)
                        .mitigation("The value must be a number.").toString());
            }
        }
    }

    private boolean isUndefined(final String value) {
        return value == null || value.isEmpty();
    }

    private String getEnvVarWithCheck(final String variableName) {
        final String value = System.getenv(variableName);
        if (value == null) {
            throw new IllegalStateException(
                    ExaError.messageBuilder("E-ETAJ-15").message("Undeclared environment variable {{variable}}.")
                            .mitigation("Please set the required variable {{variable}}.")
                            .parameter("variable", variableName).toString());
        }
        return value;
    }

    @Override
    public String getManagementNodeIp() {
        return this.managementIp;
    }

    @Override
    public String getDataNodeIp() {
        return this.datanodeIp;
    }

    @Override
    public Credentials getDatabaseCredentials() {
        return this.databaseCredentials;
    }

    @Override
    public Credentials getAdminCredentials() {
        return this.adminCredentials;
    }

    @Override
    public int getSshPort() {
        return this.sshPort;
    }
}
