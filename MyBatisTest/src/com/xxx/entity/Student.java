package com.xxx.entity;

public class Student {
  private String id;
  private String name;
  private int age; // 使用Integer 值可以为null

  public String getId() {
    return this.id;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public int getAge() {
    return this.age;
  }

  public void setAge(final int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Student{" + "id='" + this.id + '\'' + ", name='" + this.name + '\'' + ", age=" + this.age + '}';
  }
}
