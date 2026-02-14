package com.ijse.gdse73.config;

import com.ijse.gdse73.bean.A;
import com.ijse.gdse73.bean.C;
import com.ijse.gdse73.bean.D;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigTwo {
    public AppConfigTwo(){
        System.out.println("AppConfigTwo");
    }
    @Bean
   public C c() {
        return new C();
    }
   @Bean
    public D d() {
        return new D();
   }
}
