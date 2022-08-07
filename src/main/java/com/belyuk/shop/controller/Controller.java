package com.belyuk.shop.controller;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.command.constant.AttributeParameterName;
import com.belyuk.shop.command.constant.CommandType;
import com.belyuk.shop.command.constant.PagePath;
import com.belyuk.shop.exception.CommandException;
import com.belyuk.shop.pool.ConnectionPool;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/** The type Controller. Extends HttpServlet and processes the commands. */
@WebServlet(
    name = "Controller",
    urlPatterns = {"/controller", "*.do"})
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024,
    maxRequestSize = 1024 * 1024,
    maxFileSize = 1024 * 1024)
public class Controller extends HttpServlet {
  private static final Logger logger = LogManager.getLogger();

  public void init() {

    logger.log(Level.INFO, "initServlet");
    ConnectionPool.getInstance();
  }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    processRequest(request, response);
  }

  public void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String commandName = request.getParameter(AttributeParameterName.COMMAND);
    Router router;
    try {
      Command command = CommandType.define(commandName);
      router = command.execute(request);
      switch (router.getRouterType()) {
        case FORWARD:
          RequestDispatcher dispatcher = request.getRequestDispatcher(router.getPagePath());
          dispatcher.forward(request, response);
          break;
        case REDIRECT:
          response.sendRedirect(router.getPagePath());
          break;
        default:
          logger.log(Level.ERROR, "Incorrect router type " + router.getRouterType());
          response.sendRedirect(PagePath.ERROR_500_PAGE);
      }
    } catch (CommandException e) {
      logger.log(Level.ERROR, "Unable to define router type.", e);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response);
  }

  public void destroy() {
    logger.log(Level.INFO, "Destroy Servlet");
    ConnectionPool.getInstance().destroyPool();
  }
}
