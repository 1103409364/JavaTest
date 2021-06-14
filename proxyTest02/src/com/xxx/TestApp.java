package com.xxx;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.xxx.service.HelloService;
import com.xxx.service.impl.HelloServiceImpl;

public class TestApp {
  public static void main(final String[] args)
    throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    final HelloService service = new HelloServiceImpl();
    service.sayHello("张三");
    // 使用反射机制执行 sayHello
    final HelloService target = new HelloServiceImpl();
    final Method method = HelloService.class.getMethod("sayHello", String.class);
    // invoke 执行
    final Object o = method.invoke(target, "张二");
    System.out.println(o);
  }
}
