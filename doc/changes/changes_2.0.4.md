# Exasol Test Setup Abstraction Java 2.0.4, released 2023-09-26

Code name: Fix CVE-2023-42503

## Summary

This release fixes CVE-2023-42503 in `org.apache.commons:commons-compress`. 

The release also updates the default Exasol DB version to 7.1.23.

**Known issue:** Transitive dependency `io.netty:netty-handler` (via `software.amazon.awssdk:cloudformation`) still contains CVE-2023-4586. See [issue #65](https://github.com/exasol/exasol-test-setup-abstraction-java/issues/65) for details.

## Security

* #67 Fixed CVE-2023-42503 in `org.apache.commons:commons-compress`

## Dependency Updates

### Compile Dependency Updates

* Updated `com.exasol:exasol-testcontainers:6.6.1` to `6.6.2`
* Updated `software.amazon.awssdk:cloudformation:2.20.137` to `2.20.153`
* Updated `software.amazon.awssdk:ec2:2.20.137` to `2.20.153`

### Test Dependency Updates

* Updated `nl.jqno.equalsverifier:equalsverifier:3.15.1` to `3.15.2`
* Updated `org.slf4j:slf4j-jdk14:2.0.7` to `2.0.9`

### Plugin Dependency Updates

* Updated `com.exasol:project-keeper-maven-plugin:2.9.11` to `2.9.12`
* Updated `org.basepom.maven:duplicate-finder-maven-plugin:1.5.1` to `2.0.1`
