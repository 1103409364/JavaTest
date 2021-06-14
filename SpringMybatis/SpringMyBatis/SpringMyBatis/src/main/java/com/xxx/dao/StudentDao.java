package com.xxx.dao;

import java.util.List;

import com.xxx.entity.Student;

public interface StudentDao {
  int insertStudent(Student student);

  List<Student> selectStudents();
}
