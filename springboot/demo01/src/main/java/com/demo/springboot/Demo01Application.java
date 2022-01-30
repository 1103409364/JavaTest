package com.demo.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//SpringBoot项目启动入口类
@SpringBootApplication // 开启SpringBoot配置
@ServletComponentScan(basePackages = "com.demo.springboot.filter")
@MapperScan(basePackages = "com.demo.springboot.mapper")
public class Demo01Application {

  public static void main(String[] args) {
    SpringApplication.run(Demo01Application.class, args);
    // 获取启动入口 Demo01Application 类，设置logo关闭，启动run
//    SpringApplication springApplication = new SpringApplication(Demo01Application.class);
//    springApplication.setBannerMode(Banner.Mode.OFF);
//    springApplication.run(args);
  }
}
// SpringBoot项目必须放在Application类同级目录或者下级目录
