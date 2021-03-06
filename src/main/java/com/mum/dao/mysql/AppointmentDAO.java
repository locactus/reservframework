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
        List<Appointment> result = null;

        conn = DataSource.getInstance().getConnection();
        Statement pstmt = super.conn.createStatement();
        ResultSet rset = pstmt.executeQuery(sql);
        this.lastExecutedStatement = pstmt.toString();
        int numcols = rset.getMetaData().getColumnCount();

        result = new ArrayList<>();

        while (rset.next()) {
            int appointmentId = rset.getInt("appointmentId");
            int timeslotId = rset.getInt("timeslotId");
            int clientId = rset.getInt("clientId");

            Appointment apotment = new Appointment();
            apotment.setAppointmentId(appointmentId);
            apotment.setTimeslotId(timeslotId);
            apotment.setClientId(clientId);

            result.add(apotment);
        }
        rset.close();
        pstmt.close();
        conn.close();
        return result;
    }

    @Override
    public List<Appointment> getAll() throws SQLException {
        return this._get("SELECT * FROM appointment");
    }

    @Override
    public int insert(Appointment apotment) throws SQLException {
        int appointmentId = apotment.getAppointmentId();
        int clientId = apotment.getClientId();
        conn = DataSource.getInstance().getConnection();
        String sql = "INSERT INTO appointment(timeslotId, clientId) VALUES(?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstmt.setInt(1, apotment.getTimeslotId());
        pstmt.setInt(2, apotment.getClientId());
        this.lastExecutedStatement = pstmt.toString();
        pstmt.executeUpdate();
        ResultSet keys = pstmt.getGeneratedKeys();
        int apotmentId = -1;
        if (keys.next())
            apotmentId= keys.getInt(1);
        keys.close();
        pstmt.close();
        conn.close();
        return apotmentId;
    }

    @Override
    public boolean delete(int apotmentId) throws SQLException  {
        conn = DataSource.getInstance().getConnection();
        String sql = "DELETE FROM request WHERE appointmentId = ? ";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, apotmentId);
        this.lastExecutedStatement = pstmt.toString();
        pstmt.executeUpdate();
        pstmt.close();
        conn.close();
        return true;
    }

    @Override
    public List<Appointment> getAppointmentByClientId(int clientId) throws SQLException {
        return this._get("SELECT * FROM appointment WHERE clientId = " + clientId);
    }

    @Override
    public Appointment getAppointmentById(int apotmentId) throws SQLException {
        List<Appointment> result = this._get("SELECT * FROM appointment WHERE appointmentId = " + apotmentId);
        if (result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }

    @Override
    public Appointment getAppointment(int clientId, int timeslotId) throws SQLException {
        List<Appointment> result = this._get(String.format("SELECT * FROM appointment WHERE clientId=%s and " +
            "timeslotId=%s", clientId, timeslotId));
        if (result.isEmpty()) {
            return null;
        }
        return result.get(0);
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
