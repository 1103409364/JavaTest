package com.xxx.service;

import java.util.List;

import com.xxx.entity.Student;

public interface StudentService {
  int addStudent(Student student);

  List<Student> queryStudents();
}
