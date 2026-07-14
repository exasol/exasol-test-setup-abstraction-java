<!-- @formatter:off -->
# Dependencies

## Compile Dependencies

| Dependency                                | License                                                                                                        |
| ----------------------------------------- | -------------------------------------------------------------------------------------------------------------- |
| [BucketFS Java][0]                        | [MIT License][1]                                                                                               |
| [Test containers for Exasol on Docker][2] | [MIT License][3]                                                                                               |
| [error-reporting-java][4]                 | [MIT License][5]                                                                                               |
| [JSch][6]                                 | [Revised BSD][7]; [Revised BSD][8]; [ISC][9]                                                                   |
| [database-cleaner][10]                    | [MIT License][11]                                                                                              |
| [Jakarta JSON Processing API][12]         | [Eclipse Public License 2.0][13]; [GNU General Public License, version 2 with the GNU Classpath Exception][14] |

## Test Dependencies

| Dependency                                 | License                           |
| ------------------------------------------ | --------------------------------- |
| [JUnit Jupiter Params][15]                 | [Eclipse Public License v2.0][16] |
| [Hamcrest][17]                             | [BSD-3-Clause][18]                |
| [EqualsVerifier \| release normal jar][19] | [Apache License, Version 2.0][20] |
| [System Lambda][21]                        | [MIT License][22]                 |
| [SLF4J JDK14 Provider][23]                 | [MIT][24]                         |

## Runtime Dependencies

| Dependency            | License                                                                                                        |
| --------------------- | -------------------------------------------------------------------------------------------------------------- |
| [Eclipse Parsson][25] | [Eclipse Public License 2.0][13]; [GNU General Public License, version 2 with the GNU Classpath Exception][14] |

## Plugin Dependencies

| Dependency                                              | License                                        |
| ------------------------------------------------------- | ---------------------------------------------- |
| [SonarQube Scanner for Maven][26]                       | [GNU LGPL 3][27]                               |
| [Apache Maven Toolchains Plugin][28]                    | [Apache-2.0][20]                               |
| [Apache Maven Compiler Plugin][29]                      | [Apache-2.0][20]                               |
| [Apache Maven Enforcer Plugin][30]                      | [Apache-2.0][20]                               |
| [Maven Flatten Plugin][31]                              | [Apache Software License][20]                  |
| [org.sonatype.ossindex.maven:ossindex-maven-plugin][32] | [ASL2][33]                                     |
| [Maven Surefire Plugin][34]                             | [Apache-2.0][20]                               |
| [Versions Maven Plugin][35]                             | [Apache License, Version 2.0][20]              |
| [duplicate-finder-maven-plugin Maven Mojo][36]          | [Apache License 2.0][37]                       |
| [Apache Maven Artifact Plugin][38]                      | [Apache-2.0][20]                               |
| [Apache Maven Deploy Plugin][39]                        | [Apache-2.0][20]                               |
| [Apache Maven Source Plugin][40]                        | [Apache-2.0][20]                               |
| [Apache Maven Javadoc Plugin][41]                       | [Apache-2.0][20]                               |
| [spdx-maven-plugin Maven Plugin][42]                    | [The Apache Software License, Version 2.0][33] |
| [Build Helper Maven Plugin][43]                         | [The MIT License][44]                          |
| [Apache Maven GPG Plugin][45]                           | [Apache-2.0][20]                               |
| [Central Publishing Maven Plugin][46]                   | [The Apache License, Version 2.0][20]          |
| [Maven Failsafe Plugin][47]                             | [Apache-2.0][20]                               |
| [JaCoCo :: Maven Plugin][48]                            | [EPL-2.0][49]                                  |
| [error-code-crawler-maven-plugin][50]                   | [MIT License][51]                              |
| [Git Commit Id Maven Plugin][52]                        | [GNU Lesser General Public License 3.0][53]    |
| [Project Keeper Maven plugin][54]                       | [The MIT License][55]                          |
| [Apache Maven Clean Plugin][56]                         | [Apache-2.0][20]                               |
| [Apache Maven Resources Plugin][57]                     | [Apache-2.0][20]                               |
| [Apache Maven Install Plugin][58]                       | [Apache-2.0][20]                               |
| [Apache Maven Site Plugin][59]                          | [Apache-2.0][20]                               |

