package com.xxx;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xxx.ba02.Student;

public class MyTest2 {
  @Test
  public void test01() {
    final String config = "ba02/applicationContext.xml";
    final ApplicationContext ac = new ClassPathXmlApplicationContext(config);
    // 从容器中取对象
    final Student myStudent = (Student)ac.getBean("myStudent");
    System.out.println(myStudent);
  }
}
