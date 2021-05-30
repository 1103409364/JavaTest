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

  @Override
  public String doFirst(final String name, final Integer age) {
    System.out.println("业务方法doFirst");
    return "doFirst" + name + age;
  }

  @Override
  public void doSecond() {
    // final int a = 1 / 0; // 抛出异常
    System.out.println("业务方法doSecond");
  }

  @Override
  public void doThird() {
    // final int a = 1 / 0; // 抛出异常
    System.out.println("业务方法doThird执行");
  }
}
