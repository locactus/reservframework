package com.mum.dao.mysql;

import com.mum.dao.DataAccessFactory;
import com.mum.dao.ITimeslotDAO;
import com.mum.model.Timeslot;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class TimeslotDAOTest {
    ITimeslotDAO dao = null;

    public TimeslotDAOTest() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        dao = DataAccessFactory.createTimeslotDao();
    }

    @Test
    public void getAll() {
        try {
            List<Timeslot> result = dao.getAll();
            assertTrue(!result.isEmpty());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insert() {
        Timeslot tl = new Timeslot();
        tl.setStartTime(new Date());
        tl.setEndTime(new Date());

        try {
            assertTrue(dao.insert(tl) > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void delete() {
        Timeslot tl = new Timeslot();
        tl.setStartTime(new Date());
        tl.setEndTime(new Date());

        try {
            assertTrue(dao.delete(dao.insert(tl)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getByTimeslotId() {
        Timeslot tl = new Timeslot();
        tl.setStartTime(new Date());
        tl.setEndTime(new Date());

        try {
            int timeslotId = dao.insert(tl);
            Timeslot result = dao.getByTimeslotId(timeslotId);
            assertTrue(result != null);
            assertTrue(result.getTimeslotId() == timeslotId);
            dao.delete(timeslotId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}