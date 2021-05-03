package com.bjpowernode.util;

import java.sql.*;

// JdbcUtil obj = new JdbcUtil(); obj.getCon()
// JdbcUtil obj = new JdbcUtil(); obj.createStatement();
// JdbcUtil.getCon();
public class JdbcUtil {

  final String URL = "jdbc:mysql://localhost:3306/exam";
  final String USERNAME = "root";
  final String PASSWORD = "admin123";
  PreparedStatement ps = null;
  Connection con = null;

  // 将jar包中driver实现类加载到JVM中
  static {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (final ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  // 封装连接通道创建细节
  public Connection getCon() {

    try {
      this.con = DriverManager.getConnection(this.URL, this.USERNAME, this.PASSWORD);
    } catch (final SQLException e) {
      e.printStackTrace();
    }
    return this.con;
  }

  // 封装交通工具创建细节
  public PreparedStatement createStatement(final String sql) {

    try {
      this.ps = getCon().prepareStatement(sql);
    } catch (final SQLException e) {
      e.printStackTrace();
    }
    return this.ps;
  }

  // ps与con销毁细节 insert,update,delete
  public void close() {
    if (this.ps != null) {
      try {
        this.ps.close();
      } catch (final SQLException e) {
        e.printStackTrace();
      }
    }

    if (this.con != null) {
      try {
        this.con.close();
      } catch (final SQLException e) {
        e.printStackTrace();
      }
    }

  }

  // select ps,con,rs
  public void close(final ResultSet rs) {
    if (rs != null) {
      try {
        rs.close();
      } catch (final SQLException e) {
        e.printStackTrace();
      }
    }
    close();
  }
}
