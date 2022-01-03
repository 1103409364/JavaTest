package com.xxx.demo03.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

  @RequestMapping(value = "/say")
  public ModelAndView say() {
    ModelAndView mv = new ModelAndView();
    mv.addObject("message",
        "Hello SpringBoot");
    mv.setViewName("say");
    return mv;
  }

  //  model和view也可以拆开
  @RequestMapping(value = "/index")
  public String index(Model model) {
    model.addAttribute("message",
        "hello world");
    return "say";
  }
}
