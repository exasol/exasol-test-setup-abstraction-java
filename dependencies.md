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
| [Apache Commons Codec][9]                           | [Apache License, Version 2.0][10]                                                                              |
| [JSch][11]                                          | [Revised BSD][12]                                                                                              |
| [database-cleaner][13]                              | [MIT License][14]                                                                                              |
| [Jakarta JSON Processing API][15]                   | [Eclipse Public License 2.0][16]; [GNU General Public License, version 2 with the GNU Classpath Exception][17] |

## Test Dependencies

| Dependency                                | License                           |
| ----------------------------------------- | --------------------------------- |
| [JUnit Jupiter Engine][18]                | [Eclipse Public License v2.0][19] |
| [JUnit Jupiter Params][18]                | [Eclipse Public License v2.0][19] |
| [Hamcrest][20]                            | [BSD License 3][21]               |
| [EqualsVerifier | release normal jar][22] | [Apache License, Version 2.0][10] |
| [System Lambda][23]                       | [MIT License][24]                 |

## Runtime Dependencies

| Dependency            | License                                                                                                        |
| --------------------- | -------------------------------------------------------------------------------------------------------------- |
| [Eclipse Parsson][25] | [Eclipse Public License 2.0][16]; [GNU General Public License, version 2 with the GNU Classpath Exception][17] |

## Plugin Dependencies

| Dependency                                              | License                                        |
| ------------------------------------------------------- | ---------------------------------------------- |
| [SonarQube Scanner for Maven][26]                       | [GNU LGPL 3][27]                               |
| [Apache Maven Compiler Plugin][28]                      | [Apache License, Version 2.0][10]              |
| [Apache Maven Enforcer Plugin][29]                      | [Apache-2.0][10]                               |
| [Maven Flatten Plugin][30]                              | [Apache Software Licenese][10]                 |
| [org.sonatype.ossindex.maven:ossindex-maven-plugin][31] | [ASL2][32]                                     |
| [Maven Surefire Plugin][33]                             | [Apache License, Version 2.0][10]              |
| [Versions Maven Plugin][34]                             | [Apache License, Version 2.0][10]              |
| [Apache Maven Deploy Plugin][35]                        | [Apache-2.0][10]                               |
| [Apache Maven GPG Plugin][36]                           | [Apache License, Version 2.0][10]              |
| [Apache Maven Source Plugin][37]                        | [Apache License, Version 2.0][10]              |
| [Apache Maven Javadoc Plugin][38]                       | [Apache License, Version 2.0][10]              |
| [Nexus Staging Maven Plugin][39]                        | [Eclipse Public License][40]                   |
| [Maven Failsafe Plugin][41]                             | [Apache License, Version 2.0][10]              |
| [JaCoCo :: Maven Plugin][42]                            | [Eclipse Public License 2.0][43]               |
| [error-code-crawler-maven-plugin][44]                   | [MIT License][45]                              |
| [Reproducible Build Maven Plugin][46]                   | [Apache 2.0][32]                               |
| [Project keeper maven plugin][47]                       | [The MIT License][48]                          |
| [duplicate-finder-maven-plugin Maven Mojo][49]          | [Apache License 2.0][50]                       |
| [Maven Clean Plugin][51]                                | [The Apache Software License, Version 2.0][32] |
| [Maven Resources Plugin][52]                            | [The Apache Software License, Version 2.0][32] |
| [Maven JAR Plugin][53]                                  | [The Apache Software License, Version 2.0][32] |
| [Maven Install Plugin][54]                              | [The Apache Software License, Version 2.0][32] |
| [Maven Site Plugin 3][55]                               | [The Apache Software License, Version 2.0][32] |

[0]: https://github.com/exasol/bucketfs-java/
[1]: https://github.com/exasol/bucketfs-java/blob/main/LICENSE
[2]: https://github.com/exasol/exasol-testcontainers/
[3]: https://github.com/exasol/exasol-testcontainers/blob/main/LICENSE
[4]: https://github.com/gturri/aXMLRPC
[5]: https://github.com/exasol/error-reporting-java/
[6]: https://github.com/exasol/error-reporting-java/blob/main/LICENSE
[7]: https://aws.amazon.com/sdkforjava
[8]: https://aws.amazon.com/apache2.0
[9]: https://commons.apache.org/proper/commons-codec/
[10]: https://www.apache.org/licenses/LICENSE-2.0.txt
[11]: http://www.jcraft.com/jsch/
[12]: http://www.jcraft.com/jsch/LICENSE.txt
[13]: https://github.com/exasol/database-cleaner/
[14]: https://github.com/exasol/database-cleaner/blob/main/LICENSE
[15]: https://github.com/eclipse-ee4j/jsonp
[16]: https://projects.eclipse.org/license/epl-2.0
[17]: https://projects.eclipse.org/license/secondary-gpl-2.0-cp
[18]: https://junit.org/junit5/
[19]: https://www.eclipse.org/legal/epl-v20.html
[20]: http://hamcrest.org/JavaHamcrest/
[21]: http://opensource.org/licenses/BSD-3-Clause
[22]: https://www.jqno.nl/equalsverifier
[23]: https://github.com/stefanbirkner/system-lambda/
[24]: http://opensource.org/licenses/MIT
[25]: https://github.com/eclipse-ee4j/parsson
[26]: http://sonarsource.github.io/sonar-scanner-maven/
[27]: http://www.gnu.org/licenses/lgpl.txt
[28]: https://maven.apache.org/plugins/maven-compiler-plugin/
[29]: https://maven.apache.org/enforcer/maven-enforcer-plugin/
[30]: https://www.mojohaus.org/flatten-maven-plugin/
[31]: https://sonatype.github.io/ossindex-maven/maven-plugin/
[32]: http://www.apache.org/licenses/LICENSE-2.0.txt
[33]: https://maven.apache.org/surefire/maven-surefire-plugin/
[34]: https://www.mojohaus.org/versions/versions-maven-plugin/
[35]: https://maven.apache.org/plugins/maven-deploy-plugin/
[36]: https://maven.apache.org/plugins/maven-gpg-plugin/
[37]: https://maven.apache.org/plugins/maven-source-plugin/
[38]: https://maven.apache.org/plugins/maven-javadoc-plugin/
[39]: http://www.sonatype.com/public-parent/nexus-maven-plugins/nexus-staging/nexus-staging-maven-plugin/
[40]: http://www.eclipse.org/legal/epl-v10.html
[41]: https://maven.apache.org/surefire/maven-failsafe-plugin/
[42]: https://www.jacoco.org/jacoco/trunk/doc/maven.html
[43]: https://www.eclipse.org/legal/epl-2.0/
[44]: https://github.com/exasol/error-code-crawler-maven-plugin/
[45]: https://github.com/exasol/error-code-crawler-maven-plugin/blob/main/LICENSE
[46]: http://zlika.github.io/reproducible-build-maven-plugin
[47]: https://github.com/exasol/project-keeper/
[48]: https://github.com/exasol/project-keeper/blob/main/LICENSE
[49]: https://github.com/basepom/duplicate-finder-maven-plugin
[50]: http://www.apache.org/licenses/LICENSE-2.0.html
[51]: http://maven.apache.org/plugins/maven-clean-plugin/
[52]: http://maven.apache.org/plugins/maven-resources-plugin/
[53]: http://maven.apache.org/plugins/maven-jar-plugin/
[54]: http://maven.apache.org/plugins/maven-install-plugin/
[55]: http://maven.apache.org/plugins/maven-site-plugin/
