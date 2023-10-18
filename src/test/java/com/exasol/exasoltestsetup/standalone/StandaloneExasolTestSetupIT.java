package com.exasol.exasoltestsetup.standalone;

import java.nio.file.Path;

import org.junit.jupiter.api.Tag;

import com.exasol.exasoltestsetup.*;

/**
 * This test requires a running Exasol cluster. Please start the cluster first by running <i>terraform apply</i> in
 * <i>cloudSetup/</i>. Terraform will then write the credentials into <i>setEnv.sh</i>. By executing this script you can
 * setup the environment variables. (Tip: run <i>. ./setEnv.sh</i> to set the variable in a shell). Next start your IDE
 * or tests in the same shell so that this test can read the configuration from the environment variables. In the CI
 * this process is done automatically.
 */
@Tag("cloudOnly")
class StandaloneExasolTestSetupIT extends ExasolTestSetupTestBase {
    @Override
    protected ExasolTestSetup getExasolTestSetup() {
        ExasolVersionCheck.assumeExasol71();
        return new StandaloneExasolTestSetup(
                new JsonConnectionDetailsReader().read(Path.of("cloudSetup/generated/testConfig.json")));
    }
}
