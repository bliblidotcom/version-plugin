package com.blibli.oss.version;

import com.blibli.oss.version.autoconfigurer.VersionAutoConfigurer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Eko Kurniawan Khannedy
 */
@RunWith(SpringRunner.class)
@Import(VersionAutoConfigurer.class)
public class VersionAutoConfigurerTest {

  @Autowired(required = false)
  private VersionController controller;

  @Autowired(required = false)
  private VersionProperties properties;

  @Test
  public void propertiesMustExists() throws Exception {
    assertNotNull(properties);
  }

  @Test
  public void controllerMustExists() throws Exception {
    assertNotNull(controller);
  }
}