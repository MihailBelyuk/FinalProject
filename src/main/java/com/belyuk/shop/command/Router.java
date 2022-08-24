package com.belyuk.shop.command;

public class Router {
  private String pagePath;
  private RouterType routerType;

  public Router(String pagePath, RouterType routerType) {
    this.pagePath = pagePath;
    this.routerType = routerType;
  }

  public enum RouterType {
    FORWARD,
    REDIRECT
  }

  public Router() {}

  public Router(RouterType routerType) {
    this.routerType = routerType;
  }

  public String getPagePath() {
    return pagePath;
  }

  public RouterType getRouterType() {
    return routerType;
  }
}
