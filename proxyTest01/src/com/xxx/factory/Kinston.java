package com.xxx.factory;

import com.xxx.service.UsbSell;

public class Kinston implements UsbSell {
  @Override
  public float sell(final int amount) {
    return 50.0f;
  }
}
