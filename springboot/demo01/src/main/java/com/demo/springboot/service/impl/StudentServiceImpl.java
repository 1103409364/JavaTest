package com.demo.springboot.service.impl;

import com.demo.springboot.mapper.StudentMapper;
import com.demo.springboot.model.Student;
import com.demo.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//业务接口实现类放入spring容器，在控制层才能调用到（@Autowired注入）
@Service
public class StudentServiceImpl implements StudentService {
  // dao接口（mapper目录下的）在spring容器里也得有，才能把dao接口注入到业务层接口实现类里去
  //之前通过bean配置扫描器，把dao接口加到容器，springboot通过注解实现@Mapper
  @Autowired
  private StudentMapper studentMapper;

  @Override
  public Student queryStudentById(Integer id) {
    return studentMapper.selectByPrimaryKey(id);
  }

  @Transactional
  @Override
  public int updateStudentById(Student student) {
    int i = studentMapper.updateByPrimaryKeySelective(student);
    //int a = 10 / 0; //报错java.lang.ArithmeticException: / by zero
    return i;
  }

  @Autowired
  private RedisTemplate<Object, Object> redisTemplate; // 操作redis数据类型的redis模板对象，redis依赖提供

  /**
   * 将值存入Redis
   *
   * @param key
   * @param value
   */
  @Override

  public void put(String key, String value) {
    //operation的缩写 For 后面表示类型
    redisTemplate.opsForValue().set(key, value);
  }

}
