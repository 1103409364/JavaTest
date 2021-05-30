package com.xxx.ba01.Impl;

import com.xxx.ba01.SomeService;
import com.xxx.ba01.Student;

// 目标类
public class SomeServiceImpl implements SomeService {
  @Override
  public void doSome(final String name, final Integer age) {
    System.out.println("目标方法doSome执行，参数 name：" + name + " age:" + age);
  }

  @Override
  public String doOther(final String name, final Integer age) {
    System.out.println("目标方法doOther执行");
    return name + age;
  }

  @Override
  public Student doOther2(final Student s) {
    return s;
  }
}
