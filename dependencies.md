<!-- @formatter:off -->
# Dependencies

## Compile Dependencies

| Dependency                                          | License                                                                                                        |
| --------------------------------------------------- | -------------------------------------------------------------------------------------------------------------- |
| [BucketFS Java][0]                                  | [MIT][1]                                                                                                       |
| [Test containers for Exasol on Docker][2]           | [MIT][1]                                                                                                       |
| [aXMLRPC][4]                                        | The MIT License (MIT)                                                                                          |
| [error-reporting-java][5]                           | [MIT][1]                                                                                                       |
| [AWS Java SDK :: Services :: AWS CloudFormation][7] | [Apache License, Version 2.0][8]                                                                               |
| [AWS Java SDK :: Services :: Amazon EC2][7]         | [Apache License, Version 2.0][8]                                                                               |
| [JSch][11]                                          | [Revised BSD][12]                                                                                              |
| [database-cleaner][13]                              | [MIT][1]                                                                                                       |
| [Jakarta JSON Processing API][15]                   | [Eclipse Public License 2.0][16]; [GNU General Public License, version 2 with the GNU Classpath Exception][17] |
| [Project Lombok][18]                                | [The MIT License][19]                                                                                          |

## Test Dependencies

| Dependency                                | License                           |
| ----------------------------------------- | --------------------------------- |
| [JUnit Jupiter Engine][20]                | [Eclipse Public License v2.0][21] |
| [JUnit Jupiter Params][20]                | [Eclipse Public License v2.0][21] |
| [Hamcrest][24]                            | [BSD License 3][25]               |
| [EqualsVerifier | release normal jar][26] | [Apache License, Version 2.0][27] |
| [System Lambda][28]                       | [MIT License][29]                 |

## Runtime Dependencies

| Dependency                    | License                                                                                                        |
| ----------------------------- | -------------------------------------------------------------------------------------------------------------- |
| [JSON-P Default Provider][15] | [Eclipse Public License 2.0][16]; [GNU General Public License, version 2 with the GNU Classpath Exception][17] |

## Plugin Dependencies

| Dependency                                              | License                                        |
| ------------------------------------------------------- | ---------------------------------------------- |
| [SonarQube Scanner for Maven][33]                       | [GNU LGPL 3][34]                               |
| [Apache Maven Compiler Plugin][35]                      | [Apache License, Version 2.0][27]              |
| [Apache Maven Enforcer Plugin][37]                      | [Apache License, Version 2.0][27]              |
| [Maven Flatten Plugin][39]                              | [Apache Software Licenese][40]                 |
| [org.sonatype.ossindex.maven:ossindex-maven-plugin][41] | [ASL2][40]                                     |
| [Reproducible Build Maven Plugin][43]                   | [Apache 2.0][40]                               |
| [Maven Surefire Plugin][45]                             | [Apache License, Version 2.0][27]              |
| [Maven Dependency Plugin][47]                           | [The Apache Software License, Version 2.0][40] |
| [Versions Maven Plugin][49]                             | [Apache License, Version 2.0][27]              |
| [Apache Maven Deploy Plugin][51]                        | [Apache License, Version 2.0][27]              |
| [Apache Maven GPG Plugin][53]                           | [Apache License, Version 2.0][27]              |
| [Apache Maven Source Plugin][55]                        | [Apache License, Version 2.0][27]              |
| [Apache Maven Javadoc Plugin][57]                       | [Apache License, Version 2.0][27]              |
| [Nexus Staging Maven Plugin][59]                        | [Eclipse Public License][60]                   |
| [Lombok Maven Plugin][61]                               | [The MIT License][1]                           |
| [Maven Failsafe Plugin][63]                             | [Apache License, Version 2.0][27]              |
| [Project keeper maven plugin][65]                       | [The MIT License][66]                          |
| [JaCoCo :: Maven Plugin][67]                            | [Eclipse Public License 2.0][68]               |
| [error-code-crawler-maven-plugin][69]                   | [MIT][1]                                       |
| [Maven Clean Plugin][71]                                | [The Apache Software License, Version 2.0][40] |
| [Maven Resources Plugin][73]                            | [The Apache Software License, Version 2.0][40] |
| [Maven JAR Plugin][75]                                  | [The Apache Software License, Version 2.0][40] |
| [Maven Install Plugin][77]                              | [The Apache Software License, Version 2.0][40] |
| [Maven Site Plugin 3][79]                               | [The Apache Software License, Version 2.0][40] |

