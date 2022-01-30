package com.demo.springboot.config;

import com.demo.springboot.filter.FilterB;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 定义此类为配置类
public class FilterConfig {
  @Bean
  public FilterRegistrationBean filterBRegistrationBean() {
    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new FilterB());
    System.out.println("进入过滤器B");
    //添加过滤路径
    filterRegistrationBean.addUrlPatterns("/user/detail");

    return filterRegistrationBean;
  }
}
