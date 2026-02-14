package com.ijse.gdse73;

import com.ijse.gdse73.config.AppConfig;
import com.ijse.gdse73.config.AppConfigOne;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
   AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
   context.register(AppConfig.class);
  // context.register(AppConfigOne.class);
   context.registerShutdownHook();
}}