package com.xxx.service.Impl;

import com.xxx.service.SomeService;

public class SomeServiceImpl implements SomeService {
  public SomeServiceImpl() {
    System.out.println("创建SomeServiceImpl对象");
  }

  @Override
  public void doSome() {
    System.out.println("执行了SomeServiceImpl的doSome方法");
  }
}
