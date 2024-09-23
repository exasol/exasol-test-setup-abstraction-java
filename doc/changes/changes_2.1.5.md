# Exasol Test Setup Abstraction Java 2.1.5, released 2024-09-23

Code name: Fix `NullPointerException` with Docker DB >= 8.29.1

## Summary

This release fixes a `NullPointerException` when launching Exasol Docker DB >= 8.29.1.

## Features

* #84: Fixed `NullPointerException` when launching Exasol Docker DB >= 8.29.1

## Dependency Updates

### Compile Dependency Updates

* Updated `com.exasol:bucketfs-java:3.1.2` to `3.2.0`
* Updated `com.exasol:exasol-testcontainers:7.1.0` to `7.1.1`
* Updated `com.github.mwiede:jsch:0.2.17` to `0.2.20`
* Updated `software.amazon.awssdk:cloudformation:2.25.56` to `2.28.6`
* Updated `software.amazon.awssdk:ec2:2.25.56` to `2.28.6`

### Runtime Dependency Updates

* Updated `org.eclipse.parsson:parsson:1.1.6` to `1.1.7`

### Test Dependency Updates

* Updated `nl.jqno.equalsverifier:equalsverifier:3.16.1` to `3.16.2`
* Updated `org.hamcrest:hamcrest:2.2` to `3.0`
* Updated `org.junit.jupiter:junit-jupiter-engine:5.10.2` to `5.11.0`
* Updated `org.junit.jupiter:junit-jupiter-params:5.10.2` to `5.11.0`
* Updated `org.slf4j:slf4j-jdk14:2.0.13` to `2.0.16`

### Plugin Dependency Updates

* Updated `com.exasol:project-keeper-maven-plugin:4.3.1` to `4.3.3`
* Updated `org.apache.maven.plugins:maven-enforcer-plugin:3.4.1` to `3.5.0`
* Updated `org.apache.maven.plugins:maven-javadoc-plugin:3.6.3` to `3.7.0`
* Updated `org.sonarsource.scanner.maven:sonar-maven-plugin:3.11.0.3922` to `4.0.0.4121`
* Updated `org.sonatype.plugins:nexus-staging-maven-plugin:1.6.13` to `1.7.0`
