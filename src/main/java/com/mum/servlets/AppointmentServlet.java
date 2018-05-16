package com.mum.servlets;

import com.mum.dao.mysql.*;
import com.mum.dto.AppointmentDTO;
import com.mum.model.Appointment;
import com.mum.model.Client;
import com.mum.model.Request;
import com.mum.model.Timeslot;
import com.mum.model.enums.RequestState;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/appointment")
public class AppointmentServlet extends HttpServlet {

  private StaffDao staffDao = new StaffDao();
  private ClientDao clientDao = new ClientDao();
  private AppointmentDao appointmentDao = new AppointmentDao();
  private RequestDao requestDao = new RequestDao();
  private TimeslotDao timeslotDao = new TimeslotDao();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
    try {
      String action = req.getParameter("action");
      if (action.equals("add")) {
        addAppointment(req, resp);
      } else if (action.equals("listOfUser")) {
        listAllAppointment(req, resp);
      } else if (action.equals("confirm")) {
        confirmAppointment(req, resp);
      } else if (action.equals("toaddtimeslot")) {
        req.getRequestDispatcher(req.getContextPath() + "/createTimeslot.jsp").forward(req, resp);
      } else if (action.equals("addtimeslot")) {
        addTimeSlot(req, resp);
        resp.sendRedirect(req.getContextPath() + "/appointment/list");
      } else if (action.equals("toaddAppo")) {
        List<Timeslot> timeslotList = timeslotDao.getAll();
        List<Client> clientList = clientDao.getAll();
        req.setAttribute("timeslotList", timeslotList);
        req.getRequestDispatcher(req.getContextPath() + "/createAppo.jsp").forward(req, resp);
      } else if (action.equals("addAppo")) {

      }
    } catch (Exception e) {
      e.printStackTrace();
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
      if(requestsByAppointmentId != null && requestsByAppointmentId.size()>0) {
        request = requestsByAppointmentId.get(0);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    Client user = new Client();
    try {
      user = clientDao.getClientByClientId(apointment.getClientId());
    } catch (SQLException e) {
      e.printStackTrace();
    }
    appointmentDTO.setEmail(user != null ? user.getEmail() : "");
    appointmentDTO.setFirstName(user != null ? user.getFirstName() : "");
    appointmentDTO.setLastName(user != null ? user.getLastName() : "");
    appointmentDTO.setPhoneNumber(user != null ? user.getPhoneNumber() : "");
    appointmentDTO.setState(request != null ? request.getState() : RequestState.PENDING);
    appointmentDTO.setTimeslot(timeslot);
    return appointmentDTO;
  }

  /**
   * 1. Create a Client
   * 2. Create an Appointment
   * 3. Create a Request(Status : PENDING)
   * @param req
   * @param resp
   */
  private void addAppointment(HttpServletRequest req, HttpServletResponse resp) {

  }
  private void addTimeSlot(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException, ParseException {
    String startDate = req.getParameter("startDate");
    String endDate = req.getParameter("endDate");
    Timeslot timeslot = new Timeslot();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    timeslot.setStartTime(sdf.parse(startDate));
    timeslot.setEndTime(sdf.parse(endDate));
    timeslotDao.insert(timeslot);
  }

  private void addAppo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException, ParseException {
    String clientId = req.getParameter("clientId");
    String timeslotId = req.getParameter("timeslotId");
    Appointment appointment = new Appointment();
    appointment.setClientId(Integer.valueOf(clientId));
    appointment.setTimeslotId(Integer.valueOf(timeslotId));
    appointmentDao.insert(appointment);
  }


  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
