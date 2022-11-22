# exasol-test-setup-abstraction-java 1.0.1, released 2022-11-22

Code name: Update on top of 1.0.0

## Summary

We fixed a version conflict in the BucketFS library between this project and `udf-debugging-java` that led to a class-not-found error by updating to the latest version of the `exasol-testcontainers`.

This update also fixes a problem when the `target` directory does not exist in a project using this library. 

## Features

* #48: Fixed version conflicts by updating
* #46: Fixed problem with missing `target` directory by updating `exasol-testcontainers`

## Dependency Updates

### Compile Dependency Updates

* Updated `com.exasol:exasol-testcontainers:6.3.0` to `6.3.1`
* Updated `fr.turri:aXMLRPC:1.12.0` to `1.13.0`
* Updated `software.amazon.awssdk:cloudformation:2.18.3` to `2.18.22`
* Updated `software.amazon.awssdk:ec2:2.18.3` to `2.18.22`

### Test Dependency Updates

* Updated `nl.jqno.equalsverifier:equalsverifier:3.10.1` to `3.11.1`

### Plugin Dependency Updates

* Updated `com.exasol:error-code-crawler-maven-plugin:1.1.2` to `1.2.1`
* Updated `com.exasol:project-keeper-maven-plugin:2.8.0` to `2.9.1`
* Updated `io.github.zlika:reproducible-build-maven-plugin:0.15` to `0.16`
* Updated `org.apache.maven.plugins:maven-deploy-plugin:3.0.0-M1` to `3.0.0`
* Updated `org.apache.maven.plugins:maven-failsafe-plugin:3.0.0-M5` to `3.0.0-M7`
* Updated `org.apache.maven.plugins:maven-javadoc-plugin:3.4.0` to `3.4.1`
* Updated `org.apache.maven.plugins:maven-surefire-plugin:3.0.0-M5` to `3.0.0-M7`
* Updated `org.codehaus.mojo:flatten-maven-plugin:1.2.7` to `1.3.0`
* Updated `org.codehaus.mojo:versions-maven-plugin:2.10.0` to `2.13.0`
