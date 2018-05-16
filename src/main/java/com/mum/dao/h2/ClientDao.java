package com.mum.dao.h2;

import com.mum.dao.IClientDao;
import com.mum.model.Client;
import java.sql.SQLException;

public class ClientDao extends BaseDao implements IClientDao {

    @Override
    public Client getClientByClientId(int clientId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Client getClientByFirstname(String firstname) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
