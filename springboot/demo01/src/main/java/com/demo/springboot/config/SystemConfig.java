package com.demo.springboot.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.FilterRegistration;

@Configuration
public class SystemConfig {
  @Bean
  public FilterRegistration characterEncodingFilterRegistrationBean() {
    // 创建字符编码过滤器
    CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
    // 强制指定字符编码
    characterEncodingFilter.setEncoding("utf-8");

    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
    // 设置字符编码过滤器
    filterRegistrationBean.setFilter(characterEncodingFilter);
    // 设置字符编码过滤器路径
    filterRegistrationBean.addUrlPatterns("/*");
    return null;
  }
}
