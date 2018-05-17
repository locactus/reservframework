package com.mum.dao;

import com.mum.model.Appointment;

import java.sql.SQLException;
import java.util.List;

public interface IAppointmentDAO extends IDAO {

    List<Appointment> getAll() throws SQLException;
    int insert(Appointment apotment) throws SQLException;
    boolean delete(int apotmentId) throws SQLException;
    List<Appointment> getAppointmentByClientId(int clientId) throws SQLException;
    Appointment getAppointmentById(int apotmentId) throws SQLException;
    Appointment getAppointment(int clientId, int timeslotId) throws SQLException;
}
