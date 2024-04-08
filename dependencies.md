<!-- @formatter:off -->
# Dependencies

## Compile Dependencies

| Dependency                                          | License                                                                                                        |
| --------------------------------------------------- | -------------------------------------------------------------------------------------------------------------- |
| [BucketFS Java][0]                                  | [MIT License][1]                                                                                               |
| [Test containers for Exasol on Docker][2]           | [MIT License][3]                                                                                               |
| [aXMLRPC][4]                                        | The MIT License (MIT)                                                                                          |
| [error-reporting-java][5]                           | [MIT License][6]                                                                                               |
| [AWS Java SDK :: Services :: AWS CloudFormation][7] | [Apache License, Version 2.0][8]                                                                               |
| [AWS Java SDK :: Services :: Amazon EC2][7]         | [Apache License, Version 2.0][8]                                                                               |
| [JSch][9]                                           | [Revised BSD][10]                                                                                              |
| [database-cleaner][11]                              | [MIT License][12]                                                                                              |
| [Jakarta JSON Processing API][13]                   | [Eclipse Public License 2.0][14]; [GNU General Public License, version 2 with the GNU Classpath Exception][15] |

## Test Dependencies

| Dependency                                 | License                           |
| ------------------------------------------ | --------------------------------- |
| [JUnit Jupiter Engine][16]                 | [Eclipse Public License v2.0][17] |
| [JUnit Jupiter Params][16]                 | [Eclipse Public License v2.0][17] |
| [Hamcrest][18]                             | [BSD License 3][19]               |
| [EqualsVerifier \| release normal jar][20] | [Apache License, Version 2.0][21] |
| [System Lambda][22]                        | [MIT License][23]                 |
| [SLF4J JDK14 Provider][24]                 | [MIT License][25]                 |

## Runtime Dependencies

| Dependency            | License                                                                                                        |
| --------------------- | -------------------------------------------------------------------------------------------------------------- |
| [Eclipse Parsson][26] | [Eclipse Public License 2.0][14]; [GNU General Public License, version 2 with the GNU Classpath Exception][15] |

## Plugin Dependencies

| Dependency                                              | License                           |
| ------------------------------------------------------- | --------------------------------- |
| [SonarQube Scanner for Maven][27]                       | [GNU LGPL 3][28]                  |
| [Apache Maven Toolchains Plugin][29]                    | [Apache License, Version 2.0][21] |
| [Apache Maven Compiler Plugin][30]                      | [Apache-2.0][21]                  |
| [Apache Maven Enforcer Plugin][31]                      | [Apache-2.0][21]                  |
| [Maven Flatten Plugin][32]                              | [Apache Software Licenese][21]    |
| [org.sonatype.ossindex.maven:ossindex-maven-plugin][33] | [ASL2][34]                        |
| [Maven Surefire Plugin][35]                             | [Apache-2.0][21]                  |
| [Versions Maven Plugin][36]                             | [Apache License, Version 2.0][21] |
| [Project Keeper Maven plugin][37]                       | [The MIT License][38]             |
| [duplicate-finder-maven-plugin Maven Mojo][39]          | [Apache License 2.0][40]          |
| [Apache Maven Deploy Plugin][41]                        | [Apache-2.0][21]                  |
| [Apache Maven GPG Plugin][42]                           | [Apache-2.0][21]                  |
| [Apache Maven Source Plugin][43]                        | [Apache License, Version 2.0][21] |
| [Apache Maven Javadoc Plugin][44]                       | [Apache-2.0][21]                  |
| [Nexus Staging Maven Plugin][45]                        | [Eclipse Public License][46]      |
| [Maven Failsafe Plugin][47]                             | [Apache-2.0][21]                  |
| [JaCoCo :: Maven Plugin][48]                            | [EPL-2.0][49]                     |
| [error-code-crawler-maven-plugin][50]                   | [MIT License][51]                 |
| [Reproducible Build Maven Plugin][52]                   | [Apache 2.0][34]                  |

[0]: https://github.com/exasol/bucketfs-java/
[1]: https://github.com/exasol/bucketfs-java/blob/main/LICENSE
[2]: https://github.com/exasol/exasol-testcontainers/
[3]: https://github.com/exasol/exasol-testcontainers/blob/main/LICENSE
[4]: https://github.com/gturri/aXMLRPC
[5]: https://github.com/exasol/error-reporting-java/
[6]: https://github.com/exasol/error-reporting-java/blob/main/LICENSE
[7]: https://aws.amazon.com/sdkforjava
[8]: https://aws.amazon.com/apache2.0
[9]: http://www.jcraft.com/jsch/
[10]: http://www.jcraft.com/jsch/LICENSE.txt
[11]: https://github.com/exasol/database-cleaner/
[12]: https://github.com/exasol/database-cleaner/blob/main/LICENSE
[13]: https://github.com/eclipse-ee4j/jsonp
[14]: https://projects.eclipse.org/license/epl-2.0
[15]: https://projects.eclipse.org/license/secondary-gpl-2.0-cp
[16]: https://junit.org/junit5/
[17]: https://www.eclipse.org/legal/epl-v20.html
[18]: http://hamcrest.org/JavaHamcrest/
[19]: http://opensource.org/licenses/BSD-3-Clause
[20]: https://www.jqno.nl/equalsverifier
[21]: https://www.apache.org/licenses/LICENSE-2.0.txt
[22]: https://github.com/stefanbirkner/system-lambda/
[23]: http://opensource.org/licenses/MIT
[24]: http://www.slf4j.org
[25]: http://www.opensource.org/licenses/mit-license.php
[26]: https://github.com/eclipse-ee4j/parsson
[27]: http://sonarsource.github.io/sonar-scanner-maven/
[28]: http://www.gnu.org/licenses/lgpl.txt
[29]: https://maven.apache.org/plugins/maven-toolchains-plugin/
[30]: https://maven.apache.org/plugins/maven-compiler-plugin/
[31]: https://maven.apache.org/enforcer/maven-enforcer-plugin/
[32]: https://www.mojohaus.org/flatten-maven-plugin/
[33]: https://sonatype.github.io/ossindex-maven/maven-plugin/
[34]: http://www.apache.org/licenses/LICENSE-2.0.txt
[35]: https://maven.apache.org/surefire/maven-surefire-plugin/
[36]: https://www.mojohaus.org/versions/versions-maven-plugin/
[37]: https://github.com/exasol/project-keeper/
[38]: https://github.com/exasol/project-keeper/blob/main/LICENSE
[39]: https://basepom.github.io/duplicate-finder-maven-plugin
[40]: http://www.apache.org/licenses/LICENSE-2.0.html
[41]: https://maven.apache.org/plugins/maven-deploy-plugin/
[42]: https://maven.apache.org/plugins/maven-gpg-plugin/
[43]: https://maven.apache.org/plugins/maven-source-plugin/
[44]: https://maven.apache.org/plugins/maven-javadoc-plugin/
[45]: http://www.sonatype.com/public-parent/nexus-maven-plugins/nexus-staging/nexus-staging-maven-plugin/
[46]: http://www.eclipse.org/legal/epl-v10.html
[47]: https://maven.apache.org/surefire/maven-failsafe-plugin/
[48]: https://www.jacoco.org/jacoco/trunk/doc/maven.html
[49]: https://www.eclipse.org/legal/epl-2.0/
[50]: https://github.com/exasol/error-code-crawler-maven-plugin/
[51]: https://github.com/exasol/error-code-crawler-maven-plugin/blob/main/LICENSE
[52]: http://zlika.github.io/reproducible-build-maven-plugin
