package com.mum.dao.mysql;

import com.mum.dao.IAppointmentDAO;
import com.mum.dao.visitor.IVisitor;
import com.mum.datasource.DataSource;
import com.mum.model.Appointment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO extends BaseDAO implements IAppointmentDAO {

    private List<Appointment> _get(String sql) throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Appointment> getAll() throws SQLException {
        return this._get("SELECT * FROM appointment");
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

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getLastExecutedStatement() {
        return this.lastExecutedStatement;
    }
}
