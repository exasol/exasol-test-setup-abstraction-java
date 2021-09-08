package com.exasol.exasoltestsetup.standalone;

import java.nio.file.Path;

import lombok.Builder;
import lombok.Data;

/**
 * This class stores connection details for an Exasol database.
 */
@Data
@Builder
public class ConnectionDetails {
    private String managementNodeAddress;
    private String dataNodeAddress;
    private Credentials databaseCredentials;
    private Credentials adminCredentials;
    private int sshPort;
    private Path sshKey;
}
