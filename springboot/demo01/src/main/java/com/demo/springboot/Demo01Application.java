package com.demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//SpringBoot项目启动入口类
@SpringBootApplication // 开启SpringBoot配置
public class Demo01Application {

  public static void main(String[] args) {
    SpringApplication.run(Demo01Application.class, args);
  }
}
// SpringBoot项目必须放在Application类同级目录或者下级目录
