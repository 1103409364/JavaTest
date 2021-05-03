package com.xxx.service.impl;

import com.xxx.dao.StudentDao;
import com.xxx.dao.impl.StudentDaoImpl;
import com.xxx.domain.Student;
import com.xxx.service.StudentService;

public class StudentServiceImpl implements StudentService {
  private final StudentDao studentDao = new StudentDaoImpl(); // 多态

  @Override
  public Student getById(final String id) {
    final Student s = this.studentDao.getById(id);
    return s;
  }

  @Override
  public void save(final Student s) {
    this.studentDao.save(s);
  }
}
