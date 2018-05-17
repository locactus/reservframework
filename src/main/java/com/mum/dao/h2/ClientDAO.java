package com.mum.dao.h2;

import com.mum.dao.IClientDAO;
import com.mum.model.Client;
import java.sql.SQLException;
import java.util.List;

public class ClientDAO extends BaseDAO implements IClientDAO {

    @Override
    public Client getClientByClientId(int clientId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Client getClientByFirstname(String firstname) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int insert(Client client) throws SQLException {
        return 0;
    }

    @Override
    public List<Client> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
