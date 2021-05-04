package com.xxx.service;

import java.util.List;
import java.util.Map;

import com.xxx.domain.Student;

public interface StudentService {
  public Student getById(String id);

  public void save(Student s);

  public List<Student> getAll();

  public List<Student> selectLike(String query);

  public List<Student> selectQuery(Student s);

  public List<Map<String, Object>> selectAllMap();

  public List<Student> selectByIdArr(String[] idArr);
}
