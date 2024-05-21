package com.exasol.exasoltestsetup.testcontainers;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.exasol.containers.DockerImageReferenceFactory;

class ExasolTestcontainerTestSetupTest {

    @ParameterizedTest
    @CsvSource({ //
            "6.0.30, 22", //
            "7.1.26, 22", //
            "7.1.27, 22", //
            "7.1.28, 22", //
            "8.26.0, 22", //
            "8.26.1, 22", //
            "8.27.0, 20002", //
            "8.28.0, 20002", //
            "9.0.0, 20002", //
            "9.0.1, 20002", //
            "9.1.1, 20002", //
    })
    void testStart(final String version, final int expectedPort) {
        assertThat(ExasolTestcontainerTestSetup.getSshPort(DockerImageReferenceFactory.parse(version)),
                equalTo(expectedPort));
    }
}
