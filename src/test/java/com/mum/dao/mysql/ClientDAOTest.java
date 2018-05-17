package com.mum.dao.mysql;

import com.mum.dao.DataAccessFactory;
import com.mum.dao.IClientDAO;
import com.mum.model.Client;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class ClientDAOTest {
    IClientDAO dao = null;

    public ClientDAOTest() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        dao = DataAccessFactory.createClientDao();
    }

    @Test
    public void getClientByClientId() {
        Client client = null;
        try {
            client = dao.getClientByClientId(2001);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertTrue(client.getFirstName().equals("Eleven"));
    }
}