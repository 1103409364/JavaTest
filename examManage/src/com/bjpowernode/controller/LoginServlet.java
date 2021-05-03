package com.bjpowernode.controller;

import java.io.IOException;

import com.bjpowernode.dao.UserDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
  protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
    throws ServletException, IOException {
    final String userName;
    final String password;
    final UserDao dao = new UserDao();
    final int result;
    // 1.调用请求对象对请求体使用utf-8字符集进行重新编辑
    request.setCharacterEncoding("utf-8");
    // 2.调用请求对象读取请求体参数信息
    userName = request.getParameter("userName");
    password = request.getParameter("password");
    // 3.调用Dao将查询验证信息推送到数据库服务器上
    result = dao.login(userName, password);
    // 4.调用响应对象，根据验证结果将不同资源文件地址写入到响应头，交给浏览器
    if (result == 1) {// 用户存在
      response.sendRedirect("/exam/index.html");
    } else {
      response.sendRedirect("/exam/login_error.html");
    }

  }

}
