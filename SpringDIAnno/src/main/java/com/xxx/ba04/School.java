package com.xxx.ba04;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("mySchool")
public class School {
  @Value("xx大学")
  private String name;

  @Override
  public String toString() {
    return "School{" + "name='" + this.name + '\'' + '}';
  }

  public void setName(final String name) {
    this.name = name;
  }
}
