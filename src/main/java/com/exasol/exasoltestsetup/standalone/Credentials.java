package com.exasol.exasoltestsetup.standalone;

import java.util.Objects;

/**
 * A set of credentials.
 */
class Credentials {
    private final String username;
    private final String password;

    /**
     * Create a new instance of {@link Credentials}.
     *
     * @param username username
     * @param password password
     */
    Credentials(final String username, final String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Get the username.
     *
     * @return username
     */
    public String getUsername() {
        return this.username;
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
    public int hashCode() {
        return Objects.hash(this.password, this.username);
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
        final Credentials other = (Credentials) obj;
        return Objects.equals(this.password, other.password) && Objects.equals(this.username, other.username);
    }

    @Override
    public String toString() {
        return "Credentials [username=" + this.username + ", password=" + this.password + "]";
    }
}
