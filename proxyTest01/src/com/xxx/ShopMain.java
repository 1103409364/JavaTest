package com.xxx;

import com.xxx.Taobao.Taobao;
import com.xxx.pdd.Pdd;
import com.xxx.pdd.Pdd2;

public class ShopMain {
  public static void main(final String[] args) {
    final Taobao t = new Taobao();
    final float price = t.sell(1);
    System.out.println(price);

    final Pdd p = new Pdd();
    final float price2 = p.sell(1);
    System.out.println(price2);

    final Pdd2 p2 = new Pdd2();
    System.out.println(p2.sell(1));
  }
}
