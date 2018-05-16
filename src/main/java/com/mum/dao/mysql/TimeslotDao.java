package com.mum.dao.mysql;

import com.mum.dao.ITimeslotDao;
import com.mum.datasource.DataSource;
import com.mum.model.Timeslot;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TimeslotDao extends BaseDao implements ITimeslotDao {

    @Override
    public List<Timeslot> getAll() throws SQLException {
        List<Timeslot> result = null;
        super.conn = DataSource.getInstance().getConnection();
        String sql = "SELECT * FROM timeslot";
        PreparedStatement pstmt = super.conn.prepareStatement(sql);
        ResultSet rset = pstmt.executeQuery();
        int numcols = rset.getMetaData().getColumnCount();

        if (!rset.isBeforeFirst()) {
            // Empty table
            return null;
        }

        result = new ArrayList<>();

        while (rset.next()) {
            int timeslotId = rset.getInt("timeslotId");
            Date startTime = new Date(rset.getTimestamp("starttime").getTime());
            Date endTime = new Date(rset.getTimestamp("endtime").getTime());

            Timeslot timeslot = new Timeslot();
            timeslot.setTimeslotId(timeslotId);
            timeslot.setStartTime(startTime);
            timeslot.setEndTime(endTime);

            result.add(timeslot);
        }

        return result;
    }

    @Override
    public int insert(Timeslot timeslot) throws SQLException {
        conn = DataSource.getInstance().getConnection();
        String sql = "INSERT INTO timeslot(starttime, endtime) VALUES(?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstmt.setDate(1, new java.sql.Date(timeslot.getStartTime().getTime()));
        pstmt.setDate(2, new java.sql.Date(timeslot.getEndTime().getTime()));
        System.out.println(pstmt);
        pstmt.executeUpdate();
        ResultSet keys = pstmt.getGeneratedKeys();
        keys.next();
        int timeslotId = keys.getInt(1);
        conn.close();
        return timeslotId;
    }

    @Override
    public boolean delete(int timeslotId) throws SQLException {
        conn = DataSource.getInstance().getConnection();
        String sql = "DELETE FROM timeslot WHERE timeslotId = ? ";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, timeslotId);
        System.out.println(pstmt);
        pstmt.executeUpdate();
        conn.close();
        return true;
    }
}
