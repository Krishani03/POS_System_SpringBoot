package com.ijse.gdse73.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringBean implements InitializingBean, BeanNameAware, ApplicationContextAware, DisposableBean, BeanFactoryAware {
    public SpringBean() {
        System.out.println("SpringBean is called");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactory is set");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanName is set");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("SpringBean is destroy");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContext is set");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.printf("Initializing bean %s\n", this.getClass().getName());
    }
}
