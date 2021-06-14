package com.xxx.controller;

import com.xxx.entity.Student;
import com.xxx.service.StudentService;
import com.xxx.service.impl.StudentServiceImpl;
import com.xxx.util.ServiceFactory;

// 控制层具体的业务不干，让业务层处理具体的业务
public class Test {
  public static void main(final String[] args) {
    // final StudentService ss = new StudentServiceImpl(); // 没走事务 x
    final StudentService ss = (StudentService)ServiceFactory.getService(new StudentServiceImpl());
    // final Student s = new Student();
    // 测试添加
    // s.setId("111");
    // s.setName("小王");
    // s.setAge(111);
    //
    // ss.save(s);
    // 测试根据id查单条
    final Student s1 = ss.getById("111"); // 查询可以不用代理
    System.out.println(s1);
  }
}