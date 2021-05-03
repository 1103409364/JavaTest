import java.sql.*;

/*
 * JDBC编程六步
 */
public class JDBCTest1 {
    public static void main(final String[] args) {
        // 1、注册驱动
        // 手动注册,java.sql包下的驱动管理器类DriverManager,静态方法registerDriver,参数是Driver驱动
        // mySql实现了Driver接口,在驱动.jar包中可以看到源码
        final Driver driver; // com.mysql.jdbc. 不能删
        Statement stmt = null;
        Connection conn = null;
        try {
            driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            // 2、获取连接
            final String url = "jdbc:mysql://127.0.0.1:3306/db";
            final String user = "root";
            final String password = "admin123";

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("数据库连接对象" + conn);
            // 3、获取数据库操作对象(Statement 专门执行sql语句)
            stmt = conn.createStatement();
            // 4、执行sql
            // 添加
            // final String sql1 = "insert into dept(deptno,dname,loc) values(124,'研发部2','上海');";
            // 删除
            // final String sql2 = "delete from dept where deptno=124";
            // 修改
            final String sql3 = "update dept set dname='销售部',loc='北京' where deptno=123;";
            // 修改
            // 专门执行DML语句
            final int count = stmt.executeUpdate(sql3);
            System.out.println(count == 1 ? "成功" : "失败");
        } catch (final SQLException throwable) {
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
