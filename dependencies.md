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
| [JSch][9]                                           | [Revised BSD][10]; [Revised BSD][11]; [ISC][12]                                                                |
| [database-cleaner][13]                              | [MIT License][14]                                                                                              |
| [Jakarta JSON Processing API][15]                   | [Eclipse Public License 2.0][16]; [GNU General Public License, version 2 with the GNU Classpath Exception][17] |

## Test Dependencies

| Dependency                                 | License                           |
| ------------------------------------------ | --------------------------------- |
| [JUnit Jupiter Engine][18]                 | [Eclipse Public License v2.0][19] |
| [JUnit Jupiter Params][18]                 | [Eclipse Public License v2.0][19] |
| [Hamcrest][20]                             | [BSD-3-Clause][21]                |
| [EqualsVerifier \| release normal jar][22] | [Apache License, Version 2.0][23] |
| [System Lambda][24]                        | [MIT License][25]                 |
| [SLF4J JDK14 Provider][26]                 | [MIT License][27]                 |

## Runtime Dependencies

| Dependency            | License                                                                                                        |
| --------------------- | -------------------------------------------------------------------------------------------------------------- |
| [Eclipse Parsson][28] | [Eclipse Public License 2.0][16]; [GNU General Public License, version 2 with the GNU Classpath Exception][17] |

## Plugin Dependencies

| Dependency                                              | License                           |
| ------------------------------------------------------- | --------------------------------- |
| [SonarQube Scanner for Maven][29]                       | [GNU LGPL 3][30]                  |
| [Apache Maven Toolchains Plugin][31]                    | [Apache-2.0][23]                  |
| [Apache Maven Compiler Plugin][32]                      | [Apache-2.0][23]                  |
| [Apache Maven Enforcer Plugin][33]                      | [Apache-2.0][23]                  |
| [Maven Flatten Plugin][34]                              | [Apache Software Licenese][23]    |
| [org.sonatype.ossindex.maven:ossindex-maven-plugin][35] | [ASL2][36]                        |
| [Maven Surefire Plugin][37]                             | [Apache-2.0][23]                  |
| [Versions Maven Plugin][38]                             | [Apache License, Version 2.0][23] |
| [Project Keeper Maven plugin][39]                       | [The MIT License][40]             |
| [duplicate-finder-maven-plugin Maven Mojo][41]          | [Apache License 2.0][42]          |
| [Apache Maven Deploy Plugin][43]                        | [Apache-2.0][23]                  |
| [Apache Maven GPG Plugin][44]                           | [Apache-2.0][23]                  |
| [Apache Maven Source Plugin][45]                        | [Apache License, Version 2.0][23] |
| [Apache Maven Javadoc Plugin][46]                       | [Apache-2.0][23]                  |
| [Nexus Staging Maven Plugin][47]                        | [Eclipse Public License][48]      |
| [Maven Failsafe Plugin][49]                             | [Apache-2.0][23]                  |
| [JaCoCo :: Maven Plugin][50]                            | [EPL-2.0][51]                     |
| [error-code-crawler-maven-plugin][52]                   | [MIT License][53]                 |
| [Reproducible Build Maven Plugin][54]                   | [Apache 2.0][36]                  |

[0]: https://github.com/exasol/bucketfs-java/
[1]: https://github.com/exasol/bucketfs-java/blob/main/LICENSE
[2]: https://github.com/exasol/exasol-testcontainers/
[3]: https://github.com/exasol/exasol-testcontainers/blob/main/LICENSE
[4]: https://github.com/gturri/aXMLRPC
[5]: https://github.com/exasol/error-reporting-java/
[6]: https://github.com/exasol/error-reporting-java/blob/main/LICENSE
[7]: https://aws.amazon.com/sdkforjava
[8]: https://aws.amazon.com/apache2.0
[9]: https://github.com/mwiede/jsch
[10]: https://github.com/mwiede/jsch/blob/master/LICENSE.txt
[11]: https://github.com/mwiede/jsch/blob/master/LICENSE.JZlib.txt
[12]: https://github.com/mwiede/jsch/blob/master/LICENSE.jBCrypt.txt
[13]: https://github.com/exasol/database-cleaner/
[14]: https://github.com/exasol/database-cleaner/blob/main/LICENSE
[15]: https://github.com/eclipse-ee4j/jsonp
[16]: https://projects.eclipse.org/license/epl-2.0
[17]: https://projects.eclipse.org/license/secondary-gpl-2.0-cp
[18]: https://junit.org/junit5/
[19]: https://www.eclipse.org/legal/epl-v20.html
[20]: http://hamcrest.org/JavaHamcrest/
[21]: https://raw.githubusercontent.com/hamcrest/JavaHamcrest/master/LICENSE
[22]: https://www.jqno.nl/equalsverifier
[23]: https://www.apache.org/licenses/LICENSE-2.0.txt
[24]: https://github.com/stefanbirkner/system-lambda/
[25]: http://opensource.org/licenses/MIT
[26]: http://www.slf4j.org
[27]: http://www.opensource.org/licenses/mit-license.php
[28]: https://github.com/eclipse-ee4j/parsson
[29]: http://sonarsource.github.io/sonar-scanner-maven/
[30]: http://www.gnu.org/licenses/lgpl.txt
[31]: https://maven.apache.org/plugins/maven-toolchains-plugin/
[32]: https://maven.apache.org/plugins/maven-compiler-plugin/
[33]: https://maven.apache.org/enforcer/maven-enforcer-plugin/
[34]: https://www.mojohaus.org/flatten-maven-plugin/
[35]: https://sonatype.github.io/ossindex-maven/maven-plugin/
[36]: http://www.apache.org/licenses/LICENSE-2.0.txt
[37]: https://maven.apache.org/surefire/maven-surefire-plugin/
[38]: https://www.mojohaus.org/versions/versions-maven-plugin/
[39]: https://github.com/exasol/project-keeper/
[40]: https://github.com/exasol/project-keeper/blob/main/LICENSE
[41]: https://basepom.github.io/duplicate-finder-maven-plugin
[42]: http://www.apache.org/licenses/LICENSE-2.0.html
[43]: https://maven.apache.org/plugins/maven-deploy-plugin/
[44]: https://maven.apache.org/plugins/maven-gpg-plugin/
[45]: https://maven.apache.org/plugins/maven-source-plugin/
[46]: https://maven.apache.org/plugins/maven-javadoc-plugin/
[47]: http://www.sonatype.com/public-parent/nexus-maven-plugins/nexus-staging/nexus-staging-maven-plugin/
[48]: http://www.eclipse.org/legal/epl-v10.html
[49]: https://maven.apache.org/surefire/maven-failsafe-plugin/
[50]: https://www.jacoco.org/jacoco/trunk/doc/maven.html
[51]: https://www.eclipse.org/legal/epl-2.0/
[52]: https://github.com/exasol/error-code-crawler-maven-plugin/
[53]: https://github.com/exasol/error-code-crawler-maven-plugin/blob/main/LICENSE
[54]: http://zlika.github.io/reproducible-build-maven-plugin
