package com.bjpowernode.entity;

/**
 * 2020/4/27
 */
public class Users {

  private Integer userId;
  private String userName;
  private String password;
  private String sex;
  private String email;

  public Integer getUserId() {
    return this.userId;
  }

  public void setUserId(final Integer userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return this.userName;
  }

  public void setUserName(final String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(final String password) {
    this.password = password;
  }

  public String getSex() {
    return this.sex;
  }

  public void setSex(final String sex) {
    this.sex = sex;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  public Users() {}

  public Users(final Integer userId, final String userName, final String password, final String sex, final String email) {
    this.userId = userId;
    this.userName = userName;
    this.password = password;
    this.sex = sex;
    this.email = email;
  }
}
