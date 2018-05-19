package com.mum.dto;

import com.mum.com.mum.util.DateUtil;
import com.mum.dao.DataAccessFactory;
import com.mum.dao.IRequestDAO;
import com.mum.dao.*;
import com.mum.dao.visitor.IVisitor;
import com.mum.dao.visitor.StatementLogVisitor;
import com.mum.model.Appointment;
import com.mum.model.Client;
import com.mum.model.Request;
import com.mum.model.Timeslot;

import java.sql.SQLException;

public class AppointmentDTOBuilder implements IBuilder {

    private Appointment appointment = null;
    private AppointmentDTO appointmentDTO = null;

    public AppointmentDTOBuilder(Appointment appointment) {
        this.appointment = appointment;
        appointmentDTO = new AppointmentDTO();
    }

    @Override
    public void buildParts() {
        System.out.println("==================== buildParts() start:");
        try {
            this.buildAppointment();
            this.buildTimeslot();
            this.buildUser();
            this.buildRequest();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("==================== buildParts() end!");
    }

    private void buildAppointment() {
        appointmentDTO.setAppointmentId(appointment.getAppointmentId());
    }

    private void buildTimeslot() throws IllegalAccessException, InstantiationException, ClassNotFoundException, SQLException {
        ITimeslotDAO dao = DataAccessFactory.createTimeslotDao();

        Timeslot timeslot = dao.getByTimeslotId(this.appointment.getTimeslotId());
        // print the log via visitor
        IVisitor statementLogVisitor = new StatementLogVisitor();
        dao.accept(statementLogVisitor);

        appointmentDTO.setTimeslot(timeslot);
        if(null!=timeslot){
            appointmentDTO.setStartTimeStr(DateUtil.getString(timeslot.getStartTime()));
            appointmentDTO.setEndTimeStr(DateUtil.getString(timeslot.getEndTime()));
        }
        appointmentDTO.setTimeslotId(timeslot.getTimeslotId());
    }

    private void buildUser() throws IllegalAccessException, InstantiationException, ClassNotFoundException, SQLException {
        IClientDAO dao = DataAccessFactory.createClientDao();

        Client client = dao.getClientByClientId(this.appointment.getClientId());
        // print the log via visitor
        IVisitor statementLogVisitor = new StatementLogVisitor();
        dao.accept(statementLogVisitor);

        appointmentDTO.setEmail(client != null ? client.getEmail() : "");
        appointmentDTO.setFirstName(client != null ? client.getFirstName() : "");
        appointmentDTO.setLastName(client != null ? client.getLastName() : "");
        appointmentDTO.setPhoneNumber(client != null ? client.getPhoneNumber() : "");
        appointmentDTO.setClientId(client.getClientId());
    }

    private void buildRequest() throws IllegalAccessException, InstantiationException, ClassNotFoundException, SQLException {
        IRequestDAO dao = DataAccessFactory.createRequestDao();

        Request request = dao.getLatestRequestByAppointmentId(this.appointment.getAppointmentId());
        // print the log via visitor
        IVisitor statementLogVisitor = new StatementLogVisitor();
        dao.accept(statementLogVisitor);

        if (request != null) {
            appointmentDTO.setState(request.getState());
        }
    }
    public AppointmentDTO get() {
        return this.appointmentDTO;
    }
}
