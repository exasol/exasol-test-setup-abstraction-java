package com.myorg;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import org.jetbrains.annotations.NotNull;

import com.google.gson.Gson;

import software.amazon.awscdk.services.iam.PolicyDocument;

/**
 * This class reads a policy document from a JSON file from the resources.
 * <p>
 * For information on how to generate these files check the README.md.
 * </p>
 */
public class PolicyReader {
    /**
     * Read a policy document from file in the resources.
     * 
     * @param resourceName name of the resource
     * @return read policy document
     */
    public @NotNull PolicyDocument readPolicyFromResources(final String resourceName) {
        final String policyString = getResourceAsString(resourceName);
        final Object policyJson = (new Gson()).fromJson(policyString, Object.class);
        return PolicyDocument.fromJson(policyJson);
    }

    private String getResourceAsString(final String resourceName) {
        try (final InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(resourceName)) {
            return new String(Objects.requireNonNull(resourceAsStream).readAllBytes(), StandardCharsets.UTF_8);
        } catch (final IOException exception) {
            throw new IllegalStateException(exception);
        }
    }
}
