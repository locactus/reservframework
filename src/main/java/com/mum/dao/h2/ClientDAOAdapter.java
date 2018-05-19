package com.mum.dao.h2;

import com.mum.dao.IClientDAO;
import com.mum.dao.visitor.IVisitor;
import com.mum.model.Client;

import java.sql.SQLException;
import java.util.List;

/**
 * Adapter Pattern for h2.ClientDAOAdaptee class.
 */
public class ClientDAOAdapter implements IClientDAO {
    private ClientDAOAdaptee dao;

    public ClientDAOAdapter() {
        dao = new ClientDAOAdaptee();
    }

    @Override
    public List<Client> getAll() throws SQLException {
        return dao.getAll();
    }

    @Override
    public Client getClientByClientId(int clientId) throws SQLException {
        return dao.getClientByClientId(clientId);
    }

    @Override
    public Client getClientByFirstname(String firstname) throws SQLException {
        return dao.getClientByFirstname(firstname);
    }

    /**
     * Adapt the register() method to addClient() method
     * @param client
     * @return
     * @throws SQLException
     */
    @Override
    public boolean addClient(Client client) throws SQLException {
        return dao.register(client);
    }

    @Override
    public int insert(Client client) throws SQLException {
        return dao.insert(client);
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getLastExecutedStatement() {
        return this.getLastExecutedStatement();
    }
}
