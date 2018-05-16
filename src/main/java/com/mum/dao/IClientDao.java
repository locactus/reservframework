package com.mum.dao;

import com.mum.model.Client;
import java.sql.SQLException;

public interface IClientDAO {
    Client getClientByClientId(int clientId) throws SQLException ;
    Client getClientByFirstname(String firstname) throws SQLException;
}
