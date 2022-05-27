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
| [Apache Commons Codec][11]                          | [Apache License, Version 2.0][12]                                                                              |
| [JSch][13]                                          | [Revised BSD][14]                                                                                              |
| [database-cleaner][15]                              | [MIT][1]                                                                                                       |
| [Jakarta JSON Processing API][17]                   | [Eclipse Public License 2.0][18]; [GNU General Public License, version 2 with the GNU Classpath Exception][19] |
| [Project Lombok][20]                                | [The MIT License][21]                                                                                          |

## Test Dependencies

| Dependency                                | License                           |
| ----------------------------------------- | --------------------------------- |
| [JUnit Jupiter Engine][22]                | [Eclipse Public License v2.0][23] |
| [JUnit Jupiter Params][22]                | [Eclipse Public License v2.0][23] |
| [Hamcrest][26]                            | [BSD License 3][27]               |
| [EqualsVerifier | release normal jar][28] | [Apache License, Version 2.0][12] |
| [System Lambda][30]                       | [MIT License][31]                 |

## Runtime Dependencies

| Dependency                    | License                                                                                                        |
| ----------------------------- | -------------------------------------------------------------------------------------------------------------- |
| [JSON-P Default Provider][17] | [Eclipse Public License 2.0][18]; [GNU General Public License, version 2 with the GNU Classpath Exception][19] |

## Plugin Dependencies

| Dependency                                              | License                                        |
| ------------------------------------------------------- | ---------------------------------------------- |
| [SonarQube Scanner for Maven][35]                       | [GNU LGPL 3][36]                               |
| [Apache Maven Compiler Plugin][37]                      | [Apache License, Version 2.0][12]              |
| [Apache Maven Enforcer Plugin][39]                      | [Apache License, Version 2.0][12]              |
| [Maven Flatten Plugin][41]                              | [Apache Software Licenese][42]                 |
| [org.sonatype.ossindex.maven:ossindex-maven-plugin][43] | [ASL2][42]                                     |
| [Reproducible Build Maven Plugin][45]                   | [Apache 2.0][42]                               |
| [Maven Surefire Plugin][47]                             | [Apache License, Version 2.0][12]              |
| [Maven Dependency Plugin][49]                           | [The Apache Software License, Version 2.0][42] |
| [Versions Maven Plugin][51]                             | [Apache License, Version 2.0][12]              |
| [Apache Maven Deploy Plugin][53]                        | [Apache License, Version 2.0][12]              |
| [Apache Maven GPG Plugin][55]                           | [Apache License, Version 2.0][12]              |
| [Apache Maven Source Plugin][57]                        | [Apache License, Version 2.0][12]              |
| [Apache Maven Javadoc Plugin][59]                       | [Apache License, Version 2.0][12]              |
| [Nexus Staging Maven Plugin][61]                        | [Eclipse Public License][62]                   |
| [Lombok Maven Plugin][63]                               | [The MIT License][1]                           |
| [Maven Failsafe Plugin][65]                             | [Apache License, Version 2.0][12]              |
| [Project keeper maven plugin][67]                       | [The MIT License][68]                          |
| [JaCoCo :: Maven Plugin][69]                            | [Eclipse Public License 2.0][70]               |
| [error-code-crawler-maven-plugin][71]                   | [MIT][1]                                       |
| [Maven Clean Plugin][73]                                | [The Apache Software License, Version 2.0][42] |
| [Maven Resources Plugin][75]                            | [The Apache Software License, Version 2.0][42] |
| [Maven JAR Plugin][77]                                  | [The Apache Software License, Version 2.0][42] |
| [Maven Install Plugin][79]                              | [The Apache Software License, Version 2.0][42] |
| [Maven Site Plugin 3][81]                               | [The Apache Software License, Version 2.0][42] |

[0]: https://github.com/exasol/bucketfs-java
[5]: https://github.com/exasol/error-reporting-java
[42]: http://www.apache.org/licenses/LICENSE-2.0.txt
[20]: https://projectlombok.org
[47]: https://maven.apache.org/surefire/maven-surefire-plugin/
[73]: http://maven.apache.org/plugins/maven-clean-plugin/
[7]: https://aws.amazon.com/sdkforjava
[1]: https://opensource.org/licenses/MIT
[41]: https://www.mojohaus.org/flatten-maven-plugin/
[11]: https://commons.apache.org/proper/commons-codec/
[51]: http://www.mojohaus.org/versions-maven-plugin/
[67]: https://github.com/exasol/project-keeper/
[27]: http://opensource.org/licenses/BSD-3-Clause
[37]: https://maven.apache.org/plugins/maven-compiler-plugin/
[30]: https://github.com/stefanbirkner/system-lambda/
[70]: https://www.eclipse.org/legal/epl-2.0/
[53]: https://maven.apache.org/plugins/maven-deploy-plugin/
[36]: http://www.gnu.org/licenses/lgpl.txt
[69]: https://www.jacoco.org/jacoco/trunk/doc/maven.html
[8]: https://aws.amazon.com/apache2.0
[21]: https://projectlombok.org/LICENSE
[45]: http://zlika.github.io/reproducible-build-maven-plugin
[35]: http://sonarsource.github.io/sonar-scanner-maven/
[4]: https://github.com/gturri/aXMLRPC
[22]: https://junit.org/junit5/
[17]: https://github.com/eclipse-ee4j/jsonp
[57]: https://maven.apache.org/plugins/maven-source-plugin/
[19]: https://projects.eclipse.org/license/secondary-gpl-2.0-cp
[26]: http://hamcrest.org/JavaHamcrest/
[75]: http://maven.apache.org/plugins/maven-resources-plugin/
[13]: http://www.jcraft.com/jsch/
[61]: http://www.sonatype.com/public-parent/nexus-maven-plugins/nexus-staging/nexus-staging-maven-plugin/
[65]: https://maven.apache.org/surefire/maven-failsafe-plugin/
[49]: http://maven.apache.org/plugins/maven-dependency-plugin/
[31]: http://opensource.org/licenses/MIT
[62]: http://www.eclipse.org/legal/epl-v10.html
[2]: https://github.com/exasol/exasol-testcontainers
[68]: https://github.com/exasol/project-keeper/blob/main/LICENSE
[77]: http://maven.apache.org/plugins/maven-jar-plugin/
[18]: https://projects.eclipse.org/license/epl-2.0
[12]: https://www.apache.org/licenses/LICENSE-2.0.txt
[28]: https://www.jqno.nl/equalsverifier
[39]: https://maven.apache.org/enforcer/maven-enforcer-plugin/
[23]: https://www.eclipse.org/legal/epl-v20.html
[79]: http://maven.apache.org/plugins/maven-install-plugin/
[43]: https://sonatype.github.io/ossindex-maven/maven-plugin/
[55]: https://maven.apache.org/plugins/maven-gpg-plugin/
[63]: https://anthonywhitford.com/lombok.maven/lombok-maven-plugin/
[14]: http://www.jcraft.com/jsch/LICENSE.txt
[81]: http://maven.apache.org/plugins/maven-site-plugin/
[59]: https://maven.apache.org/plugins/maven-javadoc-plugin/
[15]: https://github.com/exasol/database-cleaner
[71]: https://github.com/exasol/error-code-crawler-maven-plugin
