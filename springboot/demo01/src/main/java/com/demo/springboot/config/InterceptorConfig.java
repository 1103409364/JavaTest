package com.demo.springboot.config;

import com.demo.springboot.interceptor.UserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // 定义此类为配置类（即之前的xml配置文件）
public class InterceptorConfig implements WebMvcConfigurer {
  // mvc:interceptors
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // 拦截user下的所有请求 省略核心配置文件中配置的路径前缀
    String[] addPathPatterns = {
        "/user/**" // 两个*表示拦截后续所有层级的目录，一个*只能拦截下一级
    };
    // 要排除的路径，不需要登录也可以访问
    String[] excludePathPatterns = {
        "/user/out", "/user/error", "/user/login"
    };
    //mvc:interceptor bean class=""
    registry.addInterceptor(new UserInterceptor()).addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns); // 注册拦截器
  }
}
