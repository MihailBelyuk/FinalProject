package com.belyuk.shop.controller.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(
    filterName = "NoCacheFilter",
    urlPatterns = {"/pages/login.jsp", "/pages/users.jsp", "/pages/register.jsp"})
public class NoCacheFilter implements Filter {
  public void init(FilterConfig config) throws ServletException {}

  public void destroy() {}

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws ServletException, IOException {
    HttpServletResponse resp = (HttpServletResponse) response;

    resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    resp.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    resp.setDateHeader("Expires", 0); // Proxies.
    chain.doFilter(request, response);
  }
}
