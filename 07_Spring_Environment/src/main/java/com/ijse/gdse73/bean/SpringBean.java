package com.ijse.gdse73.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class SpringBean  implements InitializingBean {
    @Value("${db.name}")
    private String db;
    @Value("${db.User}")
    private String dbUser;
    @Value("${db.Password}")
    private String dbPassword;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(db);
        System.out.println(dbUser);
        System.out.println(dbPassword);
    }
}
