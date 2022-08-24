package com.belyuk.shop.controller.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(
        urlPatterns = {"/pages/admin.page"}
)
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

    HttpServletRequest httpRequest = (HttpServletRequest) request;
    String method = httpRequest.getMethod();
    String URI = httpRequest.getRequestURI();
    System.out.println(method + " request invoked on " + URI);

    chain.doFilter(request, response);
  }
}
