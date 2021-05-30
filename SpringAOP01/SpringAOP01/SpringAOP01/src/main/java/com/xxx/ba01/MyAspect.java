package com.xxx.ba01;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

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
  // 这个JoinPoint参数的值是由框架赋予，JoinPoint 必须位于参数列表的第一位

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

  public void myAfter(final JoinPoint jp, final Object res) {
    System.out.println("myAfter后置通知返回值：" + res);
    if (res instanceof Student) {
      ((Student)res).setAge(999);
    }
  }

  /**
   * 环绕通知注解：@Around 属性 value 切入点表达式
   */
  // 环绕通知特点:
  // 1 功能最强的通知
  // 2 在目标方法前\后都可以增强功能
  // 3 控制目标方法是否被调用执行
  // 4 修改原来的目标方法的执行结果,影响最后的调用结果
  //
  // 环绕通知等同于动态代理的 InvocationHandler接口
  // 参数 ProceedingJoinPoint 等同于 Method

  // 环绕通知经常用来做事务: 在目标方法之前开启事务,执行目标方法,在目标方法执行后提交事务

  // 环绕通知方法定义格式：
  // 1 public
  // 2 必须有一个返回值，推荐使用Object
  // 方法名称自定义
  // 方法有参数，固定的参数 ProceedingJoinPoint
  @Around(value = "execution(* *..SomeServiceImpl.doFirst(..))")
  public Object myAround(final ProceedingJoinPoint pjp) throws Throwable {
    Object res = null;
    String name = "";
    // 获取参数
    final Object[] args = pjp.getArgs();
    if (args != null && args.length > 1) {
      name = (String)args[0];
    }

    System.out.println("环绕通知:目标方法执行前时间" + new Date());
    // 1 目标方法调用 控制目标方法是否执行
    if ("张三".equals(name)) {
      res = pjp.proceed(); /// /method. invoke(); object result doFirst( );

    }
    System.out.println("环绕通知:目标方法执行后时间" + new Date() + "提交事务");
    // 2 在目标方法前或者后加入功能
    // 修改目标方法执行的结果,影响方法最后的调用结果
    if (res == null) {
      res = "目标方法没有执行";
    }
    return res;
  }

  /**
   * 异常通知注解@AfterThrowing 不常用
   * 
   * 属性 1 value ="切入点表达式" 2 throwing 自定义变量,表示目标方法抛出的异常对象,变量名必须和异常通知方法的形参名一样
   * 
   */

  // 特点:
  // 1 在目标方法抛出异常时执行
  // 2 可以做异常监控程序,监控目标方法是否有异常,如有异常发送邮件或者短信通知
  //
  // 异常通知方法定义
  // 1 public
  // 2 么有返回值
  // 3 方法名自定义
  // 4可选参数JoinPoint\Exception

  // 执行原理
  // try{
  // SomeServiceImpl.doSecond(..)
  // }catch(Exception e){
  // myAfterThrowing(e);
  // }

  @AfterThrowing(value = "execution(* *..SomeServiceImpl.do*(..))", throwing = "e")
  public void myAfterThrowing(final Exception e) {
    System.out.println("异常通知:方法执行有异常,异常消息:" + e.getLocalizedMessage());
    // 发邮件通知
  }

  /**
   * 最终通知注解 @After
   */

  // 最终通知方法定义
  // 1 public
  // 2 么有返回值
  // 3 方法名自定义
  // 4可选参数JoinPoint

  // 最终通知总是被执行,作用: 做一些清除工作

  // 执行原理
  // try{
  // SomeServiceImpl.doThird(..)
  // }catch(Exception e){
  // }finally{
  // myAfter()
  // }

  @After(value = "execution(* *..SomeServiceImpl.do*(..))")
  public void myAfter() {
    System.out.println("最终通知执行");
  }
}
