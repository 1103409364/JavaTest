package com.xxx.ba01;

import org.springframework.stereotype.Component;

/**
 * 
 * 注解Component:创建对象的，等同于<bean>的功能 属性:value就是对象的名称，也就是bean的id 值，value的值是唯一的,创建的对象在整个spring容器中就一个 位置:在类的上面 实现效果等同于 <bean
 * id= "myStudent” class="com.xxx.ba01.Student" />
 */
@Component(value = "myStudent")
public class Student {
  private String name;

  private Integer age;

  public Student() {
    System.out.println("无参构造Student");
  }

  public void setName(final String name) {
    this.name = name;
  }

  public void setAge(final Integer age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Student{" + "name='" + this.name + '\'' + ", age=" + this.age + '}';
  }
}
