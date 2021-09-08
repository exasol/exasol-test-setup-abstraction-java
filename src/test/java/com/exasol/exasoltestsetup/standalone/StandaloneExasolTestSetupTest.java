package com.exasol.exasoltestsetup.standalone;

import java.nio.file.Path;

import com.exasol.exasoltestsetup.ExasolTestSetup;
import com.exasol.exasoltestsetup.ExasolTestSetupTestBase;

/**
 * This test requires a running Exasol cluster. Please start the cluster first by running <i>terraform apply</i> in
 * <i>cloudSetup/</i>. Terraform will the write the credentials into <i>setEnv.sh</i>. By executing this script you can
 * setup the environment variables. (Tip: run <i>. ./setEnv.sh</i> to set the variable in a shell). Next start your IDE
 * or tests in the same shell to that this test can read the configuration from the environment variables. In the CI
 * this process is done automatically.
 */
class StandaloneExasolTestSetupTest extends ExasolTestSetupTestBase {
    protected ExasolTestSetup getExasolTestSetup() {
        return new StandaloneExasolTestSetup(
                new JsonConnectionDetailsReader().read(Path.of("cloudSetup/generated/testConfig.json")));
    }
}