package com.belyuk.shop.controller.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;

import java.io.IOException;

@WebFilter(
    urlPatterns = "/pages/*",
    initParams = {@WebInitParam(name = "INDEX_PATH", value = "/index.jsp")})
public class PageRedirectSecurityFilter implements Filter {

  private String indexPath;

  public void init(FilterConfig fConfig) throws ServletException {
    indexPath = fConfig.getInitParameter("INDEX_PATH");
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws ServletException, IOException {
    chain.doFilter(request, response);
  }

  public void destroy() {}
}
