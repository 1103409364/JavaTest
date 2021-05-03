package com.test.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.test.jdbc.util.DBUtil;

public class JDBCTest7 {
    public static void main(final String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        try {
            // 3 连接数据库
            conn = DBUtil.getConnection();
            // 4 创建数据库操作对象
            // 第二个字母含有字母A的员工姓名
            final String sql = "select ename from emp where ename like ?"; // 模糊查询不能这么写'_?%'
            ps = conn.prepareStatement(sql);
            ps.setString(1, "_A%");
            // 5 执行sql
            res = ps.executeQuery();
            // 6 处理结果集
            while (res.next()) {
                final String ename = res.getString("ename");
                System.out.println(ename);
            }
        } catch (final SQLException throwable) {
            throwable.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, res);
        }
    }
}
