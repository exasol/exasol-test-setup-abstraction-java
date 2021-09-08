package com.exasol.exasoltestsetup.standalone;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class JsonConnectionDetailsReaderTest {

    @Test
    void testRead(@TempDir final Path tempDir) throws IOException {
        final Path testConfigFile = tempDir.resolve("test-config.json");
        Files.copy(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("exampleTestConfig.json")),
                testConfigFile);
        final ConnectionDetails connectionDetails = new JsonConnectionDetailsReader().read(testConfigFile);
        assertAll(//
                () -> assertThat(connectionDetails.getDataNodeAddress(), equalTo("192.168.0.1")),
                () -> assertThat(connectionDetails.getManagementNodeAddress(), equalTo("192.168.0.2")),
                () -> assertThat(connectionDetails.getSshPort(), equalTo(22)),
                () -> assertThat(connectionDetails.getSshKey(), equalTo(Path.of("./exasol_cluster_ssh_key"))),
                () -> assertThat(connectionDetails.getDatabaseCredentials().getUsername(), equalTo("sys")),
                () -> assertThat(connectionDetails.getDatabaseCredentials().getPassword(), equalTo("myPass")),
                () -> assertThat(connectionDetails.getAdminCredentials().getUsername(), equalTo("admin")),
                () -> assertThat(connectionDetails.getAdminCredentials().getPassword(), equalTo("myAdminPass"))//
        );
    }
}