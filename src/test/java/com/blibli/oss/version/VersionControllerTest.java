package com.blibli.oss.version;

import com.blibli.oss.version.autoconfigurer.VersionAutoConfigurer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Eko Kurniawan Khannedy
 */
@RunWith(SpringRunner.class)
@Import(VersionAutoConfigurer.class)
@TestPropertySource("classpath:version.properties")
public class VersionControllerTest {

  @Autowired
  private VersionController controller;

  @Autowired
  private VersionProperties properties;

  @Test
  public void version() throws Exception {
    StringBuilder builder = new StringBuilder();

    builder.append("maven.groupId=").append(properties.getGroupId()).append("\n");
    builder.append("maven.artifactId=").append(properties.getArtifactId()).append("\n");
    builder.append("maven.pom.version=").append(properties.getVersion()).append("\n");
    builder.append("maven.build.time=").append(properties.getBuildTime()).append("\n");

    assertEquals(builder.toString(), controller.version());
  }

}