package com.mum.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/appointment")
public class AppointmentServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String action = req.getParameter("action");
    if(action.equals("add")) {
      addAppointment(req, resp);
    } else if(action.equals("list")) {
      listAllAppointment(req, resp);
    } else if(action.equals("confirm")) {
      confirmAppointment(req, resp);
    }
  }

  private void confirmAppointment(HttpServletRequest req, HttpServletResponse resp) {
//    req.getParameter("")
  }

  private void listAllAppointment(HttpServletRequest req, HttpServletResponse resp) {

  }

  private void addAppointment(HttpServletRequest req, HttpServletResponse resp) {

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
