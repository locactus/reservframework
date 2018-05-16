package com.mum.dao;

import com.mum.dao.mysql.AppointmentDao;
import com.mum.model.Appointment;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class AppointmentDaoTest {
    IAppointmentDao dao = null;

    public AppointmentDaoTest() {
//        dao = new AppointmentDao();
        dao = DataAccess.createAppointmentDao();
    }


    @Test
    public void insert() {
        Appointment apotment = new Appointment();
        apotment.setClientId(2001);
        apotment.setTimeslotId(3001);
        try {
            assertTrue(dao.insert(apotment) > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getAll() {
        try {
            List<Appointment> result = dao.getAll();
            assertTrue(!result.isEmpty());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void delete() {
        Appointment apotment = new Appointment();
        apotment.setClientId(2001);
        apotment.setTimeslotId(3001);
        try {
            int newApotmentId = dao.insert(apotment);
            assertTrue(dao.delete(newApotmentId));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAppointmentByClientId() {
        Appointment apotment = new Appointment();
        int clientId = 2001;
        apotment.setClientId(clientId);
        apotment.setTimeslotId(3001);
        try {
            assertTrue(dao.getAppointmentByClientId(clientId) != null && !dao.getAppointmentByClientId(clientId).isEmpty());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAppointmentById() {
        Appointment apotment = new Appointment();
        apotment.setClientId(2001);
        apotment.setTimeslotId(3001);
        try {
            int newApotmentId = dao.insert(apotment);
            assertTrue(dao.getAppointmentById(newApotmentId) != null && dao.getAppointmentById(newApotmentId).getAppointmentId() == newApotmentId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}