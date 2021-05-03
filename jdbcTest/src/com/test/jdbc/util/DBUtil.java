
// JDBC 工具类，简化JDBC编程
package com.test.jdbc.util;

import java.sql.*;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;

@SuppressWarnings("ALL")
public class DBUtil {
    // 工具类的构造方法一般是私有的
    // 因为工具类当中的方法都是静态的，不需要new对象，直接采用类名调用。
    private DBUtil() {}

    private static String url = "";
    private static String user = "";
    private static String password = "";

    static {
        // 1 注册驱动 放在静态代码块中，只执行一次，在类加载的时候
        try {
            final ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
            // 数据库驱动
            final String driver = bundle.getString("driver");
            url = bundle.getString("url");
            user = bundle.getString("user");
            password = bundle.getString("password");
            Class.forName(driver); // "com.mysql.cj.jdbc.Driver" 改用配置文件
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        // 2 连接数据库 "jdbc:mysql://127.0.0.1:3306/db", "root", "admin123"
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * @param conn
     * @param ps
     * @param res
     */
    public static void close(final Connection conn, final Statement ps, final ResultSet res) {
        // 6 释放资源
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

    // 通过全 局作用域对象得到Connection-----------start
    public Connection getConnection(final HttpServletRequest request) {
        // 1.通过请求对象，得到全局作用域对象
        final ServletContext application = request.getServletContext();
        // 2.从全局作用域对象得到map
        final Map map = (Map)application.getAttribute("key1");
        // 3.从map得到一个处于空闲状态Connection(拖鞋)
        final Iterator it = map.keySet().iterator();
        Connection con = null;
        while (it.hasNext()) {
            con = (Connection)it.next();
            final boolean flag = (boolean)map.get(con);
            if (flag == true) {
                map.put(con, false);
                break;
            }
        }
        return con;
    }
    // -------------通过全局作用域对象得到Connection-----------start
}
