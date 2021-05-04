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
    // 添加
    // s.setId("321");
    s.setName("a");
    s.setAge(100);
    //
    // ss.save(s);

    // 根据id查单条
    // final Student s1 = ss.getById("111"); // 查询可以不用代理
    // System.out.println(s1);
    // final List<Student> sList = ss.getAll();

    // 查询结果用map返回
    // final List<Map<String, Object>> mapList = ss.selectAllMap();
    // for (final Map<String, Object> m : mapList) {
    // final Set<String> keySet = m.keySet();
    // for (final String key : keySet) {
    // System.out.println("key:" + key + " " + "value:" + m.get(key));
    // }
    // }

    // 模糊查询
    // final List<Student> sList = ss.selectLike("a");

    // 多个条件模糊查询
    // final List<Student> sList = ss.selectQuery(s);

    // 传数组查询多个
    final String[] idArr = {"1", "2", "555"};
    final List<Student> sList = ss.selectByIdArr(idArr);
    for (final Student item : sList) {
      System.out.println(item);
    }
  }
}