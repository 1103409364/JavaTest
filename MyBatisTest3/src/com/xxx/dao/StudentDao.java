package com.xxx.dao;

import java.util.List;

import com.xxx.domain.Student;

public interface StudentDao {
  public Student getById(String id);

  public void save(Student s);

  public List<Student> getAll();
}
