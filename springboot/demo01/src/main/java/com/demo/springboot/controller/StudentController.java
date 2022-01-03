package com.demo.springboot.controller;

import com.demo.springboot.model.Student;
import com.demo.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {
  // 注入业务层，调到业务层接口实现类
  @Autowired
  private StudentService studentService;

  @RequestMapping(value = "/student")
  public @ResponseBody
  Object student(Integer id) {
    Student student = studentService.queryStudentById(id);
    return student;
  }
}
