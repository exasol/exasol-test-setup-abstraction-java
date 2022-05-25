<!-- @formatter:off -->
# Dependencies

## Compile Dependencies

| Dependency                                          | License                                                                                                        |
| --------------------------------------------------- | -------------------------------------------------------------------------------------------------------------- |
| [BucketFS Java][0]                                  | [MIT][1]                                                                                                       |
| [Test containers for Exasol on Docker][2]           | [MIT][1]                                                                                                       |
| [error-reporting-java][4]                           | [MIT][1]                                                                                                       |
| [AWS Java SDK :: Services :: AWS CloudFormation][6] | [Apache License, Version 2.0][7]                                                                               |
| [AWS Java SDK :: Services :: Amazon EC2][6]         | [Apache License, Version 2.0][7]                                                                               |
| [JSch][10]                                          | [Revised BSD][11]                                                                                              |
| [database-cleaner][12]                              | [MIT][1]                                                                                                       |
| [Jakarta JSON Processing API][14]                   | [Eclipse Public License 2.0][15]; [GNU General Public License, version 2 with the GNU Classpath Exception][16] |
| [Project Lombok][17]                                | [The MIT License][18]                                                                                          |

## Test Dependencies

| Dependency                                | License                           |
| ----------------------------------------- | --------------------------------- |
| [JUnit Jupiter Engine][19]                | [Eclipse Public License v2.0][20] |
| [JUnit Jupiter Params][19]                | [Eclipse Public License v2.0][20] |
| [Hamcrest][23]                            | [BSD License 3][24]               |
| [EqualsVerifier | release normal jar][25] | [Apache License, Version 2.0][26] |
| [System Lambda][27]                       | [MIT License][28]                 |

## Runtime Dependencies

| Dependency                    | License                                                                                                        |
| ----------------------------- | -------------------------------------------------------------------------------------------------------------- |
| [JSON-P Default Provider][14] | [Eclipse Public License 2.0][15]; [GNU General Public License, version 2 with the GNU Classpath Exception][16] |

## Plugin Dependencies

| Dependency                                              | License                                        |
| ------------------------------------------------------- | ---------------------------------------------- |
| [SonarQube Scanner for Maven][32]                       | [GNU LGPL 3][33]                               |
| [Apache Maven Compiler Plugin][34]                      | [Apache License, Version 2.0][26]              |
| [Apache Maven Enforcer Plugin][36]                      | [Apache License, Version 2.0][26]              |
| [Maven Flatten Plugin][38]                              | [Apache Software Licenese][39]                 |
| [org.sonatype.ossindex.maven:ossindex-maven-plugin][40] | [ASL2][39]                                     |
| [Reproducible Build Maven Plugin][42]                   | [Apache 2.0][39]                               |
| [Maven Surefire Plugin][44]                             | [Apache License, Version 2.0][26]              |
| [Maven Dependency Plugin][46]                           | [The Apache Software License, Version 2.0][39] |
| [Versions Maven Plugin][48]                             | [Apache License, Version 2.0][26]              |
| [Apache Maven Deploy Plugin][50]                        | [Apache License, Version 2.0][26]              |
| [Apache Maven GPG Plugin][52]                           | [Apache License, Version 2.0][26]              |
| [Apache Maven Source Plugin][54]                        | [Apache License, Version 2.0][26]              |
| [Apache Maven Javadoc Plugin][56]                       | [Apache License, Version 2.0][26]              |
| [Nexus Staging Maven Plugin][58]                        | [Eclipse Public License][59]                   |
| [Lombok Maven Plugin][60]                               | [The MIT License][1]                           |
| [Maven Failsafe Plugin][62]                             | [Apache License, Version 2.0][26]              |
| [Project keeper maven plugin][64]                       | [The MIT License][65]                          |
| [JaCoCo :: Maven Plugin][66]                            | [Eclipse Public License 2.0][67]               |
| [error-code-crawler-maven-plugin][68]                   | [MIT][1]                                       |
| [Maven Clean Plugin][70]                                | [The Apache Software License, Version 2.0][39] |
| [Maven Resources Plugin][72]                            | [The Apache Software License, Version 2.0][39] |
| [Maven JAR Plugin][74]                                  | [The Apache Software License, Version 2.0][39] |
| [Maven Install Plugin][76]                              | [The Apache Software License, Version 2.0][39] |
| [Maven Site Plugin 3][78]                               | [The Apache Software License, Version 2.0][39] |

