package com.mum.dao.h2;

import com.mum.dao.IClientDAO;
import com.mum.dao.IVisitor;
import com.mum.model.Client;
import java.sql.SQLException;
import java.util.List;

public class ClientDAOAdaptee extends BaseDAO  {

    public Client getClientByClientId(int clientId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Client getClientByFirstname(String firstname) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int insert(Client client) throws SQLException {
        return 0;
    }

    public List<Client> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean register(Client client) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
