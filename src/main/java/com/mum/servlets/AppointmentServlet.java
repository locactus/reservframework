package com.mum.servlets;

import com.google.gson.Gson;
import com.mum.dao.DataAccessFactory;
import com.mum.dto.AppointmentDTO;
import com.mum.model.Appointment;
import com.mum.model.Client;
import com.mum.model.Request;
import com.mum.model.Timeslot;
import com.mum.model.enums.RequestState;
import com.mum.model.enums.UserType;
import com.mum.pattern.flyweight.ClientFactory;
import com.mum.pattern.memento.CareTaker;
import com.mum.pattern.memento.Memento;
import com.mum.pattern.memento.ProcessState;
import com.mum.service.MakeRequestCommand;
import com.mum.service.ProcessAppointmentCommand;
import com.mum.service.RequestCommand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = "/appointment")
public class AppointmentServlet extends BaseTemplate {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
    try {
      String action = req.getParameter("action");
      if (action.equals("add")) {
        addAppointment(req, resp);
      } else if (action.equals("listofUser")) {
        listAllAppointment(req, resp);
      }else if (action.equals("list")) {
        listAdminAppointment(req, resp);
      } else if (action.equals("confirm")) {
        confirmAppointment(req, resp);
      } else if (action.equals("toaddtimeslot")) {
        req.getRequestDispatcher(req.getContextPath() + "/createTimeslot.jsp").forward(req, resp);
      } else if (action.equals("addtimeslot")) {
        addTimeSlot(req, resp);
        resp.sendRedirect(req.getContextPath() + "/appointment/list");
      } else if (action.equals("toaddAppo")) {
        req.getRequestDispatcher(req.getContextPath() + "/createAppo.jsp").forward(req, resp);
      } else if (action.equals("getList")) {
        this.getList(req,resp);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void confirmAppointment(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException {

    // Request request = new Request();
    // request.setAppointmentId(Integer.valueOf(req.getParameter("appointmentId")));
    // request.setType(RequestType.MAKE);
    // request.setState(RequestState.ACCEPT);
    // request.setDatetimeCreated(new Date());
    // requestDao.insert(request);
    ProcessAppointmentCommand cmd = new ProcessAppointmentCommand(Integer.valueOf(req.getParameter("appointmentId")));
    cmd.setWorker(DataAccessFactory.createRequestDao());
    cmd.execute();

    revitQueryCache.invalidate("appoCache");
    resp.sendRedirect(req.getContextPath() + "/appointment?action=list");

  }



  private void listAllAppointment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
    req.getRequestDispatcher(req.getContextPath() + "/appoList.jsp").forward(req, resp);
  }

  private void listAdminAppointment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
    req.getRequestDispatcher(req.getContextPath() + "/reserveList.jsp").forward(req, resp);
  }

  private void getList(HttpServletRequest req, HttpServletResponse resp) throws Exception {
    List<AppointmentDTO> list =
    this.getAllByProxy();
    Gson gson = new Gson();
    String json = gson.toJson(list);
    System.out.println(json);
    resp.getWriter().print(json);
    resp.flushBuffer();
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
    CareTaker careTaker = new CareTaker();
    String firstName = req.getParameter("firstName");
    String lastName = req.getParameter("lastName");
    String phoneNumber = req.getParameter("phoneNumber");
    String email = req.getParameter("email");
    String startDate = req.getParameter("startDate");
    String endDate = req.getParameter("endDate");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Timeslot timeslot = null;
    // String uuid = UUID.randomUUID().toString();
    int timeslotId = -1;
    try {
      timeslot = new Timeslot(sdf.parse(startDate), sdf.parse(endDate));

      // timeslot.setUuid(uuid);
      timeslotId = timeslotDao.insert(timeslot);
      careTaker.add(new Memento("timeslot", ProcessState.NEWTIMESLOT, timeslotId));
    } catch (ParseException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    try {
      Client clientByFirstname = clientDao.getClientByFirstname(firstName);
      if(clientByFirstname != null) {
      } else {
//        Client temp = new Client(firstName, lastName, phoneNumber, email);
        synchronized (this) {//
          Client client = (Client)ClientFactory.getUser(UserType.CLIENT);
          client.setFirstName(firstName);
          client.setLastName(lastName);
          client.setPhoneNumber(phoneNumber);
          client.setEmail(email);
          clientDao.addClient(client);
          clientByFirstname = client;
        }
      }
      careTaker.add(new Memento("newclient", ProcessState.NEWCLIENT, clientByFirstname.getClientId()));

      // Timeslot tl = timeslotDao.getByUuid(uuid);
      Timeslot tl = timeslotDao.getByTimeslotId(timeslotId);
      Client byFirstname = clientDao.getClientByFirstname(firstName);
      Appointment appointment = new Appointment(tl.getTimeslotId(), byFirstname.getClientId());

      int apointmentId = appointmentDao.insert(appointment);
      careTaker.add(new Memento("newappointment", ProcessState.NEWAPPOINTMENT, apointmentId));

      RequestCommand cmd = new MakeRequestCommand(appointmentDao.getAppointmentById(apointmentId));
      cmd.setWorker(requestDao);
      cmd.execute();

      if(!isValidState(careTaker)) {
        rollbackData(careTaker);
      }
      revitQueryCache.invalidate("appoCache");
      resp.sendRedirect(req.getContextPath() + "/appointment?action=listofUser");
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  //When there is something wrong, rollback the timeslot, appointment, leave it stable for client.
  private void rollbackData(CareTaker careTaker) {
    List<Memento> mementoList = careTaker.getMementoList();
    for (Memento memento : mementoList) {
      if(memento.getProcessState().equals(ProcessState.NEWTIMESLOT)) {
        try {
          timeslotDao.delete(memento.getBusinessId());
        } catch (SQLException e) {
          e.printStackTrace();
        }
      } else if(memento.getProcessState().equals(ProcessState.NEWAPPOINTMENT)) {
        try {
          appointmentDao.delete(memento.getBusinessId());
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
  }

  //status validation
  private boolean isValidState(CareTaker careTaker) {
    return careTaker.getMementoList().size() == 3;
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

  private List<AppointmentDTO> getAllByProxy() throws Exception {
    return revitQueryCache.get("appoCache");
}








}
