package com.demo.springboot.filter;

import javax.servlet.*;
import java.io.IOException;

public class FilterB implements Filter {
  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    System.out.println("过滤器B");
    filterChain.doFilter(servletRequest, servletResponse);
  }
}
