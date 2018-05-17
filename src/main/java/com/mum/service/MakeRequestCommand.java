package com.mum.service;

import com.mum.model.Appointment;
import com.mum.model.Request;
import com.mum.model.enums.RequestState;
import com.mum.model.enums.RequestType;

import java.sql.SQLException;

public class MakeRequestCommand extends RequestCommand {
    private Appointment appointment;

    public MakeRequestCommand(Appointment appointment) {
        this.appointment = appointment;
    }

    @Override
    public void execute() throws SQLException {
        Request request = new Request();
        request.setAppointmentId(appointment.getAppointmentId());
        request.setState(RequestState.PENDING);
        request.setType(RequestType.MAKE);
        this.requestDao.insert(request);
    }
}
