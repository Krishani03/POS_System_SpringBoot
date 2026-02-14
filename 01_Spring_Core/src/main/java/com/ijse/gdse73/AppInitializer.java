package com.ijse.gdse73;

import com.ijse.gdse73.bean.MyConnection;
import com.ijse.gdse73.bean.SpringBean;
import com.ijse.gdse73.bean.TestBean;
import com.ijse.gdse73.config.AppConfig;
import com.ijse.gdse73.newBeans.NewTestBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(); // spring container/context
        context.register(AppConfig.class); // add AppConfig class into Spring Container
        context.refresh(); // manage Spring life cycle -> "Ready to use the Context"

        SpringBean springBean1 = new SpringBean(); // POJO (not Spring Bean)
        System.out.println("POJO : " + springBean1);

        SpringBean springBean2 = new SpringBean();
        System.out.println("POJO : " + springBean2); // prints 2 different IDs. Spring Beans r Singleton. Means these r not Spring Beans.

        // create Spring Beans
        SpringBean springBean3 = context.getBean(SpringBean.class);
        System.out.println("Bean : " + springBean3);

        SpringBean springBean4 = context.getBean(SpringBean.class);
        System.out.println("Bean : " + springBean4); // same ID. Does not print the sout. Means these r Spring Beans.

        // bean ID
        SpringBean springBean5 = (SpringBean) context.getBean("springBean"); // class name with simple 1st letter
        System.out.println("Bean : " + springBean5);

        TestBean testBean = (TestBean) context.getBean("exampleBean"); // ID changed using @Component annotation parameter
        System.out.println("Bean : " + testBean);

        TestBean testBean2 = context.getBean("exampleBean", TestBean.class); // using both Bean ID and Class name.
        System.out.println("Bean : " + testBean2);

        testBean2.printMessage(); // calling methods inside the bean class.

        // bean from a different pkg
        NewTestBean newTestBean = (NewTestBean) context.getBean("newTestBean");
        System.out.println("Bean : " + newTestBean);

        // @Bean class
        MyConnection myConnection = (MyConnection) context.getBean("newBean"); // bean ID changed.
        System.out.println("MyConnection : " + myConnection);

        context.registerShutdownHook(); // close the Context when JVM stops
    }
}
