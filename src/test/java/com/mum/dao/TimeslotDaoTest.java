package com.mum.dao;

import com.mum.dao.mysql.TimeslotDao;
import com.mum.model.Timeslot;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class TimeslotDaoTest {
    ITimeslotDao dao = null;

    public TimeslotDaoTest() {
        dao = new TimeslotDao();
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
}