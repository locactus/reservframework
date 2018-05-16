package com.mum.dao;

import com.mum.model.Client;
import java.sql.SQLException;

public interface IClientDao {
    public Client getClientByClientId(int clientId) throws SQLException ;
    public Client getClientByFirstname(String firstname) throws SQLException;
}
