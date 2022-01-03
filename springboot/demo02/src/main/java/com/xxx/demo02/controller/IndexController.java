package com.xxx.demo02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

  @RequestMapping(value = "/say")
  public @ResponseBody
  Object say(String message) {
    return "Say: Hello " + message;
  }
}
