package com.exasol.exasoltestsetup.testcontainers;

import com.exasol.exasoltestsetup.ExasolTestSetup;
import com.exasol.exasoltestsetup.ExasolTestSetupTestBase;

public class ExasolTestcontainerTestSetupIT extends ExasolTestSetupTestBase {

    @Override
    protected ExasolTestSetup getExasolTestSetup() {
        return new ExasolTestcontainerTestSetup();
    }
}