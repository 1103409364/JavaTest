package com.xxx.dao;

import java.util.List;
import java.util.Map;

import com.xxx.domain.Student;
import com.xxx.vo.StudentAndClassroomVo;

public interface StudentDao {
  public Student getById(String id);

  public void save(Student s);

  public List<Student> getAll();

  public List<Map<String, Object>> selectAllMap();

  public List<Map<String, Object>> selectNameClass();

  public List<Student> selectLike(String query);

  public List<Student> selectQuery(Student s);

  public List<Student> selectByIdArr(String[] idArr);

  public List<StudentAndClassroomVo> selectNameClassVo();

  List<StudentAndClassroomVo> selectNameClassVoQuery(String query);
}
