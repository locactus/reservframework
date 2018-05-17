package com.mum.dao;

import com.mum.model.Request;
import java.sql.SQLException;
import java.util.List;

public interface IRequestDAO extends IDAO {
    List<Request> getAll() throws SQLException;
    List<Request> getRequestsByAppointmentId(int apotmentId) throws SQLException;
    int insert(Request request) throws SQLException;
    boolean delete(int requestId) throws SQLException;
    boolean update(Request request) throws SQLException;
}
