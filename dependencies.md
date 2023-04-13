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
| [SLF4J JDK14 Binding][25]                 | [MIT License][26]                 |

## Runtime Dependencies

| Dependency            | License                                                                                                        |
| --------------------- | -------------------------------------------------------------------------------------------------------------- |
| [Eclipse Parsson][27] | [Eclipse Public License 2.0][16]; [GNU General Public License, version 2 with the GNU Classpath Exception][17] |

## Plugin Dependencies

| Dependency                                              | License                                        |
| ------------------------------------------------------- | ---------------------------------------------- |
| [SonarQube Scanner for Maven][28]                       | [GNU LGPL 3][29]                               |
| [Apache Maven Compiler Plugin][30]                      | [Apache License, Version 2.0][10]              |
| [Apache Maven Enforcer Plugin][31]                      | [Apache-2.0][10]                               |
| [Maven Flatten Plugin][32]                              | [Apache Software Licenese][10]                 |
| [org.sonatype.ossindex.maven:ossindex-maven-plugin][33] | [ASL2][34]                                     |
| [Maven Surefire Plugin][35]                             | [Apache License, Version 2.0][10]              |
| [Versions Maven Plugin][36]                             | [Apache License, Version 2.0][10]              |
| [Apache Maven Deploy Plugin][37]                        | [Apache-2.0][10]                               |
| [Apache Maven GPG Plugin][38]                           | [Apache License, Version 2.0][10]              |
| [Apache Maven Source Plugin][39]                        | [Apache License, Version 2.0][10]              |
| [Apache Maven Javadoc Plugin][40]                       | [Apache License, Version 2.0][10]              |
| [Nexus Staging Maven Plugin][41]                        | [Eclipse Public License][42]                   |
| [Maven Failsafe Plugin][43]                             | [Apache License, Version 2.0][10]              |
| [JaCoCo :: Maven Plugin][44]                            | [Eclipse Public License 2.0][45]               |
| [error-code-crawler-maven-plugin][46]                   | [MIT License][47]                              |
| [Reproducible Build Maven Plugin][48]                   | [Apache 2.0][34]                               |
| [Project keeper maven plugin][49]                       | [The MIT License][50]                          |
| [duplicate-finder-maven-plugin Maven Mojo][51]          | [Apache License 2.0][52]                       |
| [Maven Clean Plugin][53]                                | [The Apache Software License, Version 2.0][34] |
| [Maven Resources Plugin][54]                            | [The Apache Software License, Version 2.0][34] |
| [Maven JAR Plugin][55]                                  | [The Apache Software License, Version 2.0][34] |
| [Maven Install Plugin][56]                              | [The Apache Software License, Version 2.0][34] |
| [Maven Site Plugin 3][57]                               | [The Apache Software License, Version 2.0][34] |

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
[25]: http://www.slf4j.org
[26]: http://www.opensource.org/licenses/mit-license.php
[27]: https://github.com/eclipse-ee4j/parsson
[28]: http://sonarsource.github.io/sonar-scanner-maven/
[29]: http://www.gnu.org/licenses/lgpl.txt
[30]: https://maven.apache.org/plugins/maven-compiler-plugin/
[31]: https://maven.apache.org/enforcer/maven-enforcer-plugin/
[32]: https://www.mojohaus.org/flatten-maven-plugin/
[33]: https://sonatype.github.io/ossindex-maven/maven-plugin/
[34]: http://www.apache.org/licenses/LICENSE-2.0.txt
[35]: https://maven.apache.org/surefire/maven-surefire-plugin/
[36]: https://www.mojohaus.org/versions/versions-maven-plugin/
[37]: https://maven.apache.org/plugins/maven-deploy-plugin/
[38]: https://maven.apache.org/plugins/maven-gpg-plugin/
[39]: https://maven.apache.org/plugins/maven-source-plugin/
[40]: https://maven.apache.org/plugins/maven-javadoc-plugin/
[41]: http://www.sonatype.com/public-parent/nexus-maven-plugins/nexus-staging/nexus-staging-maven-plugin/
[42]: http://www.eclipse.org/legal/epl-v10.html
[43]: https://maven.apache.org/surefire/maven-failsafe-plugin/
[44]: https://www.jacoco.org/jacoco/trunk/doc/maven.html
[45]: https://www.eclipse.org/legal/epl-2.0/
[46]: https://github.com/exasol/error-code-crawler-maven-plugin/
[47]: https://github.com/exasol/error-code-crawler-maven-plugin/blob/main/LICENSE
[48]: http://zlika.github.io/reproducible-build-maven-plugin
[49]: https://github.com/exasol/project-keeper/
[50]: https://github.com/exasol/project-keeper/blob/main/LICENSE
[51]: https://github.com/basepom/duplicate-finder-maven-plugin
[52]: http://www.apache.org/licenses/LICENSE-2.0.html
[53]: http://maven.apache.org/plugins/maven-clean-plugin/
[54]: http://maven.apache.org/plugins/maven-resources-plugin/
[55]: http://maven.apache.org/plugins/maven-jar-plugin/
[56]: http://maven.apache.org/plugins/maven-install-plugin/
[57]: http://maven.apache.org/plugins/maven-site-plugin/
