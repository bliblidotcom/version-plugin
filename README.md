[![Build Status](https://travis-ci.org/bliblidotcom/version-plugin.svg?branch=master)](https://travis-ci.org/bliblidotcom/version-plugin)

Spring Boot Version Plugin
--------------------------

Add this dependency in your ```pom.xml```

```xml
<repositories>
    ...
    <repository>
      <snapshots>
        <enabled>false</enabled>
      </snapshots>
      <id>bintray-bliblidotcom-maven</id>
      <name>bintray</name>
      <url>https://dl.bintray.com/bliblidotcom/maven</url>
    </repository>
    ...
</repositories>
```

```xml
<dependencies>
  ...
  <dependency>
   <groupId>com.blibli.oss</groupId>
   <artifactId>version-plugin</artifactId>
   <version>0.0.1-RELEASE</version>
 </dependency>
 ...
</dependencies>
```

Add in your `pom.xml` `properties` tag

 ```xml
 <properties>
     ...
     <timestamp>${maven.build.timestamp}</timestamp>
     <maven.build.timestamp.format>yyyy-MM-dd HH:mm:ss</maven.build.timestamp.format>
     ...
 </properties>
 ```

Add in your `pom.xml` `build` tag

```xml
<build>
    ...
    <resources>
      <resource>
        <directory>src/main/resources</directory>
        <filtering>true</filtering>
      </resource>
    </resources>
    ...
</build>
```

Create `version.properties` file in `src/main/resources`

```properties
application.group-id=@project.groupId@
application.artifact-id=@project.artifactId@
application.version=@project.version@
application.build-time=@timestamp@
```

Run your spring boot app, and see :

```
http://localhost:8080/version
```

```text
maven.groupId=com.example
maven.artifactId=demo
maven.pom.version=0.0.1-SNAPSHOT
maven.build.time=2017-02-03 03:30:30
```
