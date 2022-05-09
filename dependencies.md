<!-- @formatter:off -->
# Dependencies

## Compile Dependencies

| Dependency                                          | License                                                                                                        |
| --------------------------------------------------- | -------------------------------------------------------------------------------------------------------------- |
| [BucketFS Java][0]                                  | [MIT][1]                                                                                                       |
| [Test containers for Exasol on Docker][2]           | [MIT][1]                                                                                                       |
| [Apache XML-RPC Client Library][4]                  | [The Apache Software License, Version 2.0][5]                                                                  |
| [error-reporting-java][6]                           | [MIT][1]                                                                                                       |
| [AWS Java SDK :: Services :: AWS CloudFormation][8] | [Apache License, Version 2.0][9]                                                                               |
| [AWS Java SDK :: Services :: Amazon EC2][8]         | [Apache License, Version 2.0][9]                                                                               |
| [JSch][12]                                          | [Revised BSD][13]                                                                                              |
| [database-cleaner][14]                              | [MIT][1]                                                                                                       |
| [Jakarta JSON Processing API][16]                   | [Eclipse Public License 2.0][17]; [GNU General Public License, version 2 with the GNU Classpath Exception][18] |
| [Project Lombok][19]                                | [The MIT License][20]                                                                                          |

## Test Dependencies

| Dependency                                | License                           |
| ----------------------------------------- | --------------------------------- |
| [JUnit Jupiter Engine][21]                | [Eclipse Public License v2.0][22] |
| [JUnit Jupiter Params][21]                | [Eclipse Public License v2.0][22] |
| [Hamcrest][25]                            | [BSD License 3][26]               |
| [EqualsVerifier | release normal jar][27] | [Apache License, Version 2.0][28] |
| [System Lambda][29]                       | [MIT License][30]                 |

## Runtime Dependencies

| Dependency                    | License                                                                                                        |
| ----------------------------- | -------------------------------------------------------------------------------------------------------------- |
| [JSON-P Default Provider][16] | [Eclipse Public License 2.0][17]; [GNU General Public License, version 2 with the GNU Classpath Exception][18] |

## Plugin Dependencies

| Dependency                                              | License                                       |
| ------------------------------------------------------- | --------------------------------------------- |
| [Maven Surefire Plugin][34]                             | [Apache License, Version 2.0][28]             |
| [Maven Failsafe Plugin][36]                             | [Apache License, Version 2.0][28]             |
| [Apache Maven Compiler Plugin][38]                      | [Apache License, Version 2.0][28]             |
| [Maven Dependency Plugin][40]                           | [The Apache Software License, Version 2.0][5] |
| [Versions Maven Plugin][42]                             | [Apache License, Version 2.0][28]             |
| [org.sonatype.ossindex.maven:ossindex-maven-plugin][44] | [ASL2][5]                                     |
| [Apache Maven Enforcer Plugin][46]                      | [Apache License, Version 2.0][28]             |
| [Project keeper maven plugin][48]                       | [MIT][1]                                      |
| [JaCoCo :: Maven Plugin][50]                            | [Eclipse Public License 2.0][51]              |
| [Apache Maven GPG Plugin][52]                           | [Apache License, Version 2.0][28]             |
| [Apache Maven Deploy Plugin][54]                        | [Apache License, Version 2.0][28]             |
| [Nexus Staging Maven Plugin][56]                        | [Eclipse Public License][57]                  |
| [Apache Maven Source Plugin][58]                        | [Apache License, Version 2.0][28]             |
| [Apache Maven Javadoc Plugin][60]                       | [Apache License, Version 2.0][28]             |
| [error-code-crawler-maven-plugin][62]                   | [MIT][1]                                      |
| [Reproducible Build Maven Plugin][64]                   | [Apache 2.0][5]                               |
| [Lombok Maven Plugin][66]                               | [The MIT License][1]                          |
| [Maven Clean Plugin][68]                                | [The Apache Software License, Version 2.0][5] |
| [Maven Resources Plugin][70]                            | [The Apache Software License, Version 2.0][5] |
| [Maven JAR Plugin][72]                                  | [The Apache Software License, Version 2.0][5] |
| [Maven Install Plugin][74]                              | [The Apache Software License, Version 2.0][5] |
| [Maven Site Plugin 3][76]                               | [The Apache Software License, Version 2.0][5] |

[48]: https://github.com/exasol/project-keeper-maven-plugin
[0]: https://github.com/exasol/bucketfs-java
[6]: https://github.com/exasol/error-reporting-java
[12]: http://www.jcraft.com/jsch/
[4]: http://ws.apache.org/xmlrpc/xmlrpc-client/
[5]: http://www.apache.org/licenses/LICENSE-2.0.txt
[19]: https://projectlombok.org
[34]: https://maven.apache.org/surefire/maven-surefire-plugin/
[56]: http://www.sonatype.com/public-parent/nexus-maven-plugins/nexus-staging/nexus-staging-maven-plugin/
[68]: http://maven.apache.org/plugins/maven-clean-plugin/
[8]: https://aws.amazon.com/sdkforjava
[1]: https://opensource.org/licenses/MIT
[36]: https://maven.apache.org/surefire/maven-failsafe-plugin/
[40]: http://maven.apache.org/plugins/maven-dependency-plugin/
[42]: http://www.mojohaus.org/versions-maven-plugin/
[66]: http://anthonywhitford.com/lombok.maven/lombok-maven-plugin/
[26]: http://opensource.org/licenses/BSD-3-Clause
[38]: https://maven.apache.org/plugins/maven-compiler-plugin/
[29]: https://github.com/stefanbirkner/system-lambda/
[30]: http://opensource.org/licenses/MIT
[51]: https://www.eclipse.org/legal/epl-2.0/
[54]: https://maven.apache.org/plugins/maven-deploy-plugin/
[57]: http://www.eclipse.org/legal/epl-v10.html
[2]: https://github.com/exasol/exasol-testcontainers
[50]: https://www.jacoco.org/jacoco/trunk/doc/maven.html
[9]: https://aws.amazon.com/apache2.0
[20]: https://projectlombok.org/LICENSE
[64]: http://zlika.github.io/reproducible-build-maven-plugin
[72]: http://maven.apache.org/plugins/maven-jar-plugin/
[17]: https://projects.eclipse.org/license/epl-2.0
[28]: https://www.apache.org/licenses/LICENSE-2.0.txt
[27]: https://www.jqno.nl/equalsverifier
[46]: https://maven.apache.org/enforcer/maven-enforcer-plugin/
[22]: https://www.eclipse.org/legal/epl-v20.html
[74]: http://maven.apache.org/plugins/maven-install-plugin/
[21]: https://junit.org/junit5/
[44]: https://sonatype.github.io/ossindex-maven/maven-plugin/
[52]: https://maven.apache.org/plugins/maven-gpg-plugin/
[16]: https://github.com/eclipse-ee4j/jsonp
[58]: https://maven.apache.org/plugins/maven-source-plugin/
[13]: http://www.jcraft.com/jsch/LICENSE.txt
[18]: https://projects.eclipse.org/license/secondary-gpl-2.0-cp
[25]: http://hamcrest.org/JavaHamcrest/
[76]: http://maven.apache.org/plugins/maven-site-plugin/
[70]: http://maven.apache.org/plugins/maven-resources-plugin/
[60]: https://maven.apache.org/plugins/maven-javadoc-plugin/
[14]: https://github.com/exasol/database-cleaner
[62]: https://github.com/exasol/error-code-crawler-maven-plugin
