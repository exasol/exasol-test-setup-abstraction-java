# Exasol Test Setup Abstraction Java 2.1.3, released 2024-04-16

Code name: Fix SSH connection to Exasol Docker container 8.25.0 and later

## Summary

This release fixes error `JSchException: Algorithm negotiation fail` when starting an Exasol Docker container 8.25.0 and later.

## Bugfixes

* #75: Fixed SSH connection to Exasol Docker container 8.25.0 and later

## Dependency Updates

### Compile Dependency Updates

* Added `com.github.mwiede:jsch:0.2.17`
* Removed `com.jcraft:jsch:0.1.55`
* Updated `software.amazon.awssdk:cloudformation:2.25.26` to `2.25.31`
* Updated `software.amazon.awssdk:ec2:2.25.26` to `2.25.31`

### Test Dependency Updates

* Updated `org.slf4j:slf4j-jdk14:2.0.12` to `2.0.13`
