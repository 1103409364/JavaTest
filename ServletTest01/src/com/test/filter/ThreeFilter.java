package com.test.filter;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ThreeFilter implements Filter {
    @Override
    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse,
        final FilterChain filterChain) throws IOException, ServletException {
        // servletRequest 没有getSession方法，强转
        final HttpServletRequest request = (HttpServletRequest)servletRequest;
        final HttpServletResponse response = (HttpServletResponse)servletResponse;
        final String uri = request.getRequestURI();// [/网站名/资源文件名]
        if (uri.contains("login") || "/myWeb/".equals(uri)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        // 1 拦截后，通过请求对象向Tomcat索要当前用户的HttpSession
        final HttpSession session = request.getSession();
        // 2 判断当前用户是否合法
        if (session == null) {
            request.getRequestDispatcher("/login_error.html").forward(servletRequest, servletResponse);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
