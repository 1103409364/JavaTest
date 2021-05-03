package com.test.jdbc;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;

public class JDBCTest5 {
    public static void main(final String[] args) {
        final Map<String, String> userLoginInfo = initUI(); // 初始化界面
        final boolean loginSuccess = login(userLoginInfo); // 验证用户名密码
        System.out.println(loginSuccess ? "登录成功" : "登录失败");
    }

    /*
     * 用户登录
     * @param userLoginInfo
     * @return 结果
     */
    private static boolean login(final Map<String, String> userLoginInfo) {
        final String loginName = userLoginInfo.get("loginName");
        final String loginPwd = userLoginInfo.get("loginPwd");

        Connection conn = null;
        PreparedStatement ps = null; // 这里使用PreparedStatement (预编译的数据库操作对象)
        ResultSet res = null;
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
            // 3 获取预编译数据库操作对象
            // ? 表示占位符 一个?表示一个值
            final String sql = "select * from t_user u where u.loginName=? and u.loginPwd=?;";
            // 程序执行到此处，会发送sql语句框子给DBMS,然后DBMS进行sql语句的预先编译。
            ps = conn.prepareStatement(sql);
            // 给占位符? 传值，根据？出现的位置作为下标，下标从1开始
            ps.setString(1, loginName); // setInt 是int类型
            ps.setString(2, loginPwd);
            // 4 执行sql语句 sql 语句字符串要用单引号

            res = ps.executeQuery(); // sql 语句改为第三步传
            // 5 处理查询结果集
            final boolean loginSuccess;
            loginSuccess = res.next(); // 有数据说明验证通过

            return loginSuccess;
        } catch (final Exception e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            if (null != res) {
                try {
                    res.close();
                } catch (final SQLException throwable) {
                    throwable.printStackTrace();
                }
            }
            if (null != ps) {
                try {
                    ps.close();
                } catch (final SQLException throwable) {
                    throwable.printStackTrace();
                }
            }
            if (null != conn) {
                try {
                    conn.close();
                } catch (final SQLException throwable) {
                    throwable.printStackTrace();
                }
            }
        }
        return true;
    }

    /*
     * 初始化用户界面
     * @return 用户输入的用户名和密码等登录信息
     */
    private static Map<String, String> initUI() {
        final Scanner s = new Scanner(System.in);
        System.out.print("请输入用户名：");
        final String userName = s.nextLine();

        System.out.print("请输入密码：");
        final String loginPwd = s.nextLine();

        final Map<String, String> userLonginInfo = new HashMap<>();
        userLonginInfo.put("loginName", userName);
        userLonginInfo.put("loginPwd", loginPwd);
        return userLonginInfo;
    }
}
