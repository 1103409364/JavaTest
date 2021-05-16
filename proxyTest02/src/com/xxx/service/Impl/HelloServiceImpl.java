package com.xxx.service.Impl;

import com.xxx.service.HelloService;

public class HelloServiceImpl implements HelloService {
  @Override
  public void sayHello(final String name) {
    System.out.println("你好" + name);
  }
}
