# Exasol Test Setup Abstraction Java 2.1.7, released 2025-02-11

Code name: Fix CVE-2025-24970 in transitive dependency

## Summary

This release fixes CVE-2025-24970 in transitive runtime dependency `io.netty:netty-handler:jar:4.1.118.Final`. The release also upgrades the dependency to to `bucketfs-java` to fix the following runtime error:

```
NoSuchMethodError: 'com.exasol.bucketfs.ReadEnabledBucket$Builder
com.exasol.bucketfs.WriteEnabledBucket$Builder.allowAlternativeHostName
```

**Note:** This release deprecates support for the "cloudSetup" using Terraform (see [documentation](../user_guide/setup_project_with_cloud_resources.md)). The Exasol AMI image is not available any more in AWS so we deactivated the integration tests.

## Security

* #90: Fixed CVE-2025-24970 in transitive runtime dependency `io.netty:netty-handler:jar:4.1.118.Final`

## Bugfixes

* #89: Upgraded dependency to `bucketfs-java`

## Dependency Updates

### Compile Dependency Updates

* Updated `com.exasol:bucketfs-java:3.2.0` to `3.2.1`
* Updated `com.exasol:exasol-testcontainers:7.1.1` to `7.1.3`
* Updated `com.github.mwiede:jsch:0.2.21` to `0.2.23`
* Updated `fr.turri:aXMLRPC:1.14.0` to `1.17.0`
* Removed `software.amazon.awssdk:cloudformation:2.29.15`
* Removed `software.amazon.awssdk:ec2:2.29.15`

### Test Dependency Updates

* Updated `nl.jqno.equalsverifier:equalsverifier:3.17.3` to `3.19`
* Updated `org.junit.jupiter:junit-jupiter-engine:5.11.3` to `5.11.4`
* Updated `org.junit.jupiter:junit-jupiter-params:5.11.3` to `5.11.4`

### Plugin Dependency Updates

* Updated `com.exasol:project-keeper-maven-plugin:4.4.0` to `4.5.0`
* Updated `org.apache.maven.plugins:maven-deploy-plugin:3.1.2` to `3.1.3`
* Updated `org.apache.maven.plugins:maven-failsafe-plugin:3.5.1` to `3.5.2`
* Updated `org.apache.maven.plugins:maven-javadoc-plugin:3.10.1` to `3.11.1`
* Updated `org.apache.maven.plugins:maven-site-plugin:3.9.1` to `3.21.0`
* Updated `org.apache.maven.plugins:maven-surefire-plugin:3.5.1` to `3.5.2`
* Updated `org.codehaus.mojo:versions-maven-plugin:2.17.1` to `2.18.0`
* Updated `org.sonarsource.scanner.maven:sonar-maven-plugin:4.0.0.4121` to `5.0.0.4389`
