package com.xxx.service;

import com.xxx.entity.Student;

public interface StudentService {
  public Student getById(String id);

  public void save(Student s);
}
