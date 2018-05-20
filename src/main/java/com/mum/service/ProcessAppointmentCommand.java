package com.mum.service;


import com.mum.model.Request;

import java.sql.SQLException;

public class ProcessAppointmentCommand extends RequestCommand {
    private int appointmentId;

    public ProcessAppointmentCommand(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    @Override
    public void execute() throws SQLException {
        Request request = requestDao.getLatestRequestByAppointmentId(appointmentId);
        request.processing(); // change the state automatically
        this.requestDao.insert(request);
    }
}
