package com.mum.dao.mysql;

import com.mum.dao.IRequestDAO;
import com.mum.dao.visitor.IVisitor;
import com.mum.datasource.DataSource;
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

public class RequestDAO extends BaseDAO implements IRequestDAO {

    private List<Request> _get(String sql) throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Request> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //Get the latest request object
    @Override
    public List<Request> getRequestsByAppointmentId(int apotmentId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Request getLatestRequestByAppointmentId(int appointmentId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int insert(Request request) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean delete(int requestId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean update(Request request) throws SQLException {
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
