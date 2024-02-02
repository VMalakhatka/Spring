package org.example;

import org.example.Config.DatabaseConfig;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DatabaseConfig databaseConfig= context.getBean("databaseConfig",DatabaseConfig.class);
        System.out.println(databaseConfig);

        context.close();
    }
}
