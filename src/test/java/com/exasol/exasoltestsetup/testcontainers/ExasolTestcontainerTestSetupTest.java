package com.exasol.exasoltestsetup.testcontainers;

import com.exasol.exasoltestsetup.ExasolTestSetup;
import com.exasol.exasoltestsetup.ExasolTestSetupTestBase;

public class ExasolTestcontainerTestSetupTest extends ExasolTestSetupTestBase {

    @Override
    protected ExasolTestSetup getExasolTestSetup() {
        return new ExasolTestcontainerTestSetup();
    }
}