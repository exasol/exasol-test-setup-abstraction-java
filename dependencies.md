<!-- @formatter:off -->
# Dependencies

## Compile Dependencies

| Dependency                                          | License                                                   |
| --------------------------------------------------- | --------------------------------------------------------- |
| [BucketFS Java][0]                                  | [MIT][1]                                                  |
| [Test containers for Exasol on Docker][2]           | [MIT][1]                                                  |
| [Apache XML-RPC Client Library][4]                  | [The Apache Software License, Version 2.0][5]             |
| [error-reporting-java][6]                           | [MIT][1]                                                  |
| [AWS Java SDK :: Services :: AWS CloudFormation][8] | [Apache License, Version 2.0][9]                          |
| [AWS Java SDK :: Services :: Amazon EC2][8]         | [Apache License, Version 2.0][9]                          |
| [JSch][12]                                          | [Revised BSD][13]                                         |
| [database-cleaner][14]                              | [MIT][1]                                                  |
| [JSR 374 (JSON Processing) API][16]                 | [Dual license consisting of the CDDL v1.1 and GPL v2][17] |
| [JSR 374 (JSON Processing) Default Provider][16]    | [Dual license consisting of the CDDL v1.1 and GPL v2][17] |
| [Project Lombok][20]                                | [The MIT License][21]                                     |

## Test Dependencies

| Dependency                 | License                           |
| -------------------------- | --------------------------------- |
| [JUnit Jupiter Engine][22] | [Eclipse Public License v2.0][23] |
| [JUnit Jupiter Params][22] | [Eclipse Public License v2.0][23] |
| [Hamcrest][26]             | [BSD License 3][27]               |
| [EqualsVerifier][28]       | [Apache License, Version 2.0][5]  |
| [System Lambda][30]        | [MIT License][31]                 |

## Plugin Dependencies

| Dependency                                              | License                                       |
| ------------------------------------------------------- | --------------------------------------------- |
| [Maven Surefire Plugin][32]                             | [Apache License, Version 2.0][33]             |
| [Maven Failsafe Plugin][34]                             | [Apache License, Version 2.0][33]             |
| [Apache Maven Compiler Plugin][36]                      | [Apache License, Version 2.0][33]             |
| [Maven Dependency Plugin][38]                           | [The Apache Software License, Version 2.0][5] |
| [Versions Maven Plugin][40]                             | [Apache License, Version 2.0][33]             |
| [org.sonatype.ossindex.maven:ossindex-maven-plugin][42] | [ASL2][5]                                     |
| [Apache Maven Enforcer Plugin][44]                      | [Apache License, Version 2.0][33]             |
| [Project keeper maven plugin][46]                       | [MIT][1]                                      |
| [JaCoCo :: Maven Plugin][48]                            | [Eclipse Public License 2.0][49]              |
| [Apache Maven GPG Plugin][50]                           | [Apache License, Version 2.0][5]              |
| [Maven Deploy Plugin][52]                               | [The Apache Software License, Version 2.0][5] |
| [Nexus Staging Maven Plugin][54]                        | [Eclipse Public License][55]                  |
| [Apache Maven Source Plugin][56]                        | [Apache License, Version 2.0][33]             |
| [Apache Maven Javadoc Plugin][58]                       | [Apache License, Version 2.0][33]             |
| [error-code-crawler-maven-plugin][60]                   | [MIT][1]                                      |
| [Reproducible Build Maven Plugin][62]                   | [Apache 2.0][5]                               |
| [Lombok Maven Plugin][64]                               | [The MIT License][1]                          |
| [Maven Clean Plugin][66]                                | [The Apache Software License, Version 2.0][5] |
| [Maven Resources Plugin][68]                            | [The Apache Software License, Version 2.0][5] |
| [Maven JAR Plugin][70]                                  | [The Apache Software License, Version 2.0][5] |
| [Maven Install Plugin][72]                              | [The Apache Software License, Version 2.0][5] |
| [Maven Site Plugin 3][74]                               | [The Apache Software License, Version 2.0][5] |

[46]: https://github.com/exasol/project-keeper-maven-plugin
[48]: https://www.eclemma.org/jacoco/index.html
[0]: https://github.com/exasol/bucketfs-java
[6]: https://github.com/exasol/error-reporting-java
[16]: https://javaee.github.io/jsonp
[12]: http://www.jcraft.com/jsch/
[4]: http://ws.apache.org/xmlrpc/xmlrpc-client/
[5]: http://www.apache.org/licenses/LICENSE-2.0.txt
[20]: https://projectlombok.org
[32]: https://maven.apache.org/surefire/maven-surefire-plugin/
[54]: http://www.sonatype.com/public-parent/nexus-maven-plugins/nexus-staging/nexus-staging-maven-plugin/
[66]: http://maven.apache.org/plugins/maven-clean-plugin/
[8]: https://aws.amazon.com/sdkforjava
[1]: https://opensource.org/licenses/MIT
[34]: https://maven.apache.org/surefire/maven-failsafe-plugin/
[38]: http://maven.apache.org/plugins/maven-dependency-plugin/
[40]: http://www.mojohaus.org/versions-maven-plugin/
[64]: http://anthonywhitford.com/lombok.maven/lombok-maven-plugin/
[27]: http://opensource.org/licenses/BSD-3-Clause
[36]: https://maven.apache.org/plugins/maven-compiler-plugin/
[17]: https://oss.oracle.com/licenses/CDDL+GPL-1.1
[30]: https://github.com/stefanbirkner/system-lambda/
[31]: http://opensource.org/licenses/MIT
[50]: http://maven.apache.org/plugins/maven-gpg-plugin/
[49]: https://www.eclipse.org/legal/epl-2.0/
[55]: http://www.eclipse.org/legal/epl-v10.html
[2]: https://github.com/exasol/exasol-testcontainers
[9]: https://aws.amazon.com/apache2.0
[21]: https://projectlombok.org/LICENSE
[62]: http://zlika.github.io/reproducible-build-maven-plugin
[70]: http://maven.apache.org/plugins/maven-jar-plugin/
[33]: https://www.apache.org/licenses/LICENSE-2.0.txt
[44]: https://maven.apache.org/enforcer/maven-enforcer-plugin/
[23]: https://www.eclipse.org/legal/epl-v20.html
[72]: http://maven.apache.org/plugins/maven-install-plugin/
[22]: https://junit.org/junit5/
[42]: https://sonatype.github.io/ossindex-maven/maven-plugin/
[28]: http://www.jqno.nl/equalsverifier
[56]: https://maven.apache.org/plugins/maven-source-plugin/
[13]: http://www.jcraft.com/jsch/LICENSE.txt
[26]: http://hamcrest.org/JavaHamcrest/
[52]: http://maven.apache.org/plugins/maven-deploy-plugin/
[74]: http://maven.apache.org/plugins/maven-site-plugin/
[68]: http://maven.apache.org/plugins/maven-resources-plugin/
[58]: https://maven.apache.org/plugins/maven-javadoc-plugin/
[14]: https://github.com/exasol/database-cleaner
[60]: https://github.com/exasol/error-code-crawler-maven-plugin
