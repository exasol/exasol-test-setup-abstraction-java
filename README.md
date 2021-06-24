# Exasol Test Setup Abstraction

[![Build Status](https://travis-ci.com/exasol/exasol-test-setup-abstraction-java.svg?branch=main)](https://travis-ci.com/exasol/exasol-test-setup-abstraction-java)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=com.exasol%3Aexasol-test-setup-abstraction-java&metric=alert_status)](https://sonarcloud.io/dashboard?id=com.exasol%3Aexasol-test-setup-abstraction-java)

This repository defines a standardized interface for accessing an Exasol database for testing.

That allows you to write tests where you can to switch the test-backend. For example you can switch between an Exasol cluster in the cloud or a local docker-db.

In addition, it contains implementations for this interface for the following test-backends:

* Local - Docker (via Testcontainers)

## Usage

```java

class MyTest {
    private static final ExasolTestSetup EXASOL = new ExasolTestcontainerTestSetup();

    @Test
    void test() {
        var sqlConnection = Exasol.createConnection();
        //...
    }

    @AfterAll
    static void afterAll() {
        EXASOL.close();
    }
}
```

## Additional Information

* [Changelog](doc/changes/changelog.md)
* [Dependencies](dependencies.md)
