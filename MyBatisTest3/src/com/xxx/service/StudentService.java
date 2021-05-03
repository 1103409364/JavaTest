package com.xxx.service;

import java.util.List;

import com.xxx.domain.Student;

public interface StudentService {
  public Student getById(String id);

  public void save(Student s);

  public List<Student> getAll();
}
