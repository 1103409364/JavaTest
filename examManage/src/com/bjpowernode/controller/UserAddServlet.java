package com.bjpowernode.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.bjpowernode.dao.UserDao;
import com.bjpowernode.entity.Users;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserAddServlet extends HttpServlet {

  protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
    // final ServletContext application = request.getServletContext(); application.setAttribute("key1", "1");

    final String userName;
    final String password;
    final String sex;
    final String email;
    final UserDao dao = new UserDao();
    final Users user;
    final int result;
    final PrintWriter out;
    // 1.【调用请求对象】读取【请求头】参数信息，得到用户的信息信息
    userName = request.getParameter("userName");
    password = request.getParameter("password");
    sex = request.getParameter("sex");
    email = request.getParameter("email");

    // 2.【调用UserDao】将用户信息填充到INSERT命令并借助JDBC规范发送到数据库服务器
    user = new Users(null, userName, password, sex, email);
    result = dao.add(user);
    // 3.【调用响应对象】将【处理结果】以二进制形式写入到响应体
    response.setContentType("text/html;charset=utf-8");
    out = response.getWriter();
    if (result == 1) {
      out.print("<font style='color:red;font-size:40'>用户信息注册成功</font>");
    } else {
      out.print("<font style='color:red;font-size:40'>用户信息注册失败</font>");
    }
  }
  // Tomcat负责销毁【请求对象】和【响应对象】
  // Tomcat负责将Http响应协议包推送到发起请求的浏览器上
  // 浏览器根据响应头content-type指定编译器对响应体二进制内容编辑
  // 浏览器将编辑后结果在窗口中展示给用户【结束】
}
