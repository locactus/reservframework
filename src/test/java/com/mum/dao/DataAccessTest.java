package com.mum.dao;

import org.junit.Test;

import static org.junit.Assert.*;

public class DataAccessTest {


    @Test
    public void createAppointmentDao() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        DataAccessContext da = new DataAccessContext();
        IStrategy h2Strategy = new H2Strategy();
        da.setStragegy(h2Strategy);
        IAppointmentDAO appointmentDao = da.createAppointmentDao();
        System.out.println(appointmentDao.getClass().getName());
        assertTrue(appointmentDao.getClass().getName().equals("com.mum.dao.h2.AppointmentDAO"));

        IStrategy mysqlStrategy = new MySQLStrategy();
        da.setStragegy(mysqlStrategy);
        appointmentDao = da.createAppointmentDao();
        assertTrue(appointmentDao.getClass().getName().equals("com.mum.dao.mysql.AppointmentDAO"));

    }
}