package com.xxx.dao;

import com.xxx.entity.Student;

public interface StudentDao {
  public Student getById(String id);

  public void save(Student s);
}
