package com.bjpowernode.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.bjpowernode.dao.UserDao;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserDeleteServlet extends HttpServlet {

  protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
    final String userId;
    final UserDao dao = new UserDao();
    final int result;
    final PrintWriter out;
    // 1.[调用请求对象]读取【请求头】参数（用户编号）
    userId = request.getParameter("userId");
    // 2.[调用DAO]将用户编号填充到delete命令并发送到数据库服务器
    result = dao.delete(userId);
    // 3.[调用响应对象]将处理结果以二进制写入到响应体，交给浏览器
    response.setContentType("text/html;charset=utf-8");
    out = response.getWriter();
    if (result == 1) {
      out.print("<font style='color:red;font-size:40'>用户信息删除成功</font>");
    } else {
      out.print("<font style='color:red;font-size:40'>用户信息删除失败</font>");
    }
  }
}
