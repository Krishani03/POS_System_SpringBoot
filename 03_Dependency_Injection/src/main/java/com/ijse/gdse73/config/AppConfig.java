package com.ijse.gdse73.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages ={ "com.ijse.gdse73.di"})

public class AppConfig {
    public AppConfig() {
        System.out.println("AppConfig");
    }
}
