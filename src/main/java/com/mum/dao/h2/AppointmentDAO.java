package com.mum.dao.h2;

import com.mum.dao.IAppointmentDAO;
import com.mum.model.Appointment;
import java.sql.SQLException;
import java.util.List;

public class AppointmentDAO extends BaseDAO implements IAppointmentDAO {

    @Override
    public List<Appointment> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int insert(Appointment apotment) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean delete(int apotmentId) throws SQLException  {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Appointment> getAppointmentByClientId(int clientId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Appointment getAppointmentById(int apotmentId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Appointment getAppointment(int clientId, int timeslotId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
