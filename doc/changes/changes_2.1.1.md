# Exasol Test Setup Abstraction Java 2.1.1, released 2024-03-11

Code name: Fix CVE-2024-25710 and CVE-2024-26308 in compile dependency `org.apache.commons:commons-compress`

## Summary

This release fixes vulnerabilities CVE-2024-25710 and CVE-2024-26308 in compile dependency `org.apache.commons:commons-compress`.

**Excluded Vulnerability** We accept vulnerability CVE-2017-10355 (CWE-833: Deadlock) in compile dependency `xerces:xercesImpl:jar:2.12.2` as we assume that we only connect to the known endpoint ExaOperations.

## Security

* #73: Fixed CVE-2024-25710 in compile dependency `org.apache.commons:commons-compress`
* #74: Fixed CVE-2024-26308 in compile dependency `org.apache.commons:commons-compress`

## Dependency Updates

### Compile Dependency Updates

* Updated `com.exasol:bucketfs-java:3.1.1` to `3.1.2`
* Updated `com.exasol:database-cleaner:1.1.1` to `1.1.3`
* Updated `com.exasol:exasol-testcontainers:6.6.3` to `7.0.1`
* Updated `fr.turri:aXMLRPC:1.13.0` to `1.14.0`
* Updated `software.amazon.awssdk:cloudformation:2.21.20` to `2.25.6`
* Updated `software.amazon.awssdk:ec2:2.21.20` to `2.25.6`

### Test Dependency Updates

* Updated `nl.jqno.equalsverifier:equalsverifier:3.15.3` to `3.15.8`
* Updated `org.junit.jupiter:junit-jupiter-engine:5.10.1` to `5.10.2`
* Updated `org.junit.jupiter:junit-jupiter-params:5.10.1` to `5.10.2`
* Updated `org.slf4j:slf4j-jdk14:2.0.9` to `2.0.12`

### Plugin Dependency Updates

* Updated `com.exasol:error-code-crawler-maven-plugin:1.3.1` to `2.0.0`
* Updated `com.exasol:project-keeper-maven-plugin:2.9.15` to `4.1.0`
* Updated `org.apache.maven.plugins:maven-compiler-plugin:3.11.0` to `3.12.1`
* Updated `org.apache.maven.plugins:maven-failsafe-plugin:3.1.2` to `3.2.5`
* Updated `org.apache.maven.plugins:maven-javadoc-plugin:3.6.0` to `3.6.3`
* Updated `org.apache.maven.plugins:maven-surefire-plugin:3.1.2` to `3.2.5`
* Added `org.apache.maven.plugins:maven-toolchains-plugin:3.1.0`
* Updated `org.codehaus.mojo:flatten-maven-plugin:1.5.0` to `1.6.0`
* Updated `org.codehaus.mojo:versions-maven-plugin:2.16.1` to `2.16.2`
