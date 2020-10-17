package org.johnpc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Created By JohnPC
 */

@Configuration
@Import(GameConfig.class)
@ComponentScan(basePackages = "org.johnpc")
@Deprecated
public class AppConfig {

}
