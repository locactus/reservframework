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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Timeslot> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int insert(Timeslot timeslot) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean delete(int timeslotId) throws SQLException {
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
