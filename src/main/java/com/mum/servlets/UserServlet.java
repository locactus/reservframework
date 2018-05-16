package com.mum.servlets;

import com.mum.dao.mysql.ClientDAO;
import com.mum.dao.mysql.StaffDAO;
import com.mum.model.Client;
import com.mum.model.Staff;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

  private StaffDAO staffDao = new StaffDAO();
  private ClientDAO clientDao = new ClientDAO();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String action = req.getParameter("action");
    if("login".equals(action)) {
      //user page is redirected, staff page is redirected to reserveList.jsp
      String username = req.getParameter("username");
      Staff staffByUserName = null;
      Client clientByFirstname = null;
      try {
        staffByUserName = staffDao.getStaffByUserName(username);
        clientByFirstname = clientDao.getClientByFirstname(username);

      } catch (SQLException e) {
        e.printStackTrace();
      }
      if(staffByUserName != null) {
        resp.sendRedirect(req.getContextPath() + "/appointment?action=list");
      } else if(clientByFirstname != null){
//        resp.sendRedirect(req.getContextPath() + "/appoList.jsp");
        resp.sendRedirect(req.getContextPath() + "/appointment?action=listOfUser");
      }
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
