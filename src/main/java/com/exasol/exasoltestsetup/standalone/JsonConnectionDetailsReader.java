package com.exasol.exasoltestsetup.standalone;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

import com.exasol.errorreporting.ExaError;

import jakarta.json.*;

/**
 * This class reads {@link ConnectionDetails} from a JSON file.
 */
public class JsonConnectionDetailsReader {
    private static final int DEFAULT_SSH_PORT = 22;

    /**
     * Create a new instance of {@link JsonConnectionDetailsReader}.
     * 
     * @param configFile JSON test-config file
     * @return read {@link ConnectionDetails}
     */
    public ConnectionDetails read(final Path configFile) {
        final JsonObject jsonConfig = readJsonConfig(configFile);
        return ConnectionDetails.builder()//
                .dataNodeAddress(readRequiredAttribute(jsonConfig, "dataNodeAddress", configFile))//
                .managementNodeAddress(readRequiredAttribute(jsonConfig, "managementNodeAddress", configFile))//
                .sshPort(jsonConfig.getInt("sshPort", DEFAULT_SSH_PORT))//
                .pathToSshKey(Path.of(readRequiredAttribute(jsonConfig, "sshKey", configFile)))//
                .databaseCredentials(new Credentials(readRequiredAttribute(jsonConfig, "sqlUser", configFile),
                        readRequiredAttribute(jsonConfig, "sqlPass", configFile)))
                .adminCredentials(new Credentials(readRequiredAttribute(jsonConfig, "adminUser", configFile),
                        readRequiredAttribute(jsonConfig, "adminPass", configFile)))
                .build();
    }

    private String readRequiredAttribute(final JsonObject jsonConfig, final String attribute, final Path fileName) {

        final String attributeValue = jsonConfig.getString(attribute, null);
        if (attributeValue == null) {
            throw new IllegalStateException(ExaError.messageBuilder("E-ETAJ-34")
                    .message("Missing attribute {{attribute}} in test-config-file {{file}}.", attribute, fileName)
                    .toString());
        }
        return attributeValue;
    }

    private JsonObject readJsonConfig(final Path configFile) {
        try (final FileReader fileReader = new FileReader(configFile.toFile());
                final JsonReader jsonReader = Json.createReader(fileReader)) {
            return jsonReader.readObject();
        } catch (final IOException exception) {
            throw new IllegalStateException(
                    ExaError.messageBuilder("E-ETAJ-33").message("Failed to open test-config file.").toString(),
                    exception);
        }
    }
}
