# exasol-test-setup-abstraction-java 0.2.0, released 2021-09-09

Code name: AWS Cluster Test Backend

## Features

* #4: Added AWS Cluster implementation
* #8: Added AWS cluster setup terraform template
* #26: Adapted to read test config from terraform-aws-exasol-test-setup 1.0.0

## Dependency Updates

### Compile Dependency Updates

* Updated `com.exasol:bucketfs-java:2.0.1` to `2.1.0`
* Updated `com.exasol:database-cleaner:1.0.0` to `1.0.1`
* Updated `com.exasol:exasol-testcontainers:3.5.3` to `4.0.0`
* Added `org.glassfish:jakarta.json:2.0.1`
* Updated `software.amazon.awssdk:cloudformation:2.16.100` to `2.17.16`
* Updated `software.amazon.awssdk:ec2:2.16.100` to `2.17.16`

### Test Dependency Updates

* Added `com.github.stefanbirkner:system-lambda:1.2.0`

### Plugin Dependency Updates

* Updated `com.exasol:error-code-crawler-maven-plugin:0.5.0` to `0.6.0`
* Updated `com.exasol:project-keeper-maven-plugin:0.10.0` to `1.1.0`
* Added `org.projectlombok:lombok-maven-plugin:1.18.20.0`
