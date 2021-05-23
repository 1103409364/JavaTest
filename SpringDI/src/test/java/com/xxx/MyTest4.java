package com.xxx;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xxx.ba04.Student;

public class MyTest4 {
  @Test
  public void test01() {
    final String config = "ba04/index.xml";
    final ApplicationContext ac = new ClassPathXmlApplicationContext(config);
    // 从容器中取对象
    final Student myStudent = (Student)ac.getBean("myStudent");
    System.out.println(myStudent);
  }
}
