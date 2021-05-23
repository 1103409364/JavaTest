package com.xxx.ba01;

public class Student {
  private String name;
  private int age;
  private School school;

  public Student(final String name, final int age, final School school) {
    System.out.println("Student 有参数构造执行");
    this.name = name;
    this.age = age;
    this.school = school;
  }

  @Override
  public String toString() {
    return "Student{" + "name='" + this.name + '\'' + ", age=" + this.age + ", school=" + this.school + "}";
  }

  public void setName(final String name) {
    this.name = name;
  }

  public void setAge(final int age) {
    this.age = age;
  }

  public void setSchool(final School s) {
    this.school = s;
  }
}
