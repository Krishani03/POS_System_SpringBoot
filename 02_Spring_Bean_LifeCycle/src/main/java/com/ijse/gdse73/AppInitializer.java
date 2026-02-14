package com.ijse.gdse73;

import com.ijse.gdse73.bean.SpringBean;
import com.ijse.gdse73.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        SpringBean springBean = (SpringBean) context.getBean("springBean");

        context.registerShutdownHook();
    }
}