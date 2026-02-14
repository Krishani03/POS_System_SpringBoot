package com.ijse.gdse73;

import com.ijse.gdse73.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);



        context.registerShutdownHook();
    }
}
