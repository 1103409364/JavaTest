package com.xxx.pdd;

import com.xxx.factory.Kinston;
import com.xxx.service.UsbSell;

public class Pdd2 implements UsbSell {
  private Kinston factory = new Kinston();

  @Override
  public float sell(final int amount) {
    final float price = this.factory.sell(1);
    return price + 2;
  }
}
