# Exasol Test Setup Abstraction Java 2.1.4, released 2024-05-22

Code name: Fix for Exasol Docker-DB 8.27.0

## Summary

This release fixes exception `JSchException: Algorithm negotiation fail` when starting an Exasol Docker DB version 8.27.0 or later.

The release also updates the default Exasol version to 8.27.0.

## Bugfixes

* #82: Fixed SSH connection for Exasol Docker DB version 8.27.0

## Dependency Updates

### Compile Dependency Updates

* Updated `com.exasol:exasol-testcontainers:7.0.1` to `7.1.0`
* Updated `software.amazon.awssdk:cloudformation:2.25.31` to `2.25.56`
* Updated `software.amazon.awssdk:ec2:2.25.31` to `2.25.56`

### Plugin Dependency Updates

* Updated `com.exasol:error-code-crawler-maven-plugin:2.0.2` to `2.0.3`
* Updated `com.exasol:project-keeper-maven-plugin:4.3.0` to `4.3.1`
* Updated `org.apache.maven.plugins:maven-deploy-plugin:3.1.1` to `3.1.2`
* Updated `org.apache.maven.plugins:maven-gpg-plugin:3.2.2` to `3.2.4`
* Updated `org.apache.maven.plugins:maven-toolchains-plugin:3.1.0` to `3.2.0`
