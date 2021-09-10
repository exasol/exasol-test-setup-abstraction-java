package com.exasol.exasoltestsetup.standalone;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * A set of credentials.
 */
@ToString
@EqualsAndHashCode
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
}
