package com.xxx.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * 操作MyBatis
 */
public class SqlSessionUtil {
  // 构造方法私有化，防止被new，浪费内存。静态方法可以直接通过类名调用，不用new
  private SqlSessionUtil() {}

  private static final SqlSessionFactory sqlSessionFactory;

  static {
    final String resource = "mybatis-config.xml";
    InputStream inputStream = null;

    try {
      inputStream = Resources.getResourceAsStream(resource);
    } catch (final IOException e) {
      e.printStackTrace();
    }

    sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
  }
  // ThreadLocal https://www.jianshu.com/p/3c5d7f09dfbd
  // 所有的流程用同一个session才能保证事务生效
  private static final ThreadLocal<SqlSession> t = new ThreadLocal<>();

  // 取得SqlSession对象
  public static SqlSession getSession() {
    SqlSession session = t.get();
    if (null == session) {
      session = sqlSessionFactory.openSession();
      t.set(session);
    }
    return session;
  }

  // 关闭SqlSession对象
  public static void myClose(final SqlSession session) {
    if (null != session) {
      session.close();
      // 必须加remove剥离线程，线程不会真的关闭，还在线程池中（tomcat自带线程池），连接回到连接池
      t.remove();
    }
  }

  // 提交、回滚 一般不在这做，在动态代理中，
  // 代理模式在业务层使用
  // 1 业务层只关注业务逻辑，其他逻辑交给代理，单一职责
  // 2 事务本身属于数据库相关的机制，业务层掺杂事务逻辑不太好
  // 3 一个业务实现类使用一个代理，开发量大太麻烦，统一使用动态代理处理事务

  // public static void commit(final SqlSession session) {
  // if (null != session) {
  // session.commit();
  // }
  // }
}
