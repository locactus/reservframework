package com.mum.servlets;

import com.mum.dao.ClientDao;
import com.mum.dao.StaffDao;
import com.mum.model.Client;
import com.mum.model.Staff;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

  private StaffDao staffDao = new StaffDao();
  private ClientDao clientDao = new ClientDao();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String action = req.getParameter("action");
    if("login".equals(action)) {
      //user page is redirected, staff page is redirected to reserveList.jsp
      String username = req.getParameter("username");
      Staff staffByUserName = staffDao.getStaffByUserName(username);
      Client clientByFirstname = clientDao.getClientByFirstname(username);
      if(staffByUserName != null) {
        resp.sendRedirect(req.getContextPath() + "/reserveList.jsp");
      } else if(clientByFirstname != null){
        resp.sendRedirect(req.getContextPath() + "/appoList.jsp");
      }
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
