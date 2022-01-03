package com.demo.springboot.controller;

import com.demo.springboot.config.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {
  @Value("${school.name}")
  private String schoolName;

  @RequestMapping(value = "/say")
  public @ResponseBody
  String say() {
    return "<h1>Hello, SpringBoot!</h1>";
  }

  @RequestMapping(value = "/mapValue")
  public @ResponseBody
  Map<String, Object> mapValue() {
    Map<String, Object> retMap = new HashMap<String, Object>();
    retMap.put("schoolName", schoolName);

    return retMap; // 返回json
  }

  @Autowired // 注入school
  private School school;

  @RequestMapping(value = "/school")
  public @ResponseBody
  String getSchoolName() {
    return "school.name = " + school.getName();
  }
}
