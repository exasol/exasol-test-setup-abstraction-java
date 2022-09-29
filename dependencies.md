<!-- @formatter:off -->
# Dependencies

## Compile Dependencies

| Dependency                                          | License                                                                                                        |
| --------------------------------------------------- | -------------------------------------------------------------------------------------------------------------- |
| [BucketFS Java][0]                                  | [MIT][1]                                                                                                       |
| [Test containers for Exasol on Docker][2]           | [MIT][1]                                                                                                       |
| [aXMLRPC][3]                                        | The MIT License (MIT)                                                                                          |
| [error-reporting-java][4]                           | [MIT][1]                                                                                                       |
| [AWS Java SDK :: Services :: AWS CloudFormation][5] | [Apache License, Version 2.0][6]                                                                               |
| [AWS Java SDK :: Services :: Amazon EC2][5]         | [Apache License, Version 2.0][6]                                                                               |
| [Apache Commons Codec][7]                           | [Apache License, Version 2.0][8]                                                                               |
| [JSch][9]                                           | [Revised BSD][10]                                                                                              |
| [database-cleaner][11]                              | [MIT][1]                                                                                                       |
| [Jakarta JSON Processing API][12]                   | [Eclipse Public License 2.0][13]; [GNU General Public License, version 2 with the GNU Classpath Exception][14] |
| [Project Lombok][15]                                | [The MIT License][16]                                                                                          |

## Test Dependencies

| Dependency                                | License                           |
| ----------------------------------------- | --------------------------------- |
| [JUnit Jupiter Engine][17]                | [Eclipse Public License v2.0][18] |
| [JUnit Jupiter Params][17]                | [Eclipse Public License v2.0][18] |
| [Hamcrest][19]                            | [BSD License 3][20]               |
| [EqualsVerifier | release normal jar][21] | [Apache License, Version 2.0][8]  |
| [System Lambda][22]                       | [MIT License][23]                 |

## Runtime Dependencies

| Dependency                    | License                                                                                                        |
| ----------------------------- | -------------------------------------------------------------------------------------------------------------- |
| [JSON-P Default Provider][12] | [Eclipse Public License 2.0][13]; [GNU General Public License, version 2 with the GNU Classpath Exception][14] |

## Plugin Dependencies

| Dependency                                              | License                                        |
| ------------------------------------------------------- | ---------------------------------------------- |
| [SonarQube Scanner for Maven][24]                       | [GNU LGPL 3][25]                               |
| [Apache Maven Compiler Plugin][26]                      | [Apache License, Version 2.0][8]               |
| [Apache Maven Enforcer Plugin][27]                      | [Apache License, Version 2.0][8]               |
| [Maven Flatten Plugin][28]                              | [Apache Software Licenese][29]                 |
| [org.sonatype.ossindex.maven:ossindex-maven-plugin][30] | [ASL2][29]                                     |
| [Maven Surefire Plugin][31]                             | [Apache License, Version 2.0][8]               |
| [Maven Dependency Plugin][32]                           | [The Apache Software License, Version 2.0][29] |
| [Versions Maven Plugin][33]                             | [Apache License, Version 2.0][8]               |
| [Apache Maven Deploy Plugin][34]                        | [Apache License, Version 2.0][8]               |
| [Apache Maven GPG Plugin][35]                           | [Apache License, Version 2.0][8]               |
| [Apache Maven Source Plugin][36]                        | [Apache License, Version 2.0][8]               |
| [Apache Maven Javadoc Plugin][37]                       | [Apache License, Version 2.0][8]               |
| [Nexus Staging Maven Plugin][38]                        | [Eclipse Public License][39]                   |
| [Lombok Maven Plugin][40]                               | [The MIT License][1]                           |
| [Maven Failsafe Plugin][41]                             | [Apache License, Version 2.0][8]               |
| [Project keeper maven plugin][42]                       | [The MIT License][43]                          |
| [JaCoCo :: Maven Plugin][44]                            | [Eclipse Public License 2.0][45]               |
| [error-code-crawler-maven-plugin][46]                   | [MIT][1]                                       |
| [Reproducible Build Maven Plugin][47]                   | [Apache 2.0][29]                               |
| [Maven Clean Plugin][48]                                | [The Apache Software License, Version 2.0][29] |
| [Maven Resources Plugin][49]                            | [The Apache Software License, Version 2.0][29] |
| [Maven JAR Plugin][50]                                  | [The Apache Software License, Version 2.0][29] |
| [Maven Install Plugin][51]                              | [The Apache Software License, Version 2.0][29] |
| [Maven Site Plugin 3][52]                               | [The Apache Software License, Version 2.0][29] |

