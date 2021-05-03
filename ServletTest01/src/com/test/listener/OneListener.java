package com.test.listener;

import java.sql.Connection;
import java.util.Map;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class OneListener implements ServletContextListener {

    @Override
    public void contextInitialized(final ServletContextEvent sce) {
        // final JdbcUtil util = new JdbcUtil();
        // final Map map = new HashMap();
        // for (int i = 1; i <= 20; i++) {
        // final Connection con = util.getCon();
        // System.out.println("在Http服务器启动时，创建Connection" + con);
        // map.put(con, true); // true表示这 个通道处于空闲状态，false通道 正在被使用
        // }
        // 为了在Http服务器运行期间，一直都可以使用20个Connection, 将connection保存
        // 到全局作用域对象对象
        // final ServletContext application = sce.getServletContext();
        // application.setAttribute("key1", map);
        System.out.println("创建全局作用域对象");
    }

    @Override
    public void contextDestroyed(final ServletContextEvent sce) {
        // map 销毁 在Http服务器关闭时刻，将全局作用域对象20个Connection销毁
        final ServletContext application = sce.getServletContext();
        final Map<?, ?> map = (Map<?, ?>)application.getAttribute("key1");

        for (final Object o : map.keySet()) {
            final Connection con = (Connection)o;
            if (con != null) {
                System.out.println(con + "销毁");
            }
        }

        System.out.println("销毁全局作用域对象");
    }
}
