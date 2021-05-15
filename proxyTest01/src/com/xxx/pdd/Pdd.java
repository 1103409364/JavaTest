package com.xxx.pdd;

import com.xxx.factory.SanDisk;
import com.xxx.service.UsbSell;

public class Pdd implements UsbSell {
  private SanDisk factory = new SanDisk();

  @Override
  public float sell(final int amount) {
    // 向厂家发送订单，告诉厂家、买了U盘，厂家发货
    final float price = this.factory.sell(amount);
    return price + 1; // 代理
  }
}
