package com.xxx.springboot.demo04.service.impl;

import com.xxx.springboot.demo04.service.StudentService;
import org.springframework.stereotype.Service;

@Service//加个注解，加载容器中
public class StudentServiceImpl implements StudentService {
  @Override
  public String sayHello() {
    return "Say Hello";
  }
}
