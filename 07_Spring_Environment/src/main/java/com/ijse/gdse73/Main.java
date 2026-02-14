package com.ijse.gdse73;

import com.ijse.gdse73.Config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;
import java.util.Properties;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.register(AppConfig.class);


        //System variables
       /* Map<String,String> systemVariables=System.getenv();
        for (String name : systemVariables.keySet()) {
            System.out.println(name+"="+systemVariables.get(name));
        }*/

        //java properties
      /*  Properties properties=System.getProperties();
        for (String name : properties.stringPropertyNames()) {
            System.out.println(name+"="+properties.getProperty(name));
        }*/
        context.registerShutdownHook();
    }
}