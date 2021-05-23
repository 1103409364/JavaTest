package com.xxx;

import java.io.File;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xxx.ba01.Student;

public class MyTest {
  @Test
  public void test01() {
    final String config = "ba01/applicationContext.xml";
    final ApplicationContext ac = new ClassPathXmlApplicationContext(config);
    // 从容器中取对象
    final Student myStudent = (Student)ac.getBean("myStudent");
    System.out.println(myStudent);
  }

  @Test
  public void test02() {
    final String config = "ba01/applicationContext.xml";
    final ApplicationContext ac = new ClassPathXmlApplicationContext(config);
    final File myFile = (File)ac.getBean("myFile");
    System.out.println(myFile.getName());
  }
}
