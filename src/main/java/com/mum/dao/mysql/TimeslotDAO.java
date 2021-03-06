package com.mum.dao.mysql;

import com.mum.dao.ITimeslotDAO;
import com.mum.dao.visitor.IVisitor;
import com.mum.datasource.DataSource;
import com.mum.model.Timeslot;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TimeslotDAO extends BaseDAO implements ITimeslotDAO {

    public Timeslot getByTimeslotId(int timeslotId) throws SQLException{
        super.conn = DataSource.getInstance().getConnection();
        String sql = "SELECT * FROM timeslot where timeslotId = (?)";
        PreparedStatement pstmt = super.conn.prepareStatement(sql);
        pstmt.setInt(1, timeslotId);
        ResultSet rset = pstmt.executeQuery();
        this.lastExecutedStatement = pstmt.toString();

        Timeslot timeslot = new Timeslot();
        while(rset.next()) {
            Date startTime = new Date(rset.getTimestamp("starttime").getTime());
            Date endTime = new Date(rset.getTimestamp("endtime").getTime());
            timeslot.setTimeslotId(timeslotId);
            timeslot.setStartTime(startTime);
            timeslot.setEndTime(endTime);
        }
        rset.close();
        pstmt.close();
        conn.close();
        return timeslot;
    }

    @Override
    public List<Timeslot> getAll() throws SQLException {
        List<Timeslot> result = null;
        super.conn = DataSource.getInstance().getConnection();
        String sql = "SELECT * FROM timeslot";
        PreparedStatement pstmt = super.conn.prepareStatement(sql);
        ResultSet rset = pstmt.executeQuery();
        this.lastExecutedStatement = pstmt.toString();
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
        rset.close();
        pstmt.close();
        conn.close();
        return result;
    }

    @Override
    public int insert(Timeslot timeslot) throws SQLException {
        conn = DataSource.getInstance().getConnection();
        String sql = "INSERT INTO timeslot(starttime, endtime) VALUES(?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstmt.setTimestamp(1,new Timestamp(timeslot.getStartTime().getTime()));
        pstmt.setTimestamp(2, new Timestamp(timeslot.getEndTime().getTime()));
        // pstmt.setString(3, timeslot.getUuid());
        pstmt.executeUpdate();
        this.lastExecutedStatement = pstmt.toString();
        ResultSet keys = pstmt.getGeneratedKeys();
        int timeslotId = -1;
        if (keys.next())
            timeslotId = keys.getInt(1);
        keys.close();
        pstmt.close();
        conn.close();
        return timeslotId;
    }

    @Override
    public boolean delete(int timeslotId) throws SQLException {
        conn = DataSource.getInstance().getConnection();
        String sql = "DELETE FROM timeslot WHERE timeslotId = ? ";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, timeslotId);
        this.lastExecutedStatement = pstmt.toString();
        pstmt.executeUpdate();
        pstmt.close();
        conn.close();
        return true;
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
