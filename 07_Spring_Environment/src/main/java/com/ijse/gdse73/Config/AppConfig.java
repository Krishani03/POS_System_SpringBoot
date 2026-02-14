package com.ijse.gdse73.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(
        basePackages = {"com.ijse.gdse73.bean"}
)
@PropertySource("classpath:application.properties")
public class AppConfig {
}
