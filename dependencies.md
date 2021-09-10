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
| [JSON-P Default Provider][16]                       | [Eclipse Public License 2.0][17]; [GNU General Public License, version 2 with the GNU Classpath Exception][18] |
| [Project Lombok][19]                                | [The MIT License][20]                                                                                          |

## Test Dependencies

| Dependency                 | License                           |
| -------------------------- | --------------------------------- |
| [JUnit Jupiter Engine][21] | [Eclipse Public License v2.0][22] |
| [JUnit Jupiter Params][21] | [Eclipse Public License v2.0][22] |
| [Hamcrest][25]             | [BSD License 3][26]               |
| [EqualsVerifier][27]       | [Apache License, Version 2.0][5]  |
| [System Lambda][29]        | [MIT License][30]                 |

## Plugin Dependencies

| Dependency                                              | License                                       |
| ------------------------------------------------------- | --------------------------------------------- |
| [Maven Surefire Plugin][31]                             | [Apache License, Version 2.0][32]             |
| [Maven Failsafe Plugin][33]                             | [Apache License, Version 2.0][32]             |
| [Apache Maven Compiler Plugin][35]                      | [Apache License, Version 2.0][32]             |
| [Maven Dependency Plugin][37]                           | [The Apache Software License, Version 2.0][5] |
| [Versions Maven Plugin][39]                             | [Apache License, Version 2.0][32]             |
| [org.sonatype.ossindex.maven:ossindex-maven-plugin][41] | [ASL2][5]                                     |
| [Apache Maven Enforcer Plugin][43]                      | [Apache License, Version 2.0][32]             |
| [Project keeper maven plugin][45]                       | [MIT][1]                                      |
| [JaCoCo :: Maven Plugin][47]                            | [Eclipse Public License 2.0][48]              |
| [Apache Maven GPG Plugin][49]                           | [Apache License, Version 2.0][5]              |
| [Maven Deploy Plugin][51]                               | [The Apache Software License, Version 2.0][5] |
| [Nexus Staging Maven Plugin][53]                        | [Eclipse Public License][54]                  |
| [Apache Maven Source Plugin][55]                        | [Apache License, Version 2.0][32]             |
| [Apache Maven Javadoc Plugin][57]                       | [Apache License, Version 2.0][32]             |
| [error-code-crawler-maven-plugin][59]                   | [MIT][1]                                      |
| [Reproducible Build Maven Plugin][61]                   | [Apache 2.0][5]                               |
| [Lombok Maven Plugin][63]                               | [The MIT License][1]                          |
| [Maven Clean Plugin][65]                                | [The Apache Software License, Version 2.0][5] |
| [Maven Resources Plugin][67]                            | [The Apache Software License, Version 2.0][5] |
| [Maven JAR Plugin][69]                                  | [The Apache Software License, Version 2.0][5] |
| [Maven Install Plugin][71]                              | [The Apache Software License, Version 2.0][5] |
| [Maven Site Plugin 3][73]                               | [The Apache Software License, Version 2.0][5] |

[45]: https://github.com/exasol/project-keeper-maven-plugin
[47]: https://www.eclemma.org/jacoco/index.html
[0]: https://github.com/exasol/bucketfs-java
[6]: https://github.com/exasol/error-reporting-java
[12]: http://www.jcraft.com/jsch/
[4]: http://ws.apache.org/xmlrpc/xmlrpc-client/
[5]: http://www.apache.org/licenses/LICENSE-2.0.txt
[19]: https://projectlombok.org
[31]: https://maven.apache.org/surefire/maven-surefire-plugin/
[53]: http://www.sonatype.com/public-parent/nexus-maven-plugins/nexus-staging/nexus-staging-maven-plugin/
[65]: http://maven.apache.org/plugins/maven-clean-plugin/
[8]: https://aws.amazon.com/sdkforjava
[1]: https://opensource.org/licenses/MIT
[33]: https://maven.apache.org/surefire/maven-failsafe-plugin/
[37]: http://maven.apache.org/plugins/maven-dependency-plugin/
[39]: http://www.mojohaus.org/versions-maven-plugin/
[63]: http://anthonywhitford.com/lombok.maven/lombok-maven-plugin/
[26]: http://opensource.org/licenses/BSD-3-Clause
[35]: https://maven.apache.org/plugins/maven-compiler-plugin/
[29]: https://github.com/stefanbirkner/system-lambda/
[30]: http://opensource.org/licenses/MIT
[49]: http://maven.apache.org/plugins/maven-gpg-plugin/
[48]: https://www.eclipse.org/legal/epl-2.0/
[54]: http://www.eclipse.org/legal/epl-v10.html
[2]: https://github.com/exasol/exasol-testcontainers
[9]: https://aws.amazon.com/apache2.0
[20]: https://projectlombok.org/LICENSE
[61]: http://zlika.github.io/reproducible-build-maven-plugin
[69]: http://maven.apache.org/plugins/maven-jar-plugin/
[17]: https://projects.eclipse.org/license/epl-2.0
[32]: https://www.apache.org/licenses/LICENSE-2.0.txt
[43]: https://maven.apache.org/enforcer/maven-enforcer-plugin/
[22]: https://www.eclipse.org/legal/epl-v20.html
[71]: http://maven.apache.org/plugins/maven-install-plugin/
[21]: https://junit.org/junit5/
[41]: https://sonatype.github.io/ossindex-maven/maven-plugin/
[16]: https://github.com/eclipse-ee4j/jsonp
[27]: http://www.jqno.nl/equalsverifier
[55]: https://maven.apache.org/plugins/maven-source-plugin/
[13]: http://www.jcraft.com/jsch/LICENSE.txt
[18]: https://projects.eclipse.org/license/secondary-gpl-2.0-cp
[25]: http://hamcrest.org/JavaHamcrest/
[51]: http://maven.apache.org/plugins/maven-deploy-plugin/
[73]: http://maven.apache.org/plugins/maven-site-plugin/
[67]: http://maven.apache.org/plugins/maven-resources-plugin/
[57]: https://maven.apache.org/plugins/maven-javadoc-plugin/
[14]: https://github.com/exasol/database-cleaner
[59]: https://github.com/exasol/error-code-crawler-maven-plugin
