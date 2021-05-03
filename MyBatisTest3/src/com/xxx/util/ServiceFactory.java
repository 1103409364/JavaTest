package com.xxx.util;

public class ServiceFactory {
  // 传目标对象得到代理对象
  public static Object getService(final Object o) {
    return new TransactionInvocationHandler(o).getProxy();
  }

}
