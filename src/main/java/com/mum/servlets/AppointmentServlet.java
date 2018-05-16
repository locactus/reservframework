package com.mum.servlets;

import com.mum.dao.AppointmentDao;
import com.mum.dao.ClientDao;
import com.mum.dao.RequestDao;
import com.mum.dao.StaffDao;
import com.mum.dao.TimeslotDao;
import com.mum.dto.AppointmentDTO;
import com.mum.model.Appointment;
import com.mum.model.Client;
import com.mum.model.Request;
import com.mum.model.Timeslot;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/appointment")
public class AppointmentServlet extends HttpServlet {

  private StaffDao staffDao = new StaffDao();
  private ClientDao clientDao = new ClientDao();
  private AppointmentDao appointmentDao = new AppointmentDao();
  private RequestDao requestDao = new RequestDao();
  private TimeslotDao timeslotDao = new TimeslotDao();

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
    try {
      List<Appointment> allAppointment = appointmentDao.getAll();
      List<AppointmentDTO> appointments = allAppointment.stream()
          .map(apointment -> mapToDTO(apointment))
          .collect(Collectors.toList());
      req.setAttribute("appointments", appointments);
      req.getRequestDispatcher(req.getContextPath() + "/appoList.jsp").forward(req, resp);
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ServletException e) {
      e.printStackTrace();
    }
  }

  private AppointmentDTO mapToDTO(Appointment apointment) {
    AppointmentDTO appointmentDTO = new AppointmentDTO(apointment.getAppointmentId(), apointment.getTimeslotId(), apointment.getClientId());
    Timeslot timeslot = null;
    try {
      timeslot = timeslotDao.getByTimeslotId(apointment.getTimeslotId());
    } catch (SQLException e) {
      e.printStackTrace();
    }

    Request request = new Request();
    try {
      List<Request> requestsByAppointmentId = requestDao.getRequestsByAppointmentId(apointment.getAppointmentId());
      request = requestsByAppointmentId.get(0);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    Client user = new Client();
    try {
      user = clientDao.getClientByClientId(apointment.getClientId());
    } catch (SQLException e) {
      e.printStackTrace();
    }
    appointmentDTO.setEmail(user.getEmail());
    appointmentDTO.setFirstName(user.getFirstName());
    appointmentDTO.setLastName(user.getLastName());
    appointmentDTO.setPhoneNumber(user.getPhoneNumber());
    appointmentDTO.setState(request.getState());
    appointmentDTO.setTimeslot(timeslot);
    return appointmentDTO;
  }

  private void addAppointment(HttpServletRequest req, HttpServletResponse resp) {

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
