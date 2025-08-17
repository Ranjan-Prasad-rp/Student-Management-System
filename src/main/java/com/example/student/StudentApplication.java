package com.example.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class, args);
     //  ApplicationContext applicationContext= SpringApplication.run(StudentApplication.class, args);
//       System.out.println("Application started successfully!");
//         String[] beanNames = applicationContext.getBeanDefinitionNames();
//        System.out.println("List of Beans:");
//        for (String beanName : beanNames) {
//            System.out.println(beanName);
//        }
    }

}
