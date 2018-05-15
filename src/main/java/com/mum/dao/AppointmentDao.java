package com.mum.dao;

import com.mum.datasource.DataSource;
import com.mum.model.Appointment;
import com.mum.model.Request;
import com.mum.model.enums.RequestState;
import com.mum.model.enums.RequestType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppointmentDao extends BaseDao {

    private List<Appointment> _get(String sql) throws SQLException{
        List<Appointment> result = null;

        conn = DataSource.getInstance().getConnection();
        Statement pstmt = super.conn.createStatement();
        ResultSet rset = pstmt.executeQuery(sql);
        int numcols = rset.getMetaData().getColumnCount();

        if (!rset.isBeforeFirst()) {
            // Empty table
            return null;
        }

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
        conn.close();
        return result;
    }

    public List<Appointment> getAll() throws SQLException {
        return this._get("SELECT * FROM appointment");
    }

    public int insert(Appointment apotment) throws SQLException {
        conn = DataSource.getInstance().getConnection();
        String sql = "INSERT INTO appointment(timeslotId, clientId) VALUES(?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstmt.setInt(1, apotment.getTimeslotId());
        pstmt.setInt(2, apotment.getClientId());
        System.out.println(pstmt);
        pstmt.executeUpdate();
        ResultSet keys = pstmt.getGeneratedKeys();
        keys.next();
        int apotmentId = keys.getInt(1);
        conn.close();
        return apotmentId;
    }

    public boolean delete(int apotmentId) throws SQLException  {
        conn = DataSource.getInstance().getConnection();
        String sql = "DELETE FROM request WHERE appointmentId = ? ";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, apotmentId);
        System.out.println(pstmt);
        pstmt.executeUpdate();
        conn.close();
        return true;
    }

    public List<Appointment> getAppointmentByClientId(int clientId) throws SQLException {
        return this._get("SELECT * FROM appointment WHERE clientId = " + clientId);
    }

    public Appointment getAppointmentById(int apotmentId) throws SQLException {
        List<Appointment> result = this._get("SELECT * FROM appointment WHERE apointmentId = " + apotmentId);
        if (result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }
}
