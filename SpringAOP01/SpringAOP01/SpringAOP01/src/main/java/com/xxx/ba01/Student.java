package com.xxx.ba01;

public class Student {
  private String name;
  private int age;

  public void setName(final String name) {
    this.name = name;
  }

  public Student() {}

  public Student(final String name, final int age) {
    this.name = name;
    this.age = age;
  }

  public void setAge(final int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Student{" + "name='" + this.name + '\'' + ", age=" + this.age + '}';
  }
}
