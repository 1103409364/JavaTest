package com.xxx.ba04;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("myStudent")
public class Student {
  // @Value 简单类型的属性赋值
  // 属性：value是String类型的，表示简单类型的的属性值
  // 位置：1 在属性定义的上面，无需set方法 2 在set方法上使用
  @Value(value = "张飞") // key可以省略
  private String name;
  @Value(value = "500")
  private Integer age;

  @Override
  public String toString() {
    return "Student{" + "name='" + this.name + '\'' + ", age=" + this.age + ", school=" + this.school + '}';
  }

  // 默认使用byName注入，如果失败，尝试使用byType
  // 位置也是属性或者set方法之上
  // 指定使用byName，不想自动切换：@Resource(name="school")
  @Resource
  private School school;

  public Student() {
    System.out.println("无参构造Student");
  }

  public void setName(final String name) {
    this.name = name;
  }

  public void setAge(final Integer age) {
    this.age = age;
  }

}
