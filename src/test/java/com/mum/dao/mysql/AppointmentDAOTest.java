package com.mum.dao.mysql;

import com.mum.dao.DataAccessFactory;
import com.mum.dao.IAppointmentDAO;
import com.mum.model.Appointment;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class AppointmentDAOTest {
    IAppointmentDAO dao = null;

    public AppointmentDAOTest() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
//        dao = new AppointmentDAO();
        dao = DataAccessFactory.createAppointmentDao();
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
    public void select() {
        try {
            List<Appointment> appointmentByClientId = dao.getAppointmentByClientId(2001);
            for (Appointment appointment : appointmentByClientId) {
                System.out.println(appointment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAll() {
        try {
            List<Appointment> result = dao.getAll();
            for (Appointment appointment : result) {
                System.out.println(appointment);
            }
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

    @Test
    public void getAppointmentByAppointmentId() {
        try {
            Appointment apotment = new Appointment();
            apotment.setClientId(2001);
            apotment.setTimeslotId(3001);
            int appointmentId = dao.insert(apotment);
            Appointment appointment = dao.getAppointmentById(appointmentId);
            System.out.println(appointment);
            dao.delete(appointmentId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}