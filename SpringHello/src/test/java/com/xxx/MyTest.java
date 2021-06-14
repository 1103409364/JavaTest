package com.xxx;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xxx.service.SomeService;
import com.xxx.service.impl.SomeServiceImpl;

public class MyTest {
  @Test
  public void test01() {
    final SomeService service = new SomeServiceImpl();
    service.doSome();
  }

  @Test
  public void test02() {
    // 使用spring容器创建的对象
    // 1指定spring配置文件的名称
    final String config = "beans.xml";
    // 2创建表示spring容器的对象，ApplicationContext
    // ApplicationContext就是Spring容器，通过容器获取对象
    // ClassPathXmlApplicationContext:表示从类路径中加载spring的配置文件
    final ApplicationContext ac = new ClassPathXmlApplicationContext(config); // 这一步创建对象
    // 3通过id获取对象
    final SomeService s = (SomeService)ac.getBean("someService");
    final SomeService s2 = (SomeService)ac.getBean("someService2");
    s.doSome();
    // 获取容器中对象的信息
  }

  @Test
  public void test03() {
    final String config = "beans.xml";
    final ApplicationContext ac = new ClassPathXmlApplicationContext(config);
    // 使用spring提供的方法，获取容器中定义的对象数量
    // System.out.println(ac.getBeanDefinitionCount());
    // 获取对象名称
    final String[] names = ac.getBeanDefinitionNames();
    for (final String s : names) {
      System.out.println(s);
    }
  }

  /*
  *  创建内置Date对象，默认调用无参构造
  * */
  @Test
  public void test04() {
    final String config = "beans.xml";
    final ApplicationContext ac = new ClassPathXmlApplicationContext(config);
    final Date d = (Date)ac.getBean("myDate");
    System.out.println("Date" + d);
  }
}
