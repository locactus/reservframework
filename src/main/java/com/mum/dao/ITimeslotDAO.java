package com.mum.dao;

import com.mum.model.Timeslot;
import java.sql.SQLException;
import java.util.List;

public interface ITimeslotDAO {
    List<Timeslot> getAll() throws SQLException ;
    int insert(Timeslot timeslot) throws SQLException ;
    boolean delete(int timeslotId) throws SQLException;
    Timeslot getByTimeslotId(int timeslotId) throws SQLException;
    Timeslot getByUuid(String uuid) throws SQLException;
}
