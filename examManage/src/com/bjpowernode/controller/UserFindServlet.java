package com.bjpowernode.controller;

import com.bjpowernode.dao.UserDao;
import com.bjpowernode.entity.Users;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserFindServlet extends HttpServlet {

    protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
        throws IOException {
        final UserDao dao = new UserDao();
        final PrintWriter out;
        // 1[调用DAO]将查询命令推送到数据库服务器上，得到所有用户信息【List】
        final List<Users> userList = dao.findAll();
        // 2[调用响应对象]将用户信息结合<table>标签命令以二进制形式写入到响应体
        response.setContentType("text/html;charset=utf-8");
        out = response.getWriter();
        out.print("<table border='2' align='center'>");
        out.print("<tr>");
        out.print("<td>用户编号</td>");
        out.print("<td>用户姓名</td>");
        out.print("<td>用户密码</td>");
        out.print("<td>用户性别</td>");
        out.print("<td>用户邮箱</td>");
        out.print("<td>操作</td>");
        out.print("</tr>");

        for (final Users users : userList) {
            out.print("<tr>");
            out.print("<td>" + users.getUserId() + "</td>");
            out.print("<td>" + users.getUserName() + "</td>");
            out.print("<td>******</td>");
            out.print("<td>" + users.getSex() + "</td>");
            out.print("<td>" + users.getEmail() + "</td>");
            out.print("<td><a href='/exam/user/delete?userId=" + users.getUserId() + "'>删除用户</a></td>");
            out.print("</tr>");
        }
        out.print("</table>");
        // 返回json
        final Map<String, Object> map = new HashMap<>();
        map.put("data", userList);
        map.put("code", 20000);
        // final JSONArray json = new JSONArray(userList);
        final JSONObject json = new JSONObject(map);
         json.put("data", userList);
         System.out.println(json.toString());

        out.print(json.toString());
    }
}
