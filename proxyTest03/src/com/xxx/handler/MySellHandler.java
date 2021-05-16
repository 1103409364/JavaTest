package com.xxx.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// 必须实现InvocationHandler接口， 完成代理类要做的功能：调用目标方法，执行增强功能
public class MySellHandler implements InvocationHandler {
  private Object target = null;

  // 动态代理 :目标对象是活动的 不是固定的， 需要传入进来。 传入是谁， 就给谁创建代理。
  public MySellHandler(final Object target) {
    this.target = target;
  }

  @Override
  public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
    Object res = null;
    // 向厂家发送订单，告诉厂家、买了U盘，厂家发货
    // final float price = this.factory.sell(amount);
    res = method.invoke(this.target, args);
    // 实现加价
    if (res != null) {
      Float price = (Float)res;
      price = price * 1.2f;
      res = price;
    }

    System.out.println("商家返给消费者一个优惠券");
    return res;
  }
}
