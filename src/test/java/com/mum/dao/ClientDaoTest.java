package com.mum.dao;

import com.mum.model.Client;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientDaoTest {

    @Test
    public void getClientByClientId() {
        ClientDao dao = new ClientDao();
        Client client = dao.getClientByClientId("2001");
        assertTrue(client.getFirstName().equals("Eleven"));
    }
}