package com.test.filter;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.*;

public class OneFilter implements Filter {

  @Override
  public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse,
    final FilterChain filterChain) throws IOException, ServletException {
    // filterChain 放行
    // 1.通过拦截请求对象得到请求包参数信息
    final String age = servletRequest.getParameter("age");
    // 2.假设年龄大于70是非法访问
    if (Integer.parseInt(age) < 70) {
      // 请求合法
      filterChain.doFilter(servletRequest, servletResponse); // 放行
    } else {
      // 通过过滤器代替Http服务器拒绝本次请求
      servletResponse.setContentType("text/html;charset=utf-8");
      final PrintWriter out = servletResponse.getWriter();
      out.print("非法请求");
    }
  }
}
