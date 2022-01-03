package com.demo.springboot.service;

import com.demo.springboot.model.Student;

public interface StudentService {

  /**
   * 根据学生id查详情
   *
   * @param id
   * @return
   */
  Student queryStudentById(Integer id);
}
