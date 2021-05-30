package com.xxx.ba01.Impl;

import com.xxx.ba01.SomeService;

// 目标类
public class SomeServiceImpl implements SomeService {
  @Override
  public void doSome(final String name, final Integer age) {
    System.out.println("目标方法doSome执行，参数 name：" + name + " age:" + age);
  }
}
