package com.xxx;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xxx.ba03.Student;

public class MyTest04 {
  @Test
  public void test01() {
    final String config = "applicationContext.xml";
    final ApplicationContext ac = new ClassPathXmlApplicationContext(config);
    final Student s = (Student)ac.getBean("myStudent");
    System.out.println(s);
  }
}
