package com.xxx.ba01;

public class School {
  private String name;

  @Override
  public String toString() {
    return "School{" + "name='" + this.name + '\'' + '}';
  }

  public void setName(final String name) {
    this.name = name;
  }
}
