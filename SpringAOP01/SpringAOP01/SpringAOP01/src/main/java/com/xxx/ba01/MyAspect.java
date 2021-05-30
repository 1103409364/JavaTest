package com.xxx.ba01;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
   * 前置通知注解：@before：属性：value，值是【切入点表达式】，表示切面功能执行的位置 位置：在方法的上面
   * 
   * 特点： 1.在目标方法执行前执行 2.不会改变目标方法的执行结果
   */

  // 切入点表达式的多种写法：
  // @Before(value = "execution(public void com.xxx.ba01.Impl.SomeServiceImpl.doSome(String, Integer))") //完整写法
  // @Before(value = "execution(void com.xxx.ba01.Impl.SomeServiceImpl.doSome(String, Integer))") // 省略 访问权限
  // @Before(value = "execution(void *..doSome(String, Integer))") // 省略 访问权限 包名
  // @Before(value = "execution(* *..doSome(..))") // 省略 访问权限 简写 返回值 包名 参数

  // JoinPoint 业务方法、通知方法、接入点
  // 作用是:可以在通知方法中获取方法执行时的信息，例如方法名称 ，方法的实参。
  // 如果你的切面功能中需要用到方法的信息,就加入JoinPoint .
  // 这个JoinPoint参数的值是由框架赋予，必须是第个位置的参数

  @Before(value = "execution(* *..SomeServiceImpl.do*(..))") // 省略 访问权限 简写 返回值 包名 参数 方法名
  public void myBefore(final JoinPoint jp) {
    // System.out.println("方法的签名" + jp.getSignature());
    // System.out.println("方法的名称" + jp.getSignature().getName());
    // final Object[] args = jp.getArgs();
    // for (final Object arg : args) {
    // System.out.println("方法的实参" + arg);
    //
    // }
    System.out.println("前置通知，方法执行前输出时间：" + new Date());
  }

  /**
   * 后置通知注解：@AfterReturning使用方法和前置通知一样，
   */
  // 属性
  // 1 value="切入点表达式"
  // 2 returning="自定义的变量"，表示目标方法的返回值 自定义变量必须和通知方法myAfter的形参名一样

  // 特点：
  // 执行时机：目标方法执行之后
  // 能够获取目标方法的返回值，可以根据这个返回值做不同的处理
  // 可以修改返回值

  @AfterReturning(value = "execution(* *..SomeServiceImpl.do*(..))", returning = "res")
  public void myAfter(final Object res) {
    System.out.println("myAfter后置通知返回值：" + res);
    if (res instanceof Student) {
      ((Student)res).setAge(999);
    }
  }
}
