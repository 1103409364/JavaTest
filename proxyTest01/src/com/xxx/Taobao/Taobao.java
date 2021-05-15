package com.xxx.Taobao;

import com.xxx.factory.SanDisk;
import com.xxx.service.UsbSell;

// 商家，代理厂商的销售
public class Taobao implements UsbSell {
  private SanDisk factory = new SanDisk();

  @Override
  public float sell(final int amount) {
    // 向厂家发送订单，告诉厂家、买了U盘，厂家发货
    final float price = this.factory.sell(amount);
    System.out.println("发给用户10元优惠券");
    return price * 1.2f; // 代理加价
  }
}
