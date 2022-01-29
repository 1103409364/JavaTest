package com.xxx.springboot.demo04;

import com.xxx.springboot.demo04.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Demo04Application {

  public static void main(String[] args) {
    //  Springboot 程序启动后，返回值是ConfigurableApplicationContext,它也是一个Spring 容器
    //  它其实相当于原来Spring容器中后动容器ClasspathXmLApplicationContext
    ConfigurableApplicationContext applicationContext = SpringApplication.run(Demo04Application.class, args);

    // 从spring容器中获取指定bean对象
    StudentService studentService = (StudentService) applicationContext.getBean("studentServiceImpl");

    // 调用业务方法
    String sayHello = studentService.sayHello();
    System.out.println(sayHello);
  }

}
