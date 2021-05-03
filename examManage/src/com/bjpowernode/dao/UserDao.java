package com.bjpowernode.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bjpowernode.entity.Users;
import com.bjpowernode.util.JdbcUtil;

/**
 * 2020/4/27
 */
public class UserDao {

  private JdbcUtil util = new JdbcUtil();

  // 用户注册
  public int add(final Users user) {
    final String sql = "insert into users(userName,password,sex,email)" + " values(?,?,?,?);";
    final PreparedStatement ps = this.util.createStatement(sql);
    int result = 0;
    try {
      ps.setString(1, user.getUserName());
      ps.setString(2, user.getPassword());
      ps.setString(3, user.getSex());
      ps.setString(4, user.getEmail());
      result = ps.executeUpdate();
    } catch (final SQLException e) {
      e.printStackTrace();
    } finally {
      this.util.close();
    }
    return result;
  }

  // 查询所有用户信息
  public List findAll() {
    final String sql = "select * from users;";
    final PreparedStatement ps = this.util.createStatement(sql);
    ResultSet rs = null;
    final List userList = new ArrayList();
    try {
      rs = ps.executeQuery();
      while (rs.next()) {
        final Integer userId = rs.getInt("userId");
        final String userName = rs.getString("userName");
        final String password = rs.getString("password");
        final String sex = rs.getString("sex");
        final String email = rs.getString("email");
        final Users users = new Users(userId, userName, password, sex, email);
        userList.add(users);
      }
    } catch (final SQLException e) {
      e.printStackTrace();
    } finally {
      this.util.close(rs);
    }
    return userList;
  }

  // 根据用户编号删除用户信息
  public int delete(final String userId) {
    final String sql = "delete from users where userId=?;";
    final PreparedStatement ps = this.util.createStatement(sql);
    int result = 0;
    try {
      ps.setInt(1, Integer.valueOf(userId));
      result = ps.executeUpdate();
    } catch (final SQLException e) {
      e.printStackTrace();
    } finally {
      this.util.close();
    }
    return result;
  }

  // 登录验证
  public int login(final String userName, final String password) {
    final String sql = "select count(*) from users where userName=? and password=?";
    final PreparedStatement ps = this.util.createStatement(sql);
    ResultSet rs = null;
    int result = 0;
    try {
      ps.setString(1, userName);
      ps.setString(2, password);
      rs = ps.executeQuery();
      while (rs.next()) {
        result = rs.getInt("count(*)");
      }
    } catch (final SQLException e) {
      e.printStackTrace();
    } finally {
      this.util.close(rs);
    }
    return result;
  }
}
