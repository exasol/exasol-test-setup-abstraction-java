# exasol-test-setup-abstraction-java 0.3.2, released 2022-05-27

Code name: Fixed makeDatabaseTcpServiceAccessibleFromLocalhost

## Bug Fixes

* #39: Calling makeDatabaseTcpServiceAccessibleFromLocalhost breaks BucketFS support
* #38: Replaced xmlrpc dependency

## Dependency Updates

### Compile Dependency Updates

* Added `commons-codec:commons-codec:1.15`
* Added `fr.turri:aXMLRPC:1.12.0`
* Removed `org.apache.xmlrpc:xmlrpc-client:3.1.3`
* Updated `software.amazon.awssdk:cloudformation:2.17.186` to `2.17.191`
* Updated `software.amazon.awssdk:ec2:2.17.186` to `2.17.191`

### Plugin Dependency Updates

* Updated `com.exasol:project-keeper-maven-plugin:2.3.2` to `2.4.4`
* Updated `org.apache.maven.plugins:maven-failsafe-plugin:3.0.0-M3` to `3.0.0-M6`
* Updated `org.apache.maven.plugins:maven-surefire-plugin:3.0.0-M3` to `3.0.0-M6`
* Updated `org.codehaus.mojo:versions-maven-plugin:2.10.0` to `2.11.0`
