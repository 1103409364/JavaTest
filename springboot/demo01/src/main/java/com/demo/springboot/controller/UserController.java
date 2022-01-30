package com.demo.springboot.controller;

import com.demo.springboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/user") // 当前控制器所有请求加前缀
public class UserController {
  @RequestMapping(value = "/login")
  public @ResponseBody
  Object login(HttpServletRequest request) {
    // 将用户信息存放到session中
    User user = new User();
    user.setUsername("xxx");
    user.setId(1111);
    request.getSession().setAttribute("user", user);
    return "login success";
  }

  // 该请求登录后才能访问
  @RequestMapping(value = "/center")
  public @ResponseBody
  Object center() {
    return "See Center Message";
  }

  // 不登陆也可以访问
  @RequestMapping(value = "/out")
  public @ResponseBody
  Object out() {
    return "Out see anytime";
  }

  // 访问了需要登录的请求，跳转到/error
  @RequestMapping(value = "/error")
  public @ResponseBody
  Object error() {
    return "error";
  }
}
