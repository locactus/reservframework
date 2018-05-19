package com.mum.dto;

import com.mum.dao.*;
import com.mum.dao.DataAccessFactory;
import com.mum.model.Appointment;
import com.mum.model.Client;
import com.mum.model.Request;
import com.mum.model.Timeslot;
import com.mum.model.enums.RequestState;
import com.mum.model.enums.RequestType;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class BuildDirectorTest {

    @Test
    public void build() throws IllegalAccessException, InstantiationException, ClassNotFoundException, SQLException, InterruptedException {
        IClientDAO clientDao = DataAccessFactory.createClientDao();
        Client client = new Client();
        client.setFirstName("Lily");
        client.setLastName("L");
        client.setPhoneNumber("123-456-7890");
        client.setEmail("lily@gmail.com");
        int clientId = clientDao.insert(client);

        ITimeslotDAO timeslotDao = DataAccessFactory.createTimeslotDao();
        Timeslot tl = new Timeslot();
        tl.setStartTime(new Date());
        tl.setEndTime(new Date());
        int tlId = timeslotDao.insert(tl);

        IAppointmentDAO appointmentDao = DataAccessFactory.createAppointmentDao();
        Appointment appointment = new Appointment();
        appointment.setTimeslotId(tlId);
        appointment.setClientId(clientId);
        int appointmentId = appointmentDao.insert(appointment);
        appointment = appointmentDao.getAppointmentById(appointmentId);

        IRequestDAO requestDao = DataAccessFactory.createRequestDao();
        Request request = new Request();
        request.setType(RequestType.MAKE);
        request.setState(RequestState.PENDING);
        request.setAppointmentId(appointmentId);
        requestDao.insert(request);

        TimeUnit.SECONDS.sleep(1);
        request.setState(RequestState.ACCEPT);
        requestDao.insert(request);

        IBuilder builder = new AppointmentDTOBuilder(appointment);
        BuildDirector director = new BuildDirector(builder);
        director.build();
        AppointmentDTO dto = ((AppointmentDTOBuilder) builder).get();

        assertTrue(dto.getState().equals(RequestState.ACCEPT));
        assertTrue(dto.getTimeslot().getTimeslotId() == tlId);
        assertTrue(dto.getEmail().equals("lily@gmail.com"));
        assertTrue(dto.getPhoneNumber().equals("123-456-7890"));
        assertTrue(dto.getLastName().equals("L"));
        assertTrue(dto.getFirstName().equals("Lily"));
        assertTrue(dto.getClientId() == clientId);
    }
}