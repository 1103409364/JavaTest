package com.demo.springboot.service.impl;

import com.demo.springboot.mapper.StudentMapper;
import com.demo.springboot.model.Student;
import com.demo.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//业务接口实现类放入spring容器，在控制层才能调用到（@Autowired注入）
@Service
public class StudentServiceImpl implements StudentService {
  // dao接口（mapper目录下的）在spring容器里也得有，才能把dao接口注入到业务层接口实现类里去
  //之前通过bean配置扫描器，把dao接口加到容器，springboot通过注解实现@Mapper
  @Autowired
  private StudentMapper studentService;

  @Override
  public Student queryStudentById(Integer id) {
    return studentService.selectByPrimaryKey(id);
  }
}
