package com.test.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// alt + insert Generate
public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) {
        // super.doGet(req, resp); resp.sendError(403);
        final ServletContext application = req.getServletContext();
        application.setAttribute("key1", 100); // 新增共享数据
        application.setAttribute("key1", 200); // 更新共享数据
        application.removeAttribute("key1"); // 删 除共享数据

        System.out.println("Get");
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) {
        // super.doPost(req, resp);
        System.out.println("Post");
    }
}
