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
public class VersionPropertiesTest {

  @Autowired
  private VersionProperties properties;

  @Test
  public void getGroupId() throws Exception {
    assertNotNull(properties.getGroupId());
    assertEquals("@project.groupId@", properties.getGroupId());
  }

  @Test
  public void getArtifactId() throws Exception {
    assertNotNull(properties.getArtifactId());
    assertEquals("@project.artifactId@", properties.getArtifactId());
  }

  @Test
  public void getVersion() throws Exception {
    assertNotNull(properties.getVersion());
    assertEquals("@project.version@", properties.getVersion());
  }

  @Test
  public void getBuildTime() throws Exception {
    assertNotNull(properties.getBuildTime());
    assertEquals("@timestamp@", properties.getBuildTime());
  }

}