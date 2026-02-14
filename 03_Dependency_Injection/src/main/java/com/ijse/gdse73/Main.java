package com.ijse.gdse73;

import com.ijse.gdse73.bean.boy;
import com.ijse.gdse73.config.AppConfig;
import com.ijse.gdse73.di.TestOne;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        // Only ONE refresh happens here
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        TestOne TestOne = context.getBean(TestOne.class);
        TestOne.chatWithTestTwo();

        context.registerShutdownHook();
    }
}
