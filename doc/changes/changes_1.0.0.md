# exasol-test-setup-abstraction-java 1.0.0, released 2022-10-27

Code name: Fix SSH Connection

## Summary

Fixed setup of SSH connection that failed on windows.

## Bug Fixes

* #21: Fixed SSH connection.

## Dependency Updates

### Compile Dependency Updates

* Updated `com.exasol:bucketfs-java:2.3.0` to `2.4.1`
* Updated `com.exasol:database-cleaner:1.0.1` to `1.0.2`
* Updated `com.exasol:error-reporting-java:0.4.1` to `1.0.0`
* Updated `com.exasol:exasol-testcontainers:6.1.1` to `6.3.0`
* Updated `jakarta.json:jakarta.json-api:2.1.0` to `2.1.1`
* Updated `software.amazon.awssdk:cloudformation:2.17.199` to `2.18.3`
* Updated `software.amazon.awssdk:ec2:2.17.199` to `2.18.3`

### Test Dependency Updates

* Updated `nl.jqno.equalsverifier:equalsverifier:3.10` to `3.10.1`
* Updated `org.junit.jupiter:junit-jupiter-engine:5.8.2` to `5.9.1`
* Updated `org.junit.jupiter:junit-jupiter-params:5.8.2` to `5.9.1`

### Plugin Dependency Updates

* Updated `com.exasol:error-code-crawler-maven-plugin:1.1.1` to `1.1.2`
* Updated `com.exasol:project-keeper-maven-plugin:2.4.4` to `2.8.0`
* Removed `org.apache.maven.plugins:maven-dependency-plugin:2.8`
* Updated `org.apache.maven.plugins:maven-deploy-plugin:3.0.0-M2` to `3.0.0-M1`
* Updated `org.apache.maven.plugins:maven-enforcer-plugin:3.0.0` to `3.1.0`
* Updated `org.apache.maven.plugins:maven-failsafe-plugin:3.0.0-M6` to `3.0.0-M5`
* Updated `org.apache.maven.plugins:maven-surefire-plugin:3.0.0-M6` to `3.0.0-M5`
* Updated `org.codehaus.mojo:versions-maven-plugin:2.11.0` to `2.10.0`
* Removed `org.projectlombok:lombok-maven-plugin:1.18.20.0`
