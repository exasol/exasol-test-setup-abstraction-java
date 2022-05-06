package com.exasol.exasoltestsetup;

import lombok.Data;

/**
 * This class contains information for connecting to the SQL interface.
 */
@Data
public class SqlConnectionInfo {
    private final String host;
    private final int port;
    private final String user;
    private final String password;
}
