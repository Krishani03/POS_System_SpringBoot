package com.ijse.gdse73.config;

import com.ijse.gdse73.bean.D;
import com.ijse.gdse73.bean.SpringBean;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;


@Configuration
@ComponentScan(
        basePackages = {"com.ijse.gdse73.bean"}
)
@Import({AppConfigOne.class, AppConfigTwo.class})
@ImportResource("classpath:hibernate.cfg.xml")
public class AppConfig {
    public AppConfig(){
        System.out.println("AppConfig");
    }


}