[0]: https://github.com/exasol/bucketfs-java
[5]: https://github.com/exasol/error-reporting-java
[40]: http://www.apache.org/licenses/LICENSE-2.0.txt
[18]: https://projectlombok.org
[45]: https://maven.apache.org/surefire/maven-surefire-plugin/
[71]: http://maven.apache.org/plugins/maven-clean-plugin/
[7]: https://aws.amazon.com/sdkforjava
[1]: https://opensource.org/licenses/MIT
[39]: https://www.mojohaus.org/flatten-maven-plugin/
[49]: http://www.mojohaus.org/versions-maven-plugin/
[65]: https://github.com/exasol/project-keeper/
[25]: http://opensource.org/licenses/BSD-3-Clause
[35]: https://maven.apache.org/plugins/maven-compiler-plugin/
[28]: https://github.com/stefanbirkner/system-lambda/
[68]: https://www.eclipse.org/legal/epl-2.0/
[51]: https://maven.apache.org/plugins/maven-deploy-plugin/
[34]: http://www.gnu.org/licenses/lgpl.txt
[67]: https://www.jacoco.org/jacoco/trunk/doc/maven.html
[8]: https://aws.amazon.com/apache2.0
[19]: https://projectlombok.org/LICENSE
[43]: http://zlika.github.io/reproducible-build-maven-plugin
[33]: http://sonarsource.github.io/sonar-scanner-maven/
[4]: https://github.com/gturri/aXMLRPC
[20]: https://junit.org/junit5/
[15]: https://github.com/eclipse-ee4j/jsonp
[55]: https://maven.apache.org/plugins/maven-source-plugin/
[17]: https://projects.eclipse.org/license/secondary-gpl-2.0-cp
[24]: http://hamcrest.org/JavaHamcrest/
[73]: http://maven.apache.org/plugins/maven-resources-plugin/
[11]: http://www.jcraft.com/jsch/
[59]: http://www.sonatype.com/public-parent/nexus-maven-plugins/nexus-staging/nexus-staging-maven-plugin/
[63]: https://maven.apache.org/surefire/maven-failsafe-plugin/
[47]: http://maven.apache.org/plugins/maven-dependency-plugin/
[29]: http://opensource.org/licenses/MIT
[60]: http://www.eclipse.org/legal/epl-v10.html
[2]: https://github.com/exasol/exasol-testcontainers
[66]: https://github.com/exasol/project-keeper/blob/main/LICENSE
[75]: http://maven.apache.org/plugins/maven-jar-plugin/
[16]: https://projects.eclipse.org/license/epl-2.0
[27]: https://www.apache.org/licenses/LICENSE-2.0.txt
[26]: https://www.jqno.nl/equalsverifier
[37]: https://maven.apache.org/enforcer/maven-enforcer-plugin/
[21]: https://www.eclipse.org/legal/epl-v20.html
[77]: http://maven.apache.org/plugins/maven-install-plugin/
[41]: https://sonatype.github.io/ossindex-maven/maven-plugin/
[53]: https://maven.apache.org/plugins/maven-gpg-plugin/
[61]: https://anthonywhitford.com/lombok.maven/lombok-maven-plugin/
[12]: http://www.jcraft.com/jsch/LICENSE.txt
[79]: http://maven.apache.org/plugins/maven-site-plugin/
[57]: https://maven.apache.org/plugins/maven-javadoc-plugin/
[13]: https://github.com/exasol/database-cleaner
[69]: https://github.com/exasol/error-code-crawler-maven-plugin
