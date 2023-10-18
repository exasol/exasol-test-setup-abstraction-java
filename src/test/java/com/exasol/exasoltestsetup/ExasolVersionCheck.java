package com.exasol.exasoltestsetup;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class ExasolVersionCheck {
    public static void assumeExasol71() {
        final String versionOverride = System.getProperty("com.exasol.dockerdb.image");
        assumeTrue(versionOverride == null || versionOverride.startsWith("7.1"),
                "Skipping standalone tests for Exasol version " + versionOverride);
    }
}
