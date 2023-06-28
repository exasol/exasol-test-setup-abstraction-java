# Exasol Test Setup Abstraction Java 2.0.2, released 2023-06-28

Code name: Upgrade dependencies on top of 2.0.1

## Summary

This release fixes vulnerabilities CVE-2023-34462 (Uncontrolled Resource Consumption) in transitive dependency `io.netty:netty-handler` by upgrading it to the latest version.

## Refactoring

* #58: Migrated CI isolation to AWS CDK v2

## Security

* #60: Upgrade dependencies to fix vulnerabilities

## Dependency Updates

### Compile Dependency Updates

* Updated `com.exasol:exasol-testcontainers:6.5.2` to `6.6.0`
* Removed `commons-codec:commons-codec:1.15`
* Added `io.netty:netty-handler:4.1.94.Final`
* Updated `jakarta.json:jakarta.json-api:2.1.1` to `2.1.2`
* Updated `software.amazon.awssdk:cloudformation:2.20.44` to `2.20.93`
* Updated `software.amazon.awssdk:ec2:2.20.44` to `2.20.93`

### Runtime Dependency Updates

* Updated `org.eclipse.parsson:parsson:1.1.1` to `1.1.2`

### Test Dependency Updates

* Updated `nl.jqno.equalsverifier:equalsverifier:3.14.1` to `3.14.3`
* Updated `org.junit.jupiter:junit-jupiter-engine:5.9.2` to `5.9.3`
* Updated `org.junit.jupiter:junit-jupiter-params:5.9.2` to `5.9.3`

### Plugin Dependency Updates

* Updated `com.exasol:error-code-crawler-maven-plugin:1.2.2` to `1.2.3`
* Updated `com.exasol:project-keeper-maven-plugin:2.9.6` to `2.9.7`
* Updated `org.apache.maven.plugins:maven-compiler-plugin:3.10.1` to `3.11.0`
* Updated `org.apache.maven.plugins:maven-deploy-plugin:3.1.0` to `3.1.1`
* Updated `org.apache.maven.plugins:maven-enforcer-plugin:3.2.1` to `3.3.0`
* Updated `org.apache.maven.plugins:maven-failsafe-plugin:3.0.0-M8` to `3.0.0`
* Updated `org.apache.maven.plugins:maven-javadoc-plugin:3.4.1` to `3.5.0`
* Updated `org.apache.maven.plugins:maven-surefire-plugin:3.0.0-M8` to `3.0.0`
* Updated `org.codehaus.mojo:flatten-maven-plugin:1.3.0` to `1.4.1`
* Updated `org.codehaus.mojo:versions-maven-plugin:2.14.2` to `2.15.0`
* Updated `org.jacoco:jacoco-maven-plugin:0.8.8` to `0.8.9`
