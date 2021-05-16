package com.xxx.factory;

import com.xxx.service.UsbSell;

// 目标类
public class Kinston implements UsbSell {
  @Override
  public float sell(final int amount) {
    System.out.println("目标类中执行了sell目标方法");
    return 50.0f;
  }
}