[0]: https://github.com/exasol/bucketfs-java/
[1]: https://github.com/exasol/bucketfs-java/blob/main/LICENSE
[2]: https://github.com/exasol/exasol-testcontainers/
[3]: https://github.com/exasol/exasol-testcontainers/blob/main/LICENSE
[4]: https://github.com/exasol/error-reporting-java/
[5]: https://github.com/exasol/error-reporting-java/blob/main/LICENSE
[6]: https://github.com/mwiede/jsch
[7]: https://github.com/mwiede/jsch/blob/master/LICENSE.txt
[8]: https://github.com/mwiede/jsch/blob/master/LICENSE.JZlib.txt
[9]: https://github.com/mwiede/jsch/blob/master/LICENSE.jBCrypt.txt
[10]: https://github.com/exasol/database-cleaner/
[11]: https://github.com/exasol/database-cleaner/blob/main/LICENSE
[12]: https://github.com/eclipse-ee4j/jsonp
[13]: https://projects.eclipse.org/license/epl-2.0
[14]: https://projects.eclipse.org/license/secondary-gpl-2.0-cp
[15]: https://junit.org/
[16]: https://www.eclipse.org/legal/epl-v20.html
[17]: http://hamcrest.org/JavaHamcrest/
[18]: https://raw.githubusercontent.com/hamcrest/JavaHamcrest/master/LICENSE
[19]: https://www.jqno.nl/equalsverifier
[20]: https://www.apache.org/licenses/LICENSE-2.0.txt
[21]: https://github.com/stefanbirkner/system-lambda/
[22]: http://opensource.org/licenses/MIT
[23]: http://www.slf4j.org
[24]: https://opensource.org/license/mit
[25]: https://github.com/eclipse-ee4j/parsson
[26]: https://docs.sonarsource.com/sonarqube-server/latest/extension-guide/developing-a-plugin/plugin-basics/sonar-scanner-maven/sonar-maven-plugin/
[27]: http://www.gnu.org/licenses/lgpl.txt
[28]: https://maven.apache.org/plugins/maven-toolchains-plugin/
[29]: https://maven.apache.org/plugins/maven-compiler-plugin/
[30]: https://maven.apache.org/enforcer/maven-enforcer-plugin/
[31]: https://www.mojohaus.org/flatten-maven-plugin/
[32]: https://sonatype.github.io/ossindex-maven/maven-plugin/
[33]: http://www.apache.org/licenses/LICENSE-2.0.txt
[34]: https://maven.apache.org/surefire/maven-surefire-plugin/
[35]: https://www.mojohaus.org/versions/versions-maven-plugin/
[36]: https://basepom.github.io/duplicate-finder-maven-plugin
[37]: http://www.apache.org/licenses/LICENSE-2.0.html
[38]: https://maven.apache.org/plugins/maven-artifact-plugin/
[39]: https://maven.apache.org/plugins/maven-deploy-plugin/
[40]: https://maven.apache.org/plugins/maven-source-plugin/
[41]: https://maven.apache.org/plugins/maven-javadoc-plugin/
[42]: https://github.com/spdx/spdx-maven-plugin
[43]: https://www.mojohaus.org/build-helper-maven-plugin/
[44]: https://spdx.org/licenses/MIT.txt
[45]: https://maven.apache.org/plugins/maven-gpg-plugin/
[46]: https://central.sonatype.org
[47]: https://maven.apache.org/surefire/maven-failsafe-plugin/
[48]: https://www.jacoco.org/jacoco/trunk/doc/maven.html
[49]: https://www.eclipse.org/legal/epl-2.0/
[50]: https://github.com/exasol/error-code-crawler-maven-plugin/
[51]: https://github.com/exasol/error-code-crawler-maven-plugin/blob/main/LICENSE
[52]: https://github.com/git-commit-id/git-commit-id-maven-plugin
[53]: http://www.gnu.org/licenses/lgpl-3.0.txt
[54]: https://github.com/exasol/project-keeper/
[55]: https://github.com/exasol/project-keeper/blob/main/LICENSE
[56]: https://maven.apache.org/plugins/maven-clean-plugin/
[57]: https://maven.apache.org/plugins/maven-resources-plugin/
[58]: https://maven.apache.org/plugins/maven-install-plugin/
[59]: https://maven.apache.org/plugins/maven-site-plugin/
