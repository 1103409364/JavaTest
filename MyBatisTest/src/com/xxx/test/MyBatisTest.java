package com.xxx.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.xxx.domain.Student;

public class MyBatisTest {
    public static void main(final String[] args) {
        // 引入主配置文件
        final String resource = "mybatis-config.xml"; // 根路径 src
        InputStream inputStream = null;
        try {
            // 通过加载MyBatis的主配置文件创建输入流对象
            inputStream = Resources.getResourceAsStream(resource);
        } catch (final IOException e) {
            e.printStackTrace();
        }
        /*
        * SqlSessionFactoryBuilder:SqlSessionFactory的建造者
        * */
        final SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 创建会话，curd统一使用SqlSession对象完成
        final SqlSession session = sqlSessionFactory.openSession(); // java程序和数据库之间的会话
        // 根据id查单条
        // 如果取得的是单条记录，我们调用selectOne方法
        // 参数1:根据命名空间. sqlId的形式找到我们需要使用的sql语句
        // 参数2:我们要为sql语句中传递的参数，在map中接收
        final Student s = session.selectOne("StudentMapper.getById", 3);
        System.out.println(s);

        final List<Student> list = session.selectList("StudentMapper.getAll");
        System.out.println(list);

        final Student s2 = new Student();
        s2.setId("666");
        s2.setName("小明");
        s2.setAge(23);
        // 添加
        // final int count = session.insert("StudentMapper.save", s2);
        // System.out.println("受到影响的条数" + count); // 没有commit 实际上数据库没有添加成功，count不准
        // MyBatis默认手动提交事务，提交事务，数据插入才会生效。只要添加修改删除都要提交事务
        s2.setAge(555);
        // 修改
        // session.update("StudentMapper.update", s2);
        // 删除
        final int count = session.delete("StudentMapper.delete", s2);
        System.out.println(count);
        session.commit();
        session.close(); // 必须close，表示resultSet、connection、preparedStatement 关闭
    }
}
