package com.test.jdbc;

import java.sql.*;
import java.util.ResourceBundle;

public class JDBCTest6 {
    public static void main(final String[] args) {

        Connection conn = null;
        PreparedStatement ps = null; // 这里使用PreparedStatement (预编译的数据库操作对象)
        final ResultSet res = null;
        try {
            // 1 注册驱动
            final ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
            final String driver = bundle.getString("driver");
            final String url = bundle.getString("url");
            final String user = bundle.getString("user");
            final String password = bundle.getString("password");
            Class.forName(driver);
            // 2 连接数据库
            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false); // 禁用自动提交，开启事务
            // 3 获取预编译数据库操作对象
            // ? 表示占位符 一个?表示一个值
            final String sql = "update dept set dname = ? where deptno = ?";
            // 程序执行到此处，会发送sql语句框子给DBMS,然后DBMS进行sql语句的预先编译。
            ps = conn.prepareStatement(sql);
            // 给占位符? 传值，根据？出现的位置作为下标，下标从1开始
            ps.setString(1, "z部门"); // setInt 是int类型
            ps.setInt(2, 123);
            // 4 执行sql语句 sql 语句字符串要用单引号
            int count = ps.executeUpdate(); // 执行第一条 update
            System.out.println(count); // 此处断点，查看数据库数据已经变了。实际业务希望两条DML一起提交
            ps.setString(1, "y部门");
            ps.setInt(2, 123);
            count = ps.executeUpdate();// 执行第二条 update，对同一个部门进行修改
            System.out.println(count);
            // 5 处理查询结果集

            // 手动提交事务
            conn.commit();
        } catch (final Exception e) {
            // 提交失败手动回滚
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (final SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            // 释放资源
            if (null != res) {
                try {
                    res.close();
                } catch (final SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (null != ps) {
                try {
                    ps.close();
                } catch (final SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (null != conn) {
                try {
                    conn.close();
                } catch (final SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
