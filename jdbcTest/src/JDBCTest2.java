import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/*
 * JDBC编程六步
 */
public class JDBCTest2 {
  public static void main(final String[] args) {
    Statement stmt = null;
    Connection conn = null;
    try {
      // 1.1手动注册驱动
      // 手动注册,java.sql包下的驱动管理器类DriverManager,静态方法registerDriver,参数是Driver驱动
      // mySql实现了Driver接口,在驱动 .jar包中可以看到源码。

      // DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

      // 1.2自动注册注册驱动,这种方式可以使用配置文件
      // com.mysql.cj.jdbc.Driver 驱动源码中的静态代码块实现了注册逻辑,通过反射加载类,
      // 自动执行静态代码块,实现自动注册的效果
      // Class.forName("com.mysql.cj.jdbc.Driver");
      // 使用配置文件
      final ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
      final String driverName = bundle.getString("driver");
      Class.forName(driverName);
      // 2、获取连接
      final String url = bundle.getString("url"); // "jdbc:mysql://127.0.0.1:3306/db";
      final String user = bundle.getString("user"); // "root";
      final String password = bundle.getString("password"); // "admin123";

      conn = DriverManager.getConnection(url, user, password);
      System.out.println("数据库连接对象" + conn);
      // 3、获取数据库操作对象(Statement 专门执行sql语句)
      stmt = conn.createStatement();
      // 4、执行sql
      // 添加
      // final String sql1 = "insert into dept(deptno,dname,loc)
      // values(124,'研发部2','上海');";
      // 删除
      // final String sql2 = "delete from dept where deptno=124";
      // 修改
      // 修改
      final String sql3 = "update dept set dname='销售部2',loc='北京' where deptno=123;";
      // 修改
      // 专门执行DML语句
      final int count = stmt.executeUpdate(sql3);
      System.out.println(count == 1 ? "成功" : "失败");
    } catch (final SQLException | ClassNotFoundException throwable) {
      throwable.printStackTrace();
    } finally {
      // 6、释放资源
      // 为了保证资源释放,在finally中关闭资源
      if (stmt != null) {
        try {
          stmt.close();
        } catch (final SQLException throwable) {
          throwable.printStackTrace();
        }
      }
      if (conn != null) {
        try {
          conn.close();
        } catch (final SQLException throwable) {
          throwable.printStackTrace();
        }
      }

    }

    // 5、处理查询结果集
  }
}
