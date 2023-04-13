# Exasol Test Setup Abstraction Java 2.0.1, released 2023-04-13

Code name: Fix container reuse

## Summary

This release fixes an issue with reusing containers caused by [exasol-testcontainers #220](https://github.com/exasol/exasol-testcontainers/issues/220). It also removes duplicate classes from dependencies by replacing JSON library `org.glassfish:jakarta.json` with `org.eclipse.parsson:parsson`.

## Bugfixes

* #55: Fixed reusing containers with SSH credentials

## Dependency Updates

### Compile Dependency Updates

* Updated `com.exasol:bucketfs-java:2.6.0` to `3.1.0`
* Updated `com.exasol:error-reporting-java:1.0.0` to `1.0.1`
* Updated `com.exasol:exasol-testcontainers:6.5.0` to `6.5.2`
* Updated `software.amazon.awssdk:cloudformation:2.19.18` to `2.20.44`
* Updated `software.amazon.awssdk:ec2:2.19.18` to `2.20.44`

### Runtime Dependency Updates

* Added `org.eclipse.parsson:parsson:1.1.1`
* Removed `org.glassfish:jakarta.json:2.0.1`

### Test Dependency Updates

* Updated `nl.jqno.equalsverifier:equalsverifier:3.12.3` to `3.14.1`
* Added `org.slf4j:slf4j-jdk14:2.0.7`

### Plugin Dependency Updates

* Updated `com.exasol:error-code-crawler-maven-plugin:1.2.1` to `1.2.2`
* Updated `com.exasol:project-keeper-maven-plugin:2.9.1` to `2.9.6`
* Updated `org.apache.maven.plugins:maven-deploy-plugin:3.0.0` to `3.1.0`
* Updated `org.apache.maven.plugins:maven-enforcer-plugin:3.1.0` to `3.2.1`
* Updated `org.apache.maven.plugins:maven-failsafe-plugin:3.0.0-M7` to `3.0.0-M8`
* Updated `org.apache.maven.plugins:maven-surefire-plugin:3.0.0-M7` to `3.0.0-M8`
* Added `org.basepom.maven:duplicate-finder-maven-plugin:1.5.1`
* Updated `org.codehaus.mojo:versions-maven-plugin:2.13.0` to `2.14.2`
