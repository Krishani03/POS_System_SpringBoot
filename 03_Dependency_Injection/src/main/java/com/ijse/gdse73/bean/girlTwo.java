package com.ijse.gdse73.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class girlTwo implements Agreement, BeanNameAware, BeanFactoryAware , InitializingBean, DisposableBean {
    public girlTwo(){
        System.out.println("girl Two chat");
    }
    @Override
    public void chat(){
        System.out.println("girl chat");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("girl setBeanFactory");

    }

    @Override
    public void setBeanName(String name) {
        System.out.println("girl setBeanName");

    }

    @Override
    public void destroy() throws Exception {
        System.out.println("girl destroy");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("girl afterPropertiesSet");

    }
}
