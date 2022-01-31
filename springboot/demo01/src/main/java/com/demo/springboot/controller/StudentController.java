package com.demo.springboot.controller;

import com.demo.springboot.model.Student;
import com.demo.springboot.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class StudentController {
  // 注入业务层，调到业务层接口实现类
  @Autowired
  private StudentService studentService;

  @RequestMapping(value = "/student")
  public @ResponseBody
  Object student(Integer id) {
    log.info("通过id查询学生");
    return studentService.queryStudentById(id);
  }

  @RequestMapping(value = "/update")
  public @ResponseBody
  Object update(Integer id, String name) {
    Student student = new Student();
    student.setId(id);
    student.setName(name);
    int updateCount = studentService.updateStudentById(student);

    return "修改学生编号为" + id + " 的姓名修改结果：" + updateCount;
  }

  @RequestMapping(value = "/put")
  public @ResponseBody
  Object put(String key, String value) {
    studentService.put(key, value);
    return "值已成功放入redis";
  }

  @RequestMapping(value = "/get")
  public @ResponseBody
  String get() {
    String count = studentService.get("count");
    return "数据 count 为：" + count;
  }
}
