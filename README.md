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

That allows you to write tests where you can switch the test-backend. For example you can switch between an Exasol cluster in the cloud or a local docker-db.

In addition, it contains implementations for this interface for the following test-backends:

* Local - Docker (via Testcontainers)
* With an Exasol cluster on AWS

## Usage

```java
class MyTest {
    private static final ExasolTestSetup EXASOL = new ExasolTestSetupFactory("cloudSetup/generated/testConfig.json").getTestSetup();

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

The `ExasolTestSetupFactory` in the example returns a test setup for an AWS cluster if the specified config file (`cloudSetup/generated/testConfig.json`) exists. Otherwise, it returns a test setup based on a local running Exasol-Testcontainer.

Usually you generate the `testConfig.json` using the Terraform module [terraform-aws-exasol-test-setup >= 1.0.0](https://github.com/exasol/terraform-aws-exasol-test-setup/). For details see the [guide for setting up a project with cloud resources](doc/user_guide/setup_project_with_cloud_resources.md).

You can also select a specific test-setup in code. For that simply replace `new ExasolTestSetupFactory().getTestSetup()` by `new ExasolTestcontainerTestSetup()`.

## Information for Users of This Library

* [Guide for Setting up a Project With Cloud Resources](doc/user_guide/setup_project_with_cloud_resources.md)
* [Changelog](doc/changes/changelog.md)

## Information for Developers of This Library

* [Developer Guide](doc/developer_guide/developer_guide.md)
* [Dependencies](dependencies.md)
