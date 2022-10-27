package com.exasol.exasoltestsetup.standalone;

import java.nio.file.Path;
import java.util.Objects;

/**
 * This class stores connection details for an Exasol database.
 */
public class ConnectionDetails {
    private final String managementNodeAddress;
    private final String dataNodeAddress;
    private final Credentials databaseCredentials;
    private final Credentials adminCredentials;
    private final int sshPort;
    private final Path pathToSshKey;

    private ConnectionDetails(final Builder builder) {
        this.managementNodeAddress = builder.managementNodeAddress;
        this.dataNodeAddress = builder.dataNodeAddress;
        this.databaseCredentials = builder.databaseCredentials;
        this.adminCredentials = builder.adminCredentials;
        this.sshPort = builder.sshPort;
        this.pathToSshKey = builder.pathToSshKey;
    }

    /**
     * Get the address of the management node.
     *
     * @return management node address
     */
    public String getManagementNodeAddress() {
        return this.managementNodeAddress;
    }

    /**
     * Get the address of the data node.
     *
     * @return data node address
     */
    public String getDataNodeAddress() {
        return this.dataNodeAddress;
    }

    /**
     * Get the credentials for connecting to the database.
     *
     * @return database credentials
     */
    public Credentials getDatabaseCredentials() {
        return this.databaseCredentials;
    }

    /**
     * Get the credentials for connecting to the admin interface.
     *
     * @return admin credentials
     */
    public Credentials getAdminCredentials() {
        return this.adminCredentials;
    }

    /**
     * Get the port for connecting via SSH.
     *
     * @return SSH port
     */
    public int getSshPort() {
        return this.sshPort;
    }

    /**
     * Get the path to the private SSH key.
     *
     * @return path to the private SSH key
     */
    public Path getPathToSshKey() {
        return this.pathToSshKey;
    }

    @Override
    public String toString() {
        return "ConnectionDetails [managementNodeAddress=" + this.managementNodeAddress + ", dataNodeAddress="
                + this.dataNodeAddress + ", databaseCredentials=" + this.databaseCredentials + ", adminCredentials="
                + this.adminCredentials + ", sshPort=" + this.sshPort + ", pathToSshKey=" + this.pathToSshKey + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.adminCredentials, this.dataNodeAddress, this.databaseCredentials,
                this.managementNodeAddress, this.pathToSshKey, this.sshPort);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ConnectionDetails other = (ConnectionDetails) obj;
        return Objects.equals(this.adminCredentials, other.adminCredentials)
                && Objects.equals(this.dataNodeAddress, other.dataNodeAddress)
                && Objects.equals(this.databaseCredentials, other.databaseCredentials)
                && Objects.equals(this.managementNodeAddress, other.managementNodeAddress)
                && Objects.equals(this.pathToSshKey, other.pathToSshKey) && (this.sshPort == other.sshPort);
    }

    /**
     * Creates builder to build {@link ConnectionDetails}.
     *
     * @return created builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder to build {@link ConnectionDetails}.
     */
    public static final class Builder {
        private String managementNodeAddress;
        private String dataNodeAddress;
        private Credentials databaseCredentials;
        private Credentials adminCredentials;
        private int sshPort;
        private Path pathToSshKey;

        private Builder() {
        }

        /**
         * Builder method for managementNodeAddress parameter.
         *
         * @param managementNodeAddress field to set
         * @return builder
         */
        public Builder managementNodeAddress(final String managementNodeAddress) {
            this.managementNodeAddress = managementNodeAddress;
            return this;
        }

        /**
         * Builder method for dataNodeAddress parameter.
         *
         * @param dataNodeAddress field to set
         * @return builder
         */
        public Builder dataNodeAddress(final String dataNodeAddress) {
            this.dataNodeAddress = dataNodeAddress;
            return this;
        }

        /**
         * Builder method for databaseCredentials parameter.
         *
         * @param databaseCredentials field to set
         * @return builder
         */
        public Builder databaseCredentials(final Credentials databaseCredentials) {
            this.databaseCredentials = databaseCredentials;
            return this;
        }

        /**
         * Builder method for adminCredentials parameter.
         *
         * @param adminCredentials field to set
         * @return builder
         */
        public Builder adminCredentials(final Credentials adminCredentials) {
            this.adminCredentials = adminCredentials;
            return this;
        }

        /**
         * Builder method for sshPort parameter.
         *
         * @param sshPort field to set
         * @return builder
         */
        public Builder sshPort(final int sshPort) {
            this.sshPort = sshPort;
            return this;
        }

        /**
         * Builder method for pathToSshKey parameter.
         *
         * @param pathToSshKey field to set
         * @return builder
         */
        public Builder pathToSshKey(final Path pathToSshKey) {
            this.pathToSshKey = pathToSshKey;
            return this;
        }

        /**
         * Builder method of the builder.
         *
         * @return built class
         */
        public ConnectionDetails build() {
            return new ConnectionDetails(this);
        }
    }
}
