package com.ijse.gdse73.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class boy {

    @Autowired
    @Qualifier("girlOne")
    Agreement agreement;
    public boy() {
        System.out.println("boy");
    }

    public void chatWithGirl(){
        girlOne girl = new girlOne();
        girl.chat();
    }

    public void chatWithgirl() {
    }
}
