package com.xxx.ba03;

import org.springframework.beans.factory.annotation.Autowired;
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

  // 引用类型赋值
  // @Autowired:默认使用byType自动注入
  // 位置：1在属性定义的上面，无需set方法，推荐使用 2 在set方法上使用
  // 支持byName 需要配合@Qualifier(value="bean的id") 表示使用指定的bean完成注入
  // Autowired可配置的required属性是Boolean类型
  // @Autowired(required=true) 默认为true，required = false 时，引用类型注入失败不会报错，赋值为null
  // require一般用true

  // @Autowired
  // @Qualifier(value="mySchool") 没有先后顺序规定

  @Autowired
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
