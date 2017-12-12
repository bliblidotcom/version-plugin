package com.blibli.oss.version.autoconfigurer;

import com.blibli.oss.version.VersionProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Eko Kurniawan Khannedy
 */
@Configuration
@EnableConfigurationProperties({
    VersionProperties.class
})
@ComponentScan("com.blibli.oss.version")
@PropertySource(ignoreResourceNotFound = true, value = "classpath:version.properties")
public class VersionAutoConfigurer {

}
