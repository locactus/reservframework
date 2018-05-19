package com.mum.dao.abstractfactory;

import com.mum.dao.IAppointmentDAO;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class AbstractFactoryTest {

    @Test
    public void createAppointmentDao() throws IllegalAccessException, InstantiationException, ClassNotFoundException, SQLException {
        IFactory factory = new MySQLFactory();
        IAppointmentDAO dao = factory.createAppointmentDao();
        assertTrue(!dao.getAll().isEmpty());
    }
}