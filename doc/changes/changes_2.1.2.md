# Exasol Test Setup Abstraction Java 2.1.2, released 2024-??-??

Code name: Fixed vulnerability CVE-2024-29025 in io.netty:netty-codec-http:jar:4.1.107.Final:runtime

## Summary

This release fixes the following vulnerability:

### CVE-2024-29025 (CWE-770) in dependency `io.netty:netty-codec-http:jar:4.1.107.Final:runtime`
Netty is an asynchronous event-driven network application framework for rapid development of maintainable high performance protocol servers & clients. The `HttpPostRequestDecoder` can be tricked to accumulate data. While the decoder can store items on the disk if configured so, there are no limits to the number of fields the form can have, an attacher can send a chunked post consisting of many small fields that will be accumulated in the `bodyListHttpData` list. The decoder cumulates bytes in the `undecodedChunk` buffer until it can decode a field, this field can cumulate data without limits. This vulnerability is fixed in 4.1.108.Final.
#### References
* https://ossindex.sonatype.org/vulnerability/CVE-2024-29025?component-type=maven&component-name=io.netty%2Fnetty-codec-http&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2024-29025
* https://github.com/advisories/GHSA-5jpm-x58v-624v

## Security

* #79: Fixed vulnerability CVE-2024-29025 in dependency `io.netty:netty-codec-http:jar:4.1.107.Final:runtime`

## Dependency Updates

### Compile Dependency Updates

* Updated `software.amazon.awssdk:cloudformation:2.25.6` to `2.25.26`
* Updated `software.amazon.awssdk:ec2:2.25.6` to `2.25.26`

### Runtime Dependency Updates

* Updated `org.eclipse.parsson:parsson:1.1.5` to `1.1.6`

### Test Dependency Updates

* Updated `nl.jqno.equalsverifier:equalsverifier:3.15.8` to `3.16.1`

### Plugin Dependency Updates

* Updated `com.exasol:error-code-crawler-maven-plugin:2.0.0` to `2.0.2`
* Updated `com.exasol:project-keeper-maven-plugin:4.1.0` to `4.3.0`
* Updated `org.apache.maven.plugins:maven-compiler-plugin:3.12.1` to `3.13.0`
* Updated `org.apache.maven.plugins:maven-gpg-plugin:3.1.0` to `3.2.2`
* Updated `org.jacoco:jacoco-maven-plugin:0.8.11` to `0.8.12`
* Updated `org.sonarsource.scanner.maven:sonar-maven-plugin:3.10.0.2594` to `3.11.0.3922`
