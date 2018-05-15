package com.mum.dao;

import com.mum.model.Appointment;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class AppointmentDaoTest {

    @Test
    public void insert() {
        Appointment apotment = new Appointment();

    }

    @Test
    public void getAll() {
        List<Appointment> result = null;
        try {
            result = new AppointmentDao().getAll();
            assertTrue(result.isEmpty());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void delete() {
    }

    @Test
    public void getAppointmentByClientId() {
    }

    @Test
    public void getAppointmentById() {
    }
}