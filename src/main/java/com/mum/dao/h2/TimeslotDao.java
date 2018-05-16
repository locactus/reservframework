package com.mum.dao.h2;

import com.mum.dao.ITimeslotDao;
import com.mum.model.Timeslot;
import java.sql.SQLException;
import java.util.List;

public class TimeslotDao extends BaseDao implements ITimeslotDao {

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
}
