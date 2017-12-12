package com.blibli.oss.version;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Eko Kurniawan Khannedy
 */
@RestController
public class VersionController implements InitializingBean {

  private VersionProperties properties;

  private String version;

  @Autowired
  public VersionController(VersionProperties properties) {
    this.properties = properties;
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    StringBuilder builder = new StringBuilder();

    builder.append("maven.groupId=").append(properties.getGroupId()).append("\n");
    builder.append("maven.artifactId=").append(properties.getArtifactId()).append("\n");
    builder.append("maven.pom.version=").append(properties.getVersion()).append("\n");
    builder.append("maven.build.time=").append(properties.getBuildTime()).append("\n");

    version = builder.toString();
  }

  @RequestMapping(value = "/version", produces = MediaType.TEXT_PLAIN_VALUE)
  public String version() {
    return version;
  }
}
