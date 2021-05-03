package com.xxx.controller;

import java.util.List;

import com.xxx.domain.Student;
import com.xxx.service.StudentService;
import com.xxx.service.impl.StudentServiceImpl;
import com.xxx.util.ServiceFactory;

// 控制层具体的业务不干，让业务层处理具体的业务
public class Test {
  public static void main(final String[] args) {
    // final StudentService ss = new StudentServiceImpl(); // 没走事务 x
    final StudentService ss = (StudentService)ServiceFactory.getService(new StudentServiceImpl());
    final Student s = new Student();
    // 测试添加
    // s.setId("321");
    // s.setName("myBaits代理");
    // s.setAge(0);
    //
    // ss.save(s);
    // 测试根据id查单条
    // final Student s1 = ss.getById("111"); // 查询可以不用代理
    // System.out.println(s1);
    final List<Student> sList = ss.getAll();
    for (final Student item : sList) {
      System.out.println(item);
    }
  }
}