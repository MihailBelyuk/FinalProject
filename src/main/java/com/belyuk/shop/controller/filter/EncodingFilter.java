package com.belyuk.shop.controller.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

@WebFilter(
    urlPatterns = {"/controller"},
    initParams = {
      @WebInitParam(name = "encoding", value = "UTF-8", description = "Encoding Param"),
    })
public class EncodingFilter implements Filter {
  private static final Logger logger = LogManager.getLogger();
  private String encoding;

  public void init(FilterConfig config) throws ServletException {
    encoding = config.getInitParameter("encoding");
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws ServletException, IOException {
    String codeRequest = request.getCharacterEncoding();
    if (encoding != null && !encoding.equals(codeRequest)) {
      request.setCharacterEncoding(encoding);
      response.setCharacterEncoding(encoding);
    }
    chain.doFilter(request, response);
  }

  public void destroy() {
    encoding = null;
  }
}