[0]: https://github.com/exasol/bucketfs-java
[1]: https://opensource.org/licenses/MIT
[2]: https://github.com/exasol/exasol-testcontainers
[3]: https://github.com/gturri/aXMLRPC
[4]: https://github.com/exasol/error-reporting-java
[5]: https://aws.amazon.com/sdkforjava
[6]: https://aws.amazon.com/apache2.0
[7]: https://commons.apache.org/proper/commons-codec/
[8]: https://www.apache.org/licenses/LICENSE-2.0.txt
[9]: http://www.jcraft.com/jsch/
[10]: http://www.jcraft.com/jsch/LICENSE.txt
[11]: https://github.com/exasol/database-cleaner
[12]: https://github.com/eclipse-ee4j/jsonp
[13]: https://projects.eclipse.org/license/epl-2.0
[14]: https://projects.eclipse.org/license/secondary-gpl-2.0-cp
[15]: https://projectlombok.org
[16]: https://projectlombok.org/LICENSE
[17]: https://junit.org/junit5/
[18]: https://www.eclipse.org/legal/epl-v20.html
[19]: http://hamcrest.org/JavaHamcrest/
[20]: http://opensource.org/licenses/BSD-3-Clause
[21]: https://www.jqno.nl/equalsverifier
[22]: https://github.com/stefanbirkner/system-lambda/
[23]: http://opensource.org/licenses/MIT
[24]: http://sonarsource.github.io/sonar-scanner-maven/
[25]: http://www.gnu.org/licenses/lgpl.txt
[26]: https://maven.apache.org/plugins/maven-compiler-plugin/
[27]: https://maven.apache.org/enforcer/maven-enforcer-plugin/
[28]: https://www.mojohaus.org/flatten-maven-plugin/
[29]: http://www.apache.org/licenses/LICENSE-2.0.txt
[30]: https://sonatype.github.io/ossindex-maven/maven-plugin/
[31]: https://maven.apache.org/surefire/maven-surefire-plugin/
[32]: http://maven.apache.org/plugins/maven-dependency-plugin/
[33]: http://www.mojohaus.org/versions-maven-plugin/
[34]: https://maven.apache.org/plugins/maven-deploy-plugin/
[35]: https://maven.apache.org/plugins/maven-gpg-plugin/
[36]: https://maven.apache.org/plugins/maven-source-plugin/
[37]: https://maven.apache.org/plugins/maven-javadoc-plugin/
[38]: http://www.sonatype.com/public-parent/nexus-maven-plugins/nexus-staging/nexus-staging-maven-plugin/
[39]: http://www.eclipse.org/legal/epl-v10.html
[40]: https://anthonywhitford.com/lombok.maven/lombok-maven-plugin/
[41]: https://maven.apache.org/surefire/maven-failsafe-plugin/
[42]: https://github.com/exasol/project-keeper/
[43]: https://github.com/exasol/project-keeper/blob/main/LICENSE
[44]: https://www.jacoco.org/jacoco/trunk/doc/maven.html
[45]: https://www.eclipse.org/legal/epl-2.0/
[46]: https://github.com/exasol/error-code-crawler-maven-plugin
[47]: http://zlika.github.io/reproducible-build-maven-plugin
[48]: http://maven.apache.org/plugins/maven-clean-plugin/
[49]: http://maven.apache.org/plugins/maven-resources-plugin/
[50]: http://maven.apache.org/plugins/maven-jar-plugin/
[51]: http://maven.apache.org/plugins/maven-install-plugin/
[52]: http://maven.apache.org/plugins/maven-site-plugin/
