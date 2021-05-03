package com.xxx.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.apache.ibatis.session.SqlSession;

/*
 * 动态代理类 spring 底层实现原理
 */
public class TransactionInvocationHandler implements InvocationHandler {
  private final Object target; // 目标对象

  public TransactionInvocationHandler(final Object target) {
    this.target = target;
  }

  // 代理类的业务方法
  @Override
  public Object invoke(final Object proxy, final Method method, final Object[] args) {
    SqlSession session = null;
    Object obj = null;
    try {
      session = SqlSessionUtil.getSession();
      // 处理业务逻辑
      obj = method.invoke(this.target, args);
      // 处理业务完成提交事务
      session.commit();
    } catch (final Exception e) {
      // 异常回滚
      if (session != null) {
        session.rollback();
      }
      e.printStackTrace();
    } finally {
      SqlSessionUtil.myClose(session);
    }

    return obj;
  }

  // 取得代理类对象 反射
  public Object getProxy() {
    return Proxy.newProxyInstance(this.target.getClass().getClassLoader(), this.target.getClass().getInterfaces(),
      this);
  }
}
