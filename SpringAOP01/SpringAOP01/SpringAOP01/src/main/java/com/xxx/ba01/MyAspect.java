package com.xxx.ba01;

import java.util.Date;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

// aspectj框架中的注解，声明当前类是切面类，、
// 切面类：给业务方法增加功能，在这个类中有切面的功能代码
// 位置：在类定义的上方
@Aspect
public class MyAspect {
  // 定义方法实现切面功能，要求：
  // 1 公共public访问权限
  // 2 没有返回值
  // 3 名称自定义
  // 4 参数可有可无，不是自定义的，有几个可选参数

  /**
   * 注解：@before：前置通注解 属性：value，值是【切入点表达式】，表示切面功能执行的位置 位置：在方法的上面
   * 
   * 特点： 1.在目标方法执行前执行 2.不会改变目标方法的执行结果
   */

  // 切入点表达式的多种写法：
  // @Before(value = "execution(public void com.xxx.ba01.Impl.SomeServiceImpl.doSome(String, Integer))") //完整写法
  // @Before(value = "execution(void com.xxx.ba01.Impl.SomeServiceImpl.doSome(String, Integer))") // 省略 访问权限
  // @Before(value = "execution(void *..doSome(String, Integer))") // 省略 访问权限 包名
  // @Before(value = "execution(* *..doSome(..))") // 省略 访问权限 简写 返回值 包名 参数
  @Before(value = "execution(* *..SomeServiceImpl.do*(..))") // 省略 访问权限 简写 返回值 包名 参数 方法名
  public void myBefore() {
    System.out.println("前置通知，方法执行前输出时间：" + new Date());
  }

}
