package com.xxx;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.xxx.factory.Kinston;
import com.xxx.handler.MySellHandler;
import com.xxx.service.UsbSell;

public class ShopMain {
  public static void main(final String[] args) {
    // 创建代理对象，使用Proxy
    // 1创建目标对象
    final UsbSell factory = new Kinston();
    // 2创建InvocationHandler对象
    final InvocationHandler handler = new MySellHandler(factory);
    // 3创建代理对象
    final UsbSell proxy =
      (UsbSell)Proxy.newProxyInstance(factory.getClass().getClassLoader(), factory.getClass().getInterfaces(), handler);
    // 4通过代理执行方法
    System.out.println(proxy.sell(1));
  }
}
