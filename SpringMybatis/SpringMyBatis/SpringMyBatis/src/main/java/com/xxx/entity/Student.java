package com.xxx.entity;

public class Student {
  private Integer id;
  private String name;
  private String email;
  private Integer age;

  public Student() {}

  public Student(final Integer id, final String name, final String email, final Integer age) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.age = age;
  }

  public Integer getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public String getEmail() {
    return this.email;
  }

  public Integer getAge() {
    return this.age;
  }

  public void setId(final Integer id) {
    this.id = id;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  public void setAge(final Integer age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Student{" + "id=" + this.id + ", name='" + this.name + '\'' + ", email='" + this.email + '\'' + ", age="
      + this.age + '}';
  }
}
