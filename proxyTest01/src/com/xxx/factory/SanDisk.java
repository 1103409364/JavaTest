package com.xxx.factory;

import com.xxx.service.UsbSell;

// 目标类：U盘厂商，不接受用户单独购买
public class SanDisk implements UsbSell {
  @Override
  public float sell(final int amount) {
    // 一个卖100
    return 100.0f;
  }
}
