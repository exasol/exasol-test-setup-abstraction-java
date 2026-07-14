# Exasol Test Setup Abstraction

[![Build Status](https://github.com/exasol/exasol-test-setup-abstraction-java/actions/workflows/ci-build.yml/badge.svg)](https://github.com/exasol/exasol-test-setup-abstraction-java/actions/workflows/ci-build.yml)
[![Maven Central &ndash; exasol-test-setup-abstraction-java](https://img.shields.io/maven-central/v/com.exasol/exasol-test-setup-abstraction-java)](https://search.maven.org/artifact/com.exasol/exasol-test-setup-abstraction-java)

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=com.exasol%3Aexasol-test-setup-abstraction-java&metric=alert_status)](https://sonarcloud.io/dashboard?id=com.exasol%3Aexasol-test-setup-abstraction-java)

[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=com.exasol%3Aexasol-test-setup-abstraction-java&metric=security_rating)](https://sonarcloud.io/dashboard?id=com.exasol%3Aexasol-test-setup-abstraction-java)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=com.exasol%3Aexasol-test-setup-abstraction-java&metric=reliability_rating)](https://sonarcloud.io/dashboard?id=com.exasol%3Aexasol-test-setup-abstraction-java)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=com.exasol%3Aexasol-test-setup-abstraction-java&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=com.exasol%3Aexasol-test-setup-abstraction-java)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=com.exasol%3Aexasol-test-setup-abstraction-java&metric=sqale_index)](https://sonarcloud.io/dashboard?id=com.exasol%3Aexasol-test-setup-abstraction-java)

[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=com.exasol%3Aexasol-test-setup-abstraction-java&metric=code_smells)](https://sonarcloud.io/dashboard?id=com.exasol%3Aexasol-test-setup-abstraction-java)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=com.exasol%3Aexasol-test-setup-abstraction-java&metric=coverage)](https://sonarcloud.io/dashboard?id=com.exasol%3Aexasol-test-setup-abstraction-java)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=com.exasol%3Aexasol-test-setup-abstraction-java&metric=duplicated_lines_density)](https://sonarcloud.io/dashboard?id=com.exasol%3Aexasol-test-setup-abstraction-java)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=com.exasol%3Aexasol-test-setup-abstraction-java&metric=ncloc)](https://sonarcloud.io/dashboard?id=com.exasol%3Aexasol-test-setup-abstraction-java)

This repository defines a standardized interface for accessing an Exasol database for testing.

That allows you to write tests where you can switch the test-backend.

> [!ATTENTION]
> Since version 3.0.0 only the local deployment works. The AWS mechanism this library was based on does not exist anymore.
> Future versions will add SaaS and / or Exasol Personal support.

In addition, it contains implementations for this interface for the following test-backends:

* Local - Docker (via Testcontainers)

## Usage

```java
class MyTest {
    private static final ExasolTestSetup EXASOL = new ExasolTestSetupFactory().getTestSetup();

    @Test
    void test() {
        var sqlConnection = EXASOL.createConnection();
        //...
    }

    @AfterAll
    static void afterAll() {
        EXASOL.close();
    }
}
```

The `ExasolTestSetupFactory` in the example returns a test setup based on a local running Exasol-Testcontainer.

You can also select a specific test-setup in code. For that simply replace `new ExasolTestSetupFactory().getTestSetup()` by `new ExasolTestcontainerTestSetup()`.

To change the Exasol Docker DB version being used you can define the `com.exasol.dockerdb.image` system property,  e.g: `mvn verify -Dcom.exasol.dockerdb.image=${{ matrix.docker_db_version }}`.

## Information for Users of This Library

* [Changelog](doc/changes/changelog.md)

## Information for Developers of This Library

* [Dependencies](dependencies.md)
