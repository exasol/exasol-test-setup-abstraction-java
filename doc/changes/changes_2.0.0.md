# Exasol Test Setup Abstraction Java 2.0.0, released 2023-01-18

Code name: Replace ServiceAddress by InetSocketAddress

## Summary

This release replaces the custom class `ServiceAddress` by the JRE class `InetSocketAddress`.

This is a breaking change because the API changes.

## Refactoring

* #32: Replaced ServiceAddress by InetSocketAddress

## Dependency Updates

### Compile Dependency Updates

* Updated `com.exasol:database-cleaner:1.0.2` to `1.1.0`
* Updated `com.exasol:exasol-testcontainers:6.4.1` to `6.5.0`
* Updated `software.amazon.awssdk:cloudformation:2.19.0` to `2.19.18`
* Updated `software.amazon.awssdk:ec2:2.19.0` to `2.19.18`

### Test Dependency Updates

* Updated `org.junit.jupiter:junit-jupiter-engine:5.9.1` to `5.9.2`
* Updated `org.junit.jupiter:junit-jupiter-params:5.9.1` to `5.9.2`
