package com.ijse.gdse73.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringBean  {

@Autowired(required = false)
    public SpringBean(@Value("Kavee") String name,@Value("22") int age,@Value("12")int height) {
        System.out.println(name);
        System.out.println(age);
        System.out.println(height);


    }
    @Autowired(required = false)
    public SpringBean(@Value("kvsh") String nameList[],@Value("12") int number){
        System.out.println(nameList.length);
        System.out.println(number);

    }
}
