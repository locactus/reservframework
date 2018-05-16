package com.mum.dao.mysql;

import com.mum.dao.IAppointmentDAO;
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

    @Override
    public List<Appointment> getAll() throws SQLException {
        return this._get("SELECT * FROM appointment");
    }

    @Override
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
        System.out.println("new apotmentId = " + apotmentId);
        return apotmentId;
    }

    @Override
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
}
