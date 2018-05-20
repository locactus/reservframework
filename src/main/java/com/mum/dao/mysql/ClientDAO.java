package com.mum.dao.mysql;

import com.mum.dao.IClientDAO;
import com.mum.dao.visitor.IVisitor;
import com.mum.datasource.DataSource;
import com.mum.model.Client;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientDAO extends ClientDAOTemplate implements IClientDAO {

    /**
     * Fetch all the clients from the db
     * @return
     * @throws SQLException
     */
    @Override
    public List<Client> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Fetch a specific client from the db witch matching the provide clientId
     * @param clientId
     * @return
     * @throws SQLException
     */
    @Override
    public Client getClientByClientId(int clientId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Fetch a specific client from the db witch matching the provide firstName
     * @param firstname
     * @return
     * @throws SQLException
     */
    @Override
    public Client getClientByFirstname(String firstname) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean addClient(Client client) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");

    }

    public int insert(Client client) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getLastExecutedStatement() {
        return this.lastExecutedStatement;
    }

    @Override
    protected Client buildClient(ResultSet rset) throws SQLException {

        throw new UnsupportedOperationException("Not supported yet.");
    }
}
