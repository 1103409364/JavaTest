package com.demo.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component // 将此类交给spring容器管理
@ConfigurationProperties(prefix = "school") // 配置前缀
public class School {
  private String name;
  private String webSite;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getWebSite() {
    return webSite;
  }

  public void setWebSite(String webSite) {
    this.webSite = webSite;
  }
}
