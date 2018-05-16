package com.mum.dao;

import com.mum.model.Request;
import java.sql.SQLException;
import java.util.List;

public interface IRequestDao {
    public List<Request> getAll() throws SQLException;
    public List<Request> getRequestsByAppointmentId(int apotmentId) throws SQLException;
    public int insert(Request request) throws SQLException;
    public boolean delete(int requestId) throws SQLException;
    public boolean update(Request request) throws SQLException;
}
