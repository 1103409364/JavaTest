package com.xxx;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xxx.dao.StudentDao;
import com.xxx.entity.Student;
import com.xxx.service.StudentService;

/**
 * Unit test for simple App.
 */
public class AppTest {
  /**
   * Rigorous Test :-)
   */
  @Test
  public void test01() {
    final String config = "applicationContext.xml";
    // 创建容器对象时，读取配置文件，创建出SqlSessionFactory对象、数据源对象
    final ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
    final String[] names = ctx.getBeanDefinitionNames();

    for (final String na : names) {
      System.out.println("容器中的对象：" + na + "|" + ctx.getBean(na).getClass().getName());
    }
    // 容器中的对象：myDataSource|com.alibaba.druid.pool.DruidDataSource
    // 容器中的对象：sqlSessionFactory|org.apache.ibatis.session.defaults.DefaultSqlSessionFactory
  }

  @Test
  public void testDaoInsert() {
    final String config = "applicationContext.xml";
    final ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
    final StudentDao studentDao = (StudentDao)ctx.getBean("studentDao");
    final Student student1 = new Student();
    student1.setId(1);
    student1.setName("张三");
    student1.setAge(11);
    student1.setEmail("121221@xx.com");
    final int nums = studentDao.insertStudent(student1);
    System.out.println(nums);
  }

  @Test
  public void testServiceInsert() {
    final String config = "applicationContext.xml";
    final ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
    final StudentService service = (StudentService)ctx.getBean("studentService");
    final Student student1 = new Student();
    student1.setId(10);
    student1.setName("小明");
    student1.setAge(111);
    student1.setEmail("dfasfsdaf@xx.com");
    final int nums = service.addStudent(student1);
    // 无需执行SqlSession.commit();直接添加成功了。因为spring整合mybatis时事务是自动提交的。
    System.out.println(nums);

  }

  @Test
  public void testServiceSelect() {
    final String config = "applicationContext.xml";
    final ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
    final StudentService service = (StudentService)ctx.getBean("studentService");

    final List<Student> students = service.queryStudents();
    for (final Student s : students) {
      System.out.println(s);
    }

  }
}
