package com.exasol.exasoltestsetup.standalone;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.*;
import java.util.Objects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import jakarta.json.Json;
import jakarta.json.JsonObject;

class JsonConnectionDetailsReaderTest {

    private JsonConnectionDetailsReader reader;

    @BeforeEach
    void setup() {
        this.reader = new JsonConnectionDetailsReader();
    }

    @Test
    void testRead(@TempDir final Path tempDir) throws IOException {
        final Path testConfigFile = tempDir.resolve("test-config.json");
        Files.copy(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("exampleTestConfig.json")),
                testConfigFile);
        final ConnectionDetails connectionDetails = reader.read(testConfigFile);
        assertAll(//
                () -> assertThat(connectionDetails.getDataNodeAddress(), equalTo("192.168.0.1")),
                () -> assertThat(connectionDetails.getManagementNodeAddress(), equalTo("192.168.0.2")),
                () -> assertThat(connectionDetails.getSshPort(), equalTo(22)),
                () -> assertThat(connectionDetails.getPathToSshKey(), equalTo(Path.of("./exasol_cluster_ssh_key"))),
                () -> assertThat(connectionDetails.getDatabaseCredentials().getUsername(), equalTo("sys")),
                () -> assertThat(connectionDetails.getDatabaseCredentials().getPassword(), equalTo("myPass")),
                () -> assertThat(connectionDetails.getAdminCredentials().getUsername(), equalTo("admin")),
                () -> assertThat(connectionDetails.getAdminCredentials().getPassword(), equalTo("myAdminPass"))//
        );
    }

    @Test
    void testReadFileWithMissingProperties() {
        final JsonObject json = Json.createObjectBuilder().build();
        final Path configFile = Paths.get("file");
        final IllegalStateException exception = assertThrows(IllegalStateException.class,
                () -> reader.readDetails(configFile, json));
        assertThat(exception.getMessage(),
                equalTo("E-ETAJ-34: Missing attribute 'dataNodeAddress' in test-config-file 'file'."));
    }

    @Test
    void testReadMissingFile() {
        final Path configFile = Paths.get("missing-file");
        final UncheckedIOException exception = assertThrows(UncheckedIOException.class, () -> reader.read(configFile));
        assertThat(exception.getMessage(), equalTo("E-ETAJ-33: Failed to open test-config file 'missing-file'."));
    }
}