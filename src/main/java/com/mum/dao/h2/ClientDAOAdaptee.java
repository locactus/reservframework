package com.mum.dao.h2;

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

    /**
     * Insert a new client to db
     * @param client
     * @return
     */
    public boolean register(Client client) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