[0]: https://github.com/exasol/bucketfs-java
[4]: https://github.com/exasol/error-reporting-java
[39]: http://www.apache.org/licenses/LICENSE-2.0.txt
[17]: https://projectlombok.org
[44]: https://maven.apache.org/surefire/maven-surefire-plugin/
[70]: http://maven.apache.org/plugins/maven-clean-plugin/
[6]: https://aws.amazon.com/sdkforjava
[1]: https://opensource.org/licenses/MIT
[48]: http://www.mojohaus.org/versions-maven-plugin/
[64]: https://github.com/exasol/project-keeper/
[24]: http://opensource.org/licenses/BSD-3-Clause
[34]: https://maven.apache.org/plugins/maven-compiler-plugin/
[27]: https://github.com/stefanbirkner/system-lambda/
[67]: https://www.eclipse.org/legal/epl-2.0/
[50]: https://maven.apache.org/plugins/maven-deploy-plugin/
[33]: http://www.gnu.org/licenses/lgpl.txt
[66]: https://www.jacoco.org/jacoco/trunk/doc/maven.html
[7]: https://aws.amazon.com/apache2.0
[18]: https://projectlombok.org/LICENSE
[42]: http://zlika.github.io/reproducible-build-maven-plugin
[32]: http://sonarsource.github.io/sonar-scanner-maven/
[19]: https://junit.org/junit5/
[38]: https://www.mojohaus.org/flatten-maven-plugin/flatten-maven-plugin
[14]: https://github.com/eclipse-ee4j/jsonp
[54]: https://maven.apache.org/plugins/maven-source-plugin/
[16]: https://projects.eclipse.org/license/secondary-gpl-2.0-cp
[23]: http://hamcrest.org/JavaHamcrest/
[72]: http://maven.apache.org/plugins/maven-resources-plugin/
[10]: http://www.jcraft.com/jsch/
[58]: http://www.sonatype.com/public-parent/nexus-maven-plugins/nexus-staging/nexus-staging-maven-plugin/
[62]: https://maven.apache.org/surefire/maven-failsafe-plugin/
[46]: http://maven.apache.org/plugins/maven-dependency-plugin/
[28]: http://opensource.org/licenses/MIT
[59]: http://www.eclipse.org/legal/epl-v10.html
[2]: https://github.com/exasol/exasol-testcontainers
[65]: https://github.com/exasol/project-keeper/blob/main/LICENSE
[74]: http://maven.apache.org/plugins/maven-jar-plugin/
[15]: https://projects.eclipse.org/license/epl-2.0
[26]: https://www.apache.org/licenses/LICENSE-2.0.txt
[25]: https://www.jqno.nl/equalsverifier
[36]: https://maven.apache.org/enforcer/maven-enforcer-plugin/
[60]: https://awhitford.github.com/lombok.maven/lombok-maven-plugin/
[20]: https://www.eclipse.org/legal/epl-v20.html
[76]: http://maven.apache.org/plugins/maven-install-plugin/
[40]: https://sonatype.github.io/ossindex-maven/maven-plugin/
[52]: https://maven.apache.org/plugins/maven-gpg-plugin/
[11]: http://www.jcraft.com/jsch/LICENSE.txt
[78]: http://maven.apache.org/plugins/maven-site-plugin/
[56]: https://maven.apache.org/plugins/maven-javadoc-plugin/
[12]: https://github.com/exasol/database-cleaner
[68]: https://github.com/exasol/error-code-crawler-maven-plugin
