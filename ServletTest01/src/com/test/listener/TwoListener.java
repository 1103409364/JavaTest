package com.test.listener;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;

public class TwoListener implements ServletContextAttributeListener {
  @Override
  public void attributeAdded(final ServletContextAttributeEvent scae) {
    System.out.println("新增共享数据");
  }

  @Override
  public void attributeRemoved(final ServletContextAttributeEvent scae) {
    System.out.println("删除共享数据");
  }

  @Override
  public void attributeReplaced(final ServletContextAttributeEvent scae) {
    System.out.println("修改共享数据");
  }
}
