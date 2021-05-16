package com.xxx;

import com.xxx.Shop.Taobao;

public class ShopMain {
  public static void main(final String[] args) {
    final Taobao t = new Taobao();
    final float price = t.sell(1);
    System.out.println(price);

    final Taobao.Pdd p = new Taobao.Pdd();
    final float price2 = p.sell(1);
    System.out.println(price2);

    final Taobao.Pdd2 p2 = new Taobao.Pdd2();
    System.out.println(p2.sell(1));
  }
}
