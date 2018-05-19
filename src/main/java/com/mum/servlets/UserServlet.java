package com.mum.servlets;

import com.mum.dao.DataAccessFactory;
import com.mum.model.Client;
import com.mum.model.Staff;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends BaseTemplate {



  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String action = req.getParameter("action");
    if("login".equals(action)) {
      //user page is redirected, staff page is redirected to reserveList.jsp
      String username = req.getParameter("username");
      String usertype = req.getParameter("usertype");
//       Staff staffByUserName = null;
//       Client clientByFirstname = null;
//       try {
//         staffByUserName = staffDao.getStaffByUserName(username);
//         clientByFirstname = clientDao.getClientByFirstname(username);
//
//       } catch (SQLException e) {
//         e.printStackTrace();
//       }
//       if(staffByUserName != null) {
//         resp.sendRedirect(req.getContextPath() + "/appointment?action=list");
//       } else if(clientByFirstname != null){
// //        resp.sendRedirect(req.getContextPath() + "/appoList.jsp");
//         resp.sendRedirect(req.getContextPath() + "/appointment?action=listofUser");
//       }
//
      try {
        if (usertype.equals("staff")) {
          Staff staff = DataAccessFactory.createStaffDao().getStaffByUserName(username);
          if (staff != null) {
            resp.sendRedirect(req.getContextPath() + "/appointment?action=list");
            System.out.println("-> list page");
          } else {
            System.out.println("Return null!");
          }
        } else if (usertype.equals("client")) {

          Client client = DataAccessFactory.createClientDao().getClientByFirstname(username);
          if (client != null) {
            resp.sendRedirect(req.getContextPath() + "/appointment?action=listofUser");
            System.out.println("-> list of user page");
          } else {
            System.out.println("Return null!");
          }
        }

      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }


}
