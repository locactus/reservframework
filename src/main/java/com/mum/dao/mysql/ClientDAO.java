package com.mum.dao.mysql;

import com.mum.dao.IClientDAO;
import com.mum.dao.IVisitor;
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
        //
        String sql = "select * from client";
        Map<Integer, Object> params = new HashMap<>();
        return getClientList(sql, params);
    }

    /**
     * Fetch a specific client from the db witch matching the provide clientId
     * @param clientId
     * @return
     * @throws SQLException
     */
    @Override
    public Client getClientByClientId(int clientId) throws SQLException {
        String sql = "SELECT * FROM client WHERE clientId = ?";
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, clientId);
        return getClient(sql, params);
    }

    /**
     * Fetch a specific client from the db witch matching the provide firstName
     * @param firstname
     * @return
     * @throws SQLException
     */
    @Override
    public Client getClientByFirstname(String firstname) throws SQLException {
        String sql = "SELECT * FROM client WHERE firstname = ?";
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, firstname);
        return getClient(sql, params);
    }

    @Override
    public boolean addClient(Client client) throws SQLException {
        Connection conn = DataSource.getInstance().getConnection();
        String sql = "insert into client(firstname, lastname, phonenumber, email) values(?, ?, ?, ?)";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            pstmt.setString(1, client.getFirstName());
            pstmt.setString(2, client.getLastName());
            pstmt.setString(3, client.getPhoneNumber());
            pstmt.setString(4, client.getEmail());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            this.lastExecutedStatement = pstmt.toString();
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn.close();
        return true;

    }

    public int insert(Client client) throws SQLException {
        conn = DataSource.getInstance().getConnection();
        String sql = "INSERT INTO client(firstname, lastname, phonenumber, email) VALUES(?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, client.getFirstName());
        pstmt.setString(2, client.getLastName());
        pstmt.setString(3, client.getPhoneNumber());
        pstmt.setString(4, client.getEmail());
        pstmt.executeUpdate();
        this.lastExecutedStatement = pstmt.toString();
        ResultSet keys = pstmt.getGeneratedKeys();
        keys.next();
        int clientId = keys.getInt(1);
        conn.close();
        pstmt.close();
        keys.close();
        return clientId;
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

        int clientId = rset.getInt("clientId");
        String firstname = rset.getString("firstname");
        String lastName = rset.getString("lastname");
        String phoneNumber = rset.getString("phonenumber");
        String email = rset.getString("email");

        Client client = new Client();
        client.setFirstName(firstname);
        client.setLastName(lastName);
        client.setPhoneNumber(phoneNumber);
        client.setEmail(email);
        client.setClientId(clientId);
        return client;
    }
}
