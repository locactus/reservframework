package com.mum.dao;

import com.mum.dao.mysql.ClientDao;
import com.mum.model.Client;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class ClientDaoTest {

    @Test
    public void getClientByClientId() {
        IClientDao dao = new ClientDao();
        Client client = null;
        try {
            client = dao.getClientByClientId(2001);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertTrue(client.getFirstName().equals("Eleven"));
    }
}