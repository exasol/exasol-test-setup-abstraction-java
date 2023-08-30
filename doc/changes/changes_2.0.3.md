# Exasol Test Setup Abstraction Java 2.0.3, released 2023-08-30

Code name: Update Dependencies on top of 2.0.2

## Summary

This excludes vulnerability CVE-2023-4586 in transitive dependency `io.netty:netty-handler` as we assume that the AWS SDK's usage of netty is not affected.

## Security

* #63: Exclude vulnerability

## Dependency Updates

### Compile Dependency Updates

* Updated `com.exasol:exasol-testcontainers:6.6.0` to `6.6.1`
* Removed `io.netty:netty-handler:4.1.94.Final`
* Updated `software.amazon.awssdk:cloudformation:2.20.93` to `2.20.137`
* Updated `software.amazon.awssdk:ec2:2.20.93` to `2.20.137`

### Runtime Dependency Updates

* Updated `org.eclipse.parsson:parsson:1.1.2` to `1.1.4`

### Test Dependency Updates

* Updated `nl.jqno.equalsverifier:equalsverifier:3.14.3` to `3.15.1`
* Updated `org.junit.jupiter:junit-jupiter-engine:5.9.3` to `5.10.0`
* Updated `org.junit.jupiter:junit-jupiter-params:5.9.3` to `5.10.0`

### Plugin Dependency Updates

* Updated `com.exasol:error-code-crawler-maven-plugin:1.2.3` to `1.3.0`
* Updated `com.exasol:project-keeper-maven-plugin:2.9.7` to `2.9.11`
* Updated `org.apache.maven.plugins:maven-enforcer-plugin:3.3.0` to `3.4.0`
* Updated `org.apache.maven.plugins:maven-failsafe-plugin:3.0.0` to `3.1.2`
* Updated `org.apache.maven.plugins:maven-gpg-plugin:3.0.1` to `3.1.0`
* Updated `org.apache.maven.plugins:maven-surefire-plugin:3.0.0` to `3.1.2`
* Updated `org.codehaus.mojo:flatten-maven-plugin:1.4.1` to `1.5.0`
* Updated `org.codehaus.mojo:versions-maven-plugin:2.15.0` to `2.16.0`
* Updated `org.jacoco:jacoco-maven-plugin:0.8.9` to `0.8.10`
