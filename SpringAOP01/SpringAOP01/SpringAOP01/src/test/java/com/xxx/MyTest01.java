package com.xxx;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xxx.ba01.SomeService;

public class MyTest01 {
  @Test
  public void test01() {
    final String config = "applicationContext.xml";
    final ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
    // 从容器中获取目标对象 目标类有接口是动态代理
    final SomeService proxy = (SomeService)ctx.getBean("someService");
    // 通过代理对象执行方法，实现目标方法执行时，增强了功能
    proxy.doSome("张三", 20);
  }
}
