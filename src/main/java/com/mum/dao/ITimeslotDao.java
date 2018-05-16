package com.mum.dao;

import com.mum.model.Timeslot;
import java.sql.SQLException;
import java.util.List;

public interface ITimeslotDao {
    public List<Timeslot> getAll() throws SQLException ;
    public int insert(Timeslot timeslot) throws SQLException ;
    public boolean delete(int timeslotId) throws SQLException;
}
