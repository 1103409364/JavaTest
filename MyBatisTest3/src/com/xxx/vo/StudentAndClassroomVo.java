package com.xxx.vo;

public class StudentAndClassroomVo {
  // 学生相关的信息
  private String studentId;
  private String studentName;
  private int age;
  // 班级相关的信息
  private String classRoomId;
  private String classroomName;

  public String getStudentId() {
    return this.studentId;
  }

  public void setStudentId(final String studentId) {
    this.studentId = studentId;
  }

  public String getStudentName() {
    return this.studentName;
  }

  public void setStudentName(final String studentName) {
    this.studentName = studentName;
  }

  public int getAge() {
    return this.age;
  }

  public void setAge(final int age) {
    this.age = age;
  }

  public String getClassRoomId() {
    return this.classRoomId;
  }

  public void setClassRoomId(final String classRoomId) {
    this.classRoomId = classRoomId;
  }

  public String getClassroomName() {
    return this.classroomName;
  }

  public void setClassroomName(final String classroomName) {
    this.classroomName = classroomName;
  }

  @Override
  public String toString() {
    return "StudentAndClassroomVo{" + "studentId='" + this.studentId + '\'' + ", studentName='" + this.studentName + '\''
      + ", age=" + this.age + ", classRoomId='" + this.classRoomId + '\'' + ", classroomName='" + this.classroomName + '\'' + '}';
  }
}
