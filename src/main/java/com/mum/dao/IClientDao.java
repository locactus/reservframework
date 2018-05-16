package com.mum.dao;

import com.mum.model.Client;

import java.sql.SQLException;
import java.util.List;

public interface IClientDao {
    public List<Client> getAll() throws SQLException;
    public Client getClientByClientId(int clientId) throws SQLException ;
    public Client getClientByFirstname(String firstname) throws SQLException;
}
