package com.xxx.testMaven;

public class HelloMaven {
  public int add(final int n1, final int n2) {
    return n1 + n2;
  }

  public static void main(final String[] args) {
    final HelloMaven h = new HelloMaven();
    final int res = h.add(10, 10);
    System.out.println("10 + 10 = " + res);
  }
}
