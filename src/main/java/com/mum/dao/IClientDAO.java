package com.mum.dao;

import com.mum.model.Client;
import java.sql.SQLException;
import java.util.List;

public interface IClientDAO {
    List<Client> getAll() throws SQLException;
    Client getClientByClientId(int clientId) throws SQLException;
    Client getClientByFirstname(String firstname) throws SQLException;
}
