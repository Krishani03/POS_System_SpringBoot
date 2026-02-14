package com.ijse.gdse73.di;

import org.springframework.stereotype.Component;

@Component
public class TestTwo implements DI {
    @Override
    public void chat() {
        System.out.println("chat TestTwo");
    }
}
