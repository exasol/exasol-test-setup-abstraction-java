package com.exasol.exasoltestsetup;

import java.util.Objects;

/**
 * This class contains information for connecting to the SQL interface.
 */
public class SqlConnectionInfo {
    private final String host;
    private final int port;
    private final String user;
    private final String password;

    /**
     * Create a new {@link SqlConnectionInfo} instance.
     *
     * @param host     host name
     * @param port     port number
     * @param user     user name
     * @param password password
     */
    public SqlConnectionInfo(final String host, final int port, final String user, final String password) {
        this.host = host;
        this.port = port;
        this.user = user;
        this.password = password;
    }

    /**
     * Get the host name.
     *
     * @return host name
     */
    public String getHost() {
        return this.host;
    }

    /**
     * Get the port number.
     *
     * @return port number
     */
    public int getPort() {
        return this.port;
    }

    /**
     * Get the user name.
     *
     * @return user name
     */
    public String getUser() {
        return this.user;
    }

    /**
     * Get the password.
     *
     * @return password
     */
    public String getPassword() {
        return this.password;
    }

    @Override
    public String toString() {
        return "SqlConnectionInfo [host=" + this.host + ", port=" + this.port + ", user=" + this.user + ", password="
                + this.password + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.host, this.password, this.port, this.user);
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
        final SqlConnectionInfo other = (SqlConnectionInfo) obj;
        return Objects.equals(this.host, other.host) && Objects.equals(this.password, other.password)
                && (this.port == other.port) && Objects.equals(this.user, other.user);
    }
}
