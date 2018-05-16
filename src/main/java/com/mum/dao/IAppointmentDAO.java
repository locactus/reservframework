package com.mum.dao;

import com.mum.model.Appointment;

import java.sql.SQLException;
import java.util.List;

public interface IAppointmentDAO {

    List<Appointment> getAll() throws SQLException;
    int insert(Appointment apotment) throws SQLException;
    boolean delete(int apotmentId) throws SQLException;
    List<Appointment> getAppointmentByClientId(int clientId) throws SQLException;
    Appointment getAppointmentById(int apotmentId) throws SQLException;
}
