package com.ijse.gdse73.config;

import com.ijse.gdse73.bean.SpringBeanOne;
import com.ijse.gdse73.bean.SpringBeanTwo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
@Configuration
@ComponentScan(basePackages = {"com.ijse.gdse73.bean"})
public class AppConfig {
 /*   //fullmode
    @Bean
    public SpringBeanOne springBeanOne(){
        //inter bean dependency
        SpringBeanTwo springBeanTwo1 =  springBeanTwo();
        SpringBeanTwo springBeanTwo2= springBeanTwo();
        System.out.println(springBeanTwo1);
        System.out.println(springBeanTwo2);
        return new SpringBeanOne();
    }
    @Bean
    public SpringBeanTwo springBeanTwo(){
        return new SpringBeanTwo();
    }*/
}
