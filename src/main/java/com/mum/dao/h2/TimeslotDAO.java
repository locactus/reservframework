package com.mum.dao.h2;

import com.mum.dao.ITimeslotDAO;
import com.mum.dao.IVisitor;
import com.mum.model.Timeslot;
import java.sql.SQLException;
import java.util.List;

public class TimeslotDAO extends BaseDAO implements ITimeslotDAO {

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
    public Timeslot getByTimeslotId(int timeslotId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visitTimeslotDAO(this);
    }

    @Override
    public String getLastExecutedStatement() {
        return null;
    }

    // @Override
    // public Timeslot getByUuid(String uuid) throws SQLException {
    //     throw new UnsupportedOperationException("Not supported yet.");
    // }
}
