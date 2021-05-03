import java.sql.*;
import java.util.ResourceBundle;

public class JDBCTest3 {
  public static void main(final String[] args) {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    try {
      // 1 注册驱动
      final ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
      final String driver = bundle.getString("driver");
      final String url = bundle.getString("url");
      final String user = bundle.getString("user");
      final String password = bundle.getString("password");
      Class.forName(driver);
      // 2 建立连接
      conn = DriverManager.getConnection(url, user, password);
      // 3 获取数据库操作对象
      stmt = conn.createStatement();
      // 4 执行sql
      final String sql = "select * from dept where deptno = 123;";
      rs = stmt.executeQuery(sql); // executeQuery 专门执行查询语句，executeUpdate 专门执行增删改
      // 5 处理查询结果集
      while (rs.next()) {
        // --以列的下标获取 参数是第几列
        // final String deptno = rs.getString(1); // JDBC 中所有下标从0开始
        // final String dname = rs.getString(2); //
        // final String loc = rs.getString(3); //
        // System.out.println("deptno:" + deptno + " dname:" + dname + " loc:" + loc);
        // -- 以列名字段获取 参数 列名，必须写查询语句的列名，重命名要写新的名称
        // 列名称是查询结果集的名称，不是数据库字段
        // 除了以 String 取出外，还可以 getInt
        final int deptno = rs.getInt("deptno");
        final String dname = rs.getString("dname");
        final String loc = rs.getString("dname");
        System.out.println("deptno:" + deptno + " dname:" + dname + " loc:" + loc);

      }
    } catch (final Exception e) {
      e.printStackTrace();
      // 6 释放资源
      if (rs != null) {
        try {
          rs.close();
        } catch (final SQLException throwables) {
          throwables.printStackTrace();
        }
      }
      if (stmt != null) {
        try {
          stmt.close();
        } catch (final SQLException throwables) {
          throwables.printStackTrace();
        }
      }
      if (conn != null) {
        try {
          conn.close();
        } catch (final SQLException throwables) {
          throwables.printStackTrace();
        }
      }
    }
  }
}
