package com.ijse.gdse73.config;

import com.ijse.gdse73.bean.MyConnection;
import com.ijse.gdse73.newBeans.NewTestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // add all the components into Spring Container
// multiple pkg paths
@ComponentScan(basePackages = {"com.ijse.gdse73.bean","com.ijse.gdse73.newBeans"}) // path to bean pkg (components path)

//@ComponentScan(basePackageClasses =  {NewTestBean.class}) // using class name and not class path
public class AppConfig {
    public AppConfig() {
        System.out.println("AppConfig is created");
    }

    // use @Bean for classes that r not created by Dev.
    // changing the Bean ID using parameters.
    @Bean("newBean") // @Bean should use in the Configuration class and not in the Bean class.
    MyConnection myConnection() { //bean ID is the method name.
        return new MyConnection();
    }
}
