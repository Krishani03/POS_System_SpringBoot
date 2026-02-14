package com.ijse.gdse73.config;

import com.ijse.gdse73.bean.A;
import com.ijse.gdse73.bean.B;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigOne {
    public AppConfigOne(){
        System.out.println("AppConfigOne");
    }
    @Bean
    public A a() {
        return new A();
    }
    @Bean
    public B b() {
        return new B();
    }
}
