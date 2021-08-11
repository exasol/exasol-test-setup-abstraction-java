package com.exasol.exasoltestsetup;

import static com.github.stefanbirkner.systemlambda.SystemLambda.withEnvironmentVariable;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.stream.Stream;

import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.exasol.exasoltestsetup.standalone.StandaloneExasolTestSetup;
import com.exasol.exasoltestsetup.testcontainers.ExasolTestcontainerTestSetup;

class ExasolTestSetupFactoryTest {

    static Stream<Arguments> testGetAwsSetupCases() {
        return Stream.of(//
                Arguments.of("aws", StandaloneExasolTestSetup.class), //
                Arguments.of("testcontainers", ExasolTestcontainerTestSetup.class), //
                Arguments.of("", ExasolTestcontainerTestSetup.class)//
        );
    }

    @ParameterizedTest
    @MethodSource("testGetAwsSetupCases")
    void testGetAwsSetup(final String envVarValue, final Class<?> expectedClass) throws Exception {
        final ExasolTestSetup testSetup = withEnvironmentVariable("EXASOL_TEST_BACKEND", envVarValue)
                .execute(() -> new ExasolTestSetupFactory().getTestSetup());
        assertThat(testSetup, Matchers.instanceOf(expectedClass));
    }
}