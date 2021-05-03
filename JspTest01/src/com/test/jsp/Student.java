package com.test.jsp;

public class Student {
  private String name = "";
  private int age = 11;

  public Student() {}

  public Student(final String name, final int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return this.name;
  }

  public int getAge() {
    return this.age;
  }
}
