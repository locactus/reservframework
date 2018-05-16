package com.mum.dao;

import com.mum.model.Appointment;

import java.sql.SQLException;
import java.util.List;

public interface IAppointmentDao {

    public List<Appointment> getAll() throws SQLException;
    public int insert(Appointment apotment) throws SQLException;
    public boolean delete(int apotmentId) throws SQLException;
    public List<Appointment> getAppointmentByClientId(int clientId) throws SQLException;
    public Appointment getAppointmentById(int apotmentId) throws SQLException;
}
