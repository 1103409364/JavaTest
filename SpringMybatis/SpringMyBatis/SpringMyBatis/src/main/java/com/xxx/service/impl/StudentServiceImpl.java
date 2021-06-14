package com.xxx.service.impl;

import java.util.List;

import com.xxx.dao.StudentDao;
import com.xxx.entity.Student;
import com.xxx.service.StudentService;

public class StudentServiceImpl implements StudentService {
  private StudentDao studentDao;

  public void setStudentDao(final StudentDao studentDao) {
    this.studentDao = studentDao;
  }

  @Override
  public int addStudent(final Student student) {
    return this.studentDao.insertStudent(student);
  }

  @Override
  public List<Student> queryStudents() {
    return this.studentDao.selectStudents();
  }
}
