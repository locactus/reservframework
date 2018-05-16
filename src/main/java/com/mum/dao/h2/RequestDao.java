package com.mum.dao.h2;

import com.mum.dao.IRequestDao;
import com.mum.model.Request;
import java.sql.SQLException;
import java.util.List;

public class RequestDao extends BaseDao implements IRequestDao {

    private List<Request> _get(String sql) throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Request> getAll() throws SQLException {
        return this._get("SELECT * FROM request");
    }

    @Override
    public List<Request> getRequestsByAppointmentId(int apotmentId) throws SQLException {
        return this._get("SELECT * FROM request WHERE appointmentId = " + apotmentId);
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
}
