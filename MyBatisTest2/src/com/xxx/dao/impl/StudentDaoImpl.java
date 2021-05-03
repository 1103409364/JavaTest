package com.xxx.dao.impl;

import org.apache.ibatis.session.SqlSession;

import com.xxx.dao.StudentDao;
import com.xxx.domain.Student;
import com.xxx.util.SqlSessionUtil;

public class StudentDaoImpl implements StudentDao {
  @Override
  public Student getById(final String id) {
    final SqlSession session = SqlSessionUtil.getSession();
    return session.selectOne("StudentMapper.getById", id);
  }

  @Override
  public void save(final Student s) {
    final SqlSession session = SqlSessionUtil.getSession();
    session.insert("StudentMapper.save", s);
    // 不能在dao层提交事务，每次调用都会提交，业务还没有完成。在service 业务层提交，
    // session.commit();
  }
}
