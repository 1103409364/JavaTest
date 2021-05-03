package com.test.filter;

import java.io.IOException;

import jakarta.servlet.*;

public class TwoFilter implements Filter {
  @Override
  public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse,
    final FilterChain filterChain) throws IOException, ServletException {
    servletRequest.setCharacterEncoding("utf-8");
    filterChain.doFilter(servletRequest, servletResponse);
  }
}
