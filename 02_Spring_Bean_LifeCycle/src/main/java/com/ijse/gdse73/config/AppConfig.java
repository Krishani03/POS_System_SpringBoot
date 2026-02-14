package com.ijse.gdse73.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ijse.gdse73.bean")
public class AppConfig {
    public AppConfig() {
    }
}
