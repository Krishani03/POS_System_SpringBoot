package com.ijse.gdse73.bean;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("exampleBean") // change the Bean ID from "testBean" to "exampleBean"

@Scope("prototype") // to remove singleton
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)

public class TestBean {
    public TestBean() {
        System.out.println("TestBean is created");
    }

    public void printMessage() {
        System.out.println("Hello World");
    }
}
