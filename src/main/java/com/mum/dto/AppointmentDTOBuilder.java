package com.mum.dto;

import com.mum.dao.DataAccessFactory;
import com.mum.dao.IRequestDAO;
import com.mum.model.Appointment;
import com.mum.model.Client;
import com.mum.model.Request;
import com.mum.model.Timeslot;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

public class AppointmentDTOBuilder implements IBuilder {

    private Appointment appointment = null;
    private AppointmentDTO appointmentDTO = null;

    public AppointmentDTOBuilder(Appointment appointment) {
        this.appointment = appointment;
        appointmentDTO = new AppointmentDTO();
    }

    @Override
    public void buildParts() {
        try {
            this.buildAppointment();
            this.buildTimeslot();
            this.buildUser();
            this.buildRequest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void buildAppointment() {
        appointmentDTO.setAppointmentId(appointment.getAppointmentId());
    }

    private void buildTimeslot() throws IllegalAccessException, InstantiationException, ClassNotFoundException, SQLException {
        Timeslot timeslot = DataAccessFactory.createTimeslotDao().getByTimeslotId(this.appointment.getTimeslotId());
        appointmentDTO.setTimeslot(timeslot);
        appointmentDTO.setTimeslotId(timeslot.getTimeslotId());
    }

    private void buildUser() throws IllegalAccessException, InstantiationException, ClassNotFoundException, SQLException {
        Client client = DataAccessFactory.createClientDao().getClientByClientId(this.appointment.getClientId());
        appointmentDTO.setEmail(client != null ? client.getEmail() : "");
        appointmentDTO.setFirstName(client != null ? client.getFirstName() : "");
        appointmentDTO.setLastName(client != null ? client.getLastName() : "");
        appointmentDTO.setPhoneNumber(client != null ? client.getPhoneNumber() : "");
        appointmentDTO.setClientId(client.getClientId());
    }

    private void buildRequest() throws IllegalAccessException, InstantiationException, ClassNotFoundException, SQLException {
        IRequestDAO dao = DataAccessFactory.createRequestDao();
        List<Request> requests = dao.getRequestsByAppointmentId(this.appointment.getAppointmentId());

        if (!requests.isEmpty()) {
            requests.sort(Comparator.comparing(Request::getDatetimeCreated));
            Request request = requests.get(0);
            appointmentDTO.setState(request.getState());
        }
    }
    public AppointmentDTO get() {
        return this.appointmentDTO;
    }
}
