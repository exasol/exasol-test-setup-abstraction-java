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
| [SonarQube Scanner for Maven][34]                       | [GNU LGPL 3][35]                              |
| [Apache Maven Compiler Plugin][36]                      | [Apache License, Version 2.0][28]             |
| [Apache Maven Enforcer Plugin][38]                      | [Apache License, Version 2.0][28]             |
| [Maven Flatten Plugin][40]                              | [Apache Software Licenese][5]                 |
| [org.sonatype.ossindex.maven:ossindex-maven-plugin][42] | [ASL2][5]                                     |
| [Reproducible Build Maven Plugin][44]                   | [Apache 2.0][5]                               |
| [Maven Surefire Plugin][46]                             | [Apache License, Version 2.0][28]             |
| [Maven Dependency Plugin][48]                           | [The Apache Software License, Version 2.0][5] |
| [Versions Maven Plugin][50]                             | [Apache License, Version 2.0][28]             |
| [Apache Maven Deploy Plugin][52]                        | [Apache License, Version 2.0][28]             |
| [Apache Maven GPG Plugin][54]                           | [Apache License, Version 2.0][28]             |
| [Apache Maven Source Plugin][56]                        | [Apache License, Version 2.0][28]             |
| [Apache Maven Javadoc Plugin][58]                       | [Apache License, Version 2.0][28]             |
| [Nexus Staging Maven Plugin][60]                        | [Eclipse Public License][61]                  |
| [Lombok Maven Plugin][62]                               | [The MIT License][1]                          |
| [Maven Failsafe Plugin][64]                             | [Apache License, Version 2.0][28]             |
| [Project keeper maven plugin][66]                       | [The MIT License][67]                         |
| [JaCoCo :: Maven Plugin][68]                            | [Eclipse Public License 2.0][69]              |
| [error-code-crawler-maven-plugin][70]                   | [MIT][1]                                      |
| [Maven Clean Plugin][72]                                | [The Apache Software License, Version 2.0][5] |
| [Maven Resources Plugin][74]                            | [The Apache Software License, Version 2.0][5] |
| [Maven JAR Plugin][76]                                  | [The Apache Software License, Version 2.0][5] |
| [Maven Install Plugin][78]                              | [The Apache Software License, Version 2.0][5] |
| [Maven Site Plugin 3][80]                               | [The Apache Software License, Version 2.0][5] |

[0]: https://github.com/exasol/bucketfs-java
[6]: https://github.com/exasol/error-reporting-java
[4]: http://ws.apache.org/xmlrpc/xmlrpc-client/
[5]: http://www.apache.org/licenses/LICENSE-2.0.txt
[19]: https://projectlombok.org
[46]: https://maven.apache.org/surefire/maven-surefire-plugin/
[72]: http://maven.apache.org/plugins/maven-clean-plugin/
[8]: https://aws.amazon.com/sdkforjava
[1]: https://opensource.org/licenses/MIT
[40]: https://www.mojohaus.org/flatten-maven-plugin/
[50]: http://www.mojohaus.org/versions-maven-plugin/
[66]: https://github.com/exasol/project-keeper/
[26]: http://opensource.org/licenses/BSD-3-Clause
[36]: https://maven.apache.org/plugins/maven-compiler-plugin/
[29]: https://github.com/stefanbirkner/system-lambda/
[69]: https://www.eclipse.org/legal/epl-2.0/
[52]: https://maven.apache.org/plugins/maven-deploy-plugin/
[35]: http://www.gnu.org/licenses/lgpl.txt
[68]: https://www.jacoco.org/jacoco/trunk/doc/maven.html
[9]: https://aws.amazon.com/apache2.0
[20]: https://projectlombok.org/LICENSE
[44]: http://zlika.github.io/reproducible-build-maven-plugin
[34]: http://sonarsource.github.io/sonar-scanner-maven/
[62]: https://projectlombok.org/setup/maven
[21]: https://junit.org/junit5/
[16]: https://github.com/eclipse-ee4j/jsonp
[56]: https://maven.apache.org/plugins/maven-source-plugin/
[18]: https://projects.eclipse.org/license/secondary-gpl-2.0-cp
[25]: http://hamcrest.org/JavaHamcrest/
[74]: http://maven.apache.org/plugins/maven-resources-plugin/
[12]: http://www.jcraft.com/jsch/
[60]: http://www.sonatype.com/public-parent/nexus-maven-plugins/nexus-staging/nexus-staging-maven-plugin/
[64]: https://maven.apache.org/surefire/maven-failsafe-plugin/
[48]: http://maven.apache.org/plugins/maven-dependency-plugin/
[30]: http://opensource.org/licenses/MIT
[61]: http://www.eclipse.org/legal/epl-v10.html
[2]: https://github.com/exasol/exasol-testcontainers
[67]: https://github.com/exasol/project-keeper/blob/main/LICENSE
[76]: http://maven.apache.org/plugins/maven-jar-plugin/
[17]: https://projects.eclipse.org/license/epl-2.0
[28]: https://www.apache.org/licenses/LICENSE-2.0.txt
[27]: https://www.jqno.nl/equalsverifier
[38]: https://maven.apache.org/enforcer/maven-enforcer-plugin/
[22]: https://www.eclipse.org/legal/epl-v20.html
[78]: http://maven.apache.org/plugins/maven-install-plugin/
[42]: https://sonatype.github.io/ossindex-maven/maven-plugin/
[54]: https://maven.apache.org/plugins/maven-gpg-plugin/
[13]: http://www.jcraft.com/jsch/LICENSE.txt
[80]: http://maven.apache.org/plugins/maven-site-plugin/
[58]: https://maven.apache.org/plugins/maven-javadoc-plugin/
[14]: https://github.com/exasol/database-cleaner
[70]: https://github.com/exasol/error-code-crawler-maven-plugin
