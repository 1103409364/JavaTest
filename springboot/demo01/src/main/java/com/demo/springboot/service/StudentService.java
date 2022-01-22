package com.demo.springboot.service;

import com.demo.springboot.model.Student;

public interface StudentService {

  /**
   * 根据学生id查详情
   *
   * @param id
   * @return void
   */
  Student queryStudentById(Integer id);

  /**
   * 根据学生id修改学生的信息
   *
   * @param student
   * @return int
   */
  int updateStudentById(Student student);

  /**
   * 将值存入Redis
   *
   * @param key
   * @param value
   */
  void put(String key, String value);

  /**
   * 从redis中获取指定key的值
   *
   * @param key
   * @return
   */
  String get(String key);
}
