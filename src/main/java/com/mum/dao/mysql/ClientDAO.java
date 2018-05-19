package com.mum.dao.mysql;

import com.mum.dao.IClientDAO;
import com.mum.dao.IVisitor;
import com.mum.datasource.DataSource;
import com.mum.model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO extends BaseDAO implements IClientDAO {


    @Override
    public List<Client> getAll() throws SQLException {
        List<Client> result = null;

        String sql = "select * from client";
        conn = DataSource.getInstance().getConnection();
        Statement pstmt = super.conn.createStatement();
        this.lastExecutedStatement = pstmt.toString();
        ResultSet rset = pstmt.executeQuery(sql);

        result = new ArrayList<>();

        while (rset.next()) {
            int clientId = rset.getInt("clientId");
            String firstName = rset.getString("firstName");
            String lastName = rset.getString("lastName");
            String phoneNumber = rset.getString("phoneNumber");
            String email = rset.getString("email");


            Client client = new Client();
            client.setClientId(clientId);
            client.setFirstName(firstName);
            client.setLastName(lastName);
            client.setPhoneNumber(phoneNumber);
            client.setEmail(email);

            result.add(client);
        }
        rset.close();
        pstmt.close();
        conn.close();
        return result;
    }

    @Override
    public Client getClientByClientId(int clientId) throws SQLException {
        Client client = null;
        String sql = "SELECT * FROM client WHERE clientId = ?";
        super.conn = DataSource.getInstance().getConnection();
        PreparedStatement pstmt = super.conn.prepareStatement(sql);
        pstmt.setInt(1, clientId);
        this.lastExecutedStatement = pstmt.toString();
        ResultSet rset = pstmt.executeQuery();

        if (!rset.isBeforeFirst()) {
            // Empty table
            rset.close();
            pstmt.close();
            conn.close();
            return null;
        }
        rset.next();
        String firstName = rset.getString("firstname");
        String lastName = rset.getString("lastname");
        String phoneNumber = rset.getString("phonenumber");
        String email = rset.getString("email");

        client = new Client();
        client.setClientId(clientId);
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setPhoneNumber(phoneNumber);
        client.setEmail(email);
        rset.close();
        pstmt.close();
        conn.close();
        return client;
    }

    @Override
    public Client getClientByFirstname(String firstname) throws SQLException {
        Connection conn = DataSource.getInstance().getConnection();
        Client client = null;
        String sql = "SELECT * FROM client WHERE firstname = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, firstname);
        this.lastExecutedStatement = pstmt.toString();
        ResultSet rset = pstmt.executeQuery();

        if(rset.next()) {
            String lastName = rset.getString("lastname");
            String phoneNumber = rset.getString("phonenumber");
            String email = rset.getString("email");
            int clientId = rset.getInt("clientId");

            client = new Client();
            client.setFirstName(firstname);
            client.setLastName(lastName);
            client.setPhoneNumber(phoneNumber);
            client.setEmail(email);
            client.setClientId(clientId);
        }

        rset.close();
        pstmt.close();
        conn.close();
        return client;
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
}
