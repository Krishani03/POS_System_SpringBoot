package com.ijse.gdse73.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TestOne  implements DIInterface {

    DI di ;
   // @Autowired
    public TestOne(DI di){
        this.di=di;

    }
    public void chatWithTestTwo() {
        di.chat();

    }
// interface throw injection
    @Override
    @Autowired

    public void inject(DI di) {

    }
}
