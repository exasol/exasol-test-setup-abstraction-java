# Exasol Test Setup Abstraction Java 2.1.12, released 2026-??-??

Code name: Fixed vulnerabilities CVE-2017-7503, CVE-2017-10355, CVE-2026-9563

## Summary

This release fixes the following 3 vulnerabilities:

### CVE-2017-7503 (CWE-611) in dependency `xerces:xercesImpl:jar:2.12.2:compile`
It was found that the Red Hat JBoss EAP 7.0.5 implementation of javax.xml.transform.TransformerFactory is vulnerable to XXE. An attacker could use this flaw to launch DoS or SSRF attacks, or read files from the server where EAP is deployed.
#### References
* https://guide.sonatype.com/vulnerability/CVE-2017-7503?component-type=maven&component-name=xerces%2FxercesImpl&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2017-7503
* https://bugzilla.redhat.com/show_bug.cgi?id=CVE-2017-7503

### CVE-2017-10355 (CWE-833) in dependency `xerces:xercesImpl:jar:2.12.2:compile`
sonatype-2017-0348 - xerces:xercesImpl - Denial of Service (DoS)
#### References
* https://guide.sonatype.com/vulnerability/CVE-2017-10355?component-type=maven&component-name=xerces%2FxercesImpl&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2017-10355
* https://blogs.securiteam.com/index.php/archives/3271

### CVE-2026-9563 (CWE-400) in dependency `org.eclipse.parsson:parsson:jar:1.1.7:runtime`
In Eclipse Parsson published Maven Central artifacts before version 1.1.8, the JSON parser did not enforce a default maximum on the number of characters consumed while parsing a single JSON document. Applications that parse attacker- controlled JSON can be forced to consume excessive CPU and memory by processing very large documents, including large arrays, objects, strings, numbers, whitespace, or nested structures, resulting in a denial of service. Eclipse Parsson 1.1.8 introduces a configurable maximum parsing limit with a default limit of 15 million parser-consumed characters.
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-9563?component-type=maven&component-name=org.eclipse.parsson%2Fparsson&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-9563
* https://github.com/eclipse-ee4j/parsson/pull/169
* https://gitlab.eclipse.org/security/vulnerability-reports/-/work_items/444

## Security

* #102: Fixed vulnerability CVE-2017-7503 in dependency `xerces:xercesImpl:jar:2.12.2:compile`
* #103: Fixed vulnerability CVE-2017-10355 in dependency `xerces:xercesImpl:jar:2.12.2:compile`
* #104: Fixed vulnerability CVE-2026-9563 in dependency `org.eclipse.parsson:parsson:jar:1.1.7:runtime`

## Dependency Updates

### Compile Dependency Updates

* Updated `com.exasol:database-cleaner:1.1.5` to `1.1.6`
* Updated `com.exasol:exasol-testcontainers:7.2.2` to `7.3.0`
* Updated `com.github.mwiede:jsch:2.27.5` to `2.28.3`

### Runtime Dependency Updates

* Updated `org.eclipse.parsson:parsson:1.1.7` to `1.1.9`

### Test Dependency Updates

* Updated `nl.jqno.equalsverifier:equalsverifier:3.19.4` to `4.5`
* Updated `org.junit.jupiter:junit-jupiter-params:5.13.4` to `6.1.1`
* Updated `org.slf4j:slf4j-jdk14:2.0.17` to `2.0.18`

### Plugin Dependency Updates

* Updated `com.exasol:project-keeper-maven-plugin:5.4.6` to `5.7.2`
