package com.demo.springboot.mapper;

import com.demo.springboot.model.Student;
import org.apache.ibatis.annotations.Mapper;

//注解报错可能是依赖问题
@Mapper
public interface StudentMapper {
  int deleteByPrimaryKey(Integer id);

  int insert(Student record);

  int insertSelective(Student record); //选择性新增

  Student selectByPrimaryKey(Integer id);//根据主键查对象

  int updateByPrimaryKeySelective(Student record);

  int updateByPrimaryKey(Student record);//根据主键更新key
}
