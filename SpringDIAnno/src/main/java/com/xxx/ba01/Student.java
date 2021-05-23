package com.xxx.ba01;

import org.springframework.stereotype.Component;

// 注解Component:创建对象的，等同于<bean>的功能
// 属性:value就是对象的名称，也就是bean的id 值，
// value的值是唯一的,创建的对象在整个spring容器中就一个 位置:在类的上面 实现效果等同于
// <bean id= "myStudent” class="com.xxx.ba01.Student" />

// spring中和@Component功能类似,创建对象的注解还有
// 1. @Repository (用在持久层类的上面) :放在dao的实现类上面
// 表示创建dao对象,dao对象是能访问数据库的。
// 2. @Service(用在业务层类的上面) :放在service的实现类上面，
// 创建service对象，service对象是做业务处理，可以有事务 等功能的。
// 3. @Controller(用在控制器的上面) :放在控制器(处理器)类的上面，创建控制器对象的，
// 控制器对象,能够接受用户提交的参数，显示请求的处理结果。
// 以上三个注解的使用语法@Component-样的。都能创建对象，但是这三个注解还有额外的功能。
// 其中 @Repository @service @Controller是给项目的对象分层的 此外的其他地方可以用@Component

// 使用value属性指定对象名称
// @Component(value = "myStudent")
// 省略value 最常用
// @Component("myStudent")
// 不指定对象名称，由spring提供默认名称：类名的首字符小写
// @Component

@Component("myStudent")
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
