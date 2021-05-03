package com.xxx.service.impl;

import java.util.List;

import com.xxx.dao.StudentDao;
import com.xxx.domain.Student;
import com.xxx.service.StudentService;
import com.xxx.util.SqlSessionUtil;

public class StudentServiceImpl implements StudentService {
  // private final StudentDao studentDao = new StudentDaoImpl(); // 多态
  // dao层实现类不用写了，通过myBatis的代理自动实现
  private final StudentDao studentDao = SqlSessionUtil.getSession().getMapper(StudentDao.class);

  @Override
  public Student getById(final String id) {
    return this.studentDao.getById(id);
  }

  @Override
  public void save(final Student s) {
    this.studentDao.save(s);
  }

  @Override
  public List<Student> getAll() {
    return this.studentDao.getAll();
  }
}
