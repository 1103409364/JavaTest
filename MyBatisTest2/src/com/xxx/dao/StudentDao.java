package com.xxx.dao;

import com.xxx.domain.Student;

public interface StudentDao {
  public Student getById(String id);

  public void save(Student s);
}
