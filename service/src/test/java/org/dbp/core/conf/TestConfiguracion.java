package org.dbp.core.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "org.dbp.service")
@Import({TestJpaConfiguration.class})
public class TestConfiguracion {

}
