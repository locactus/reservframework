package com.mum.dao.mysql;

import com.mum.dao.IClientDAO;
import com.mum.datasource.DataSource;
import com.mum.model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO extends BaseDAO implements IClientDAO {


    @Override
    public List<Client> getAll() throws SQLException {
        List<Client> result = null;

        String sql = "select * from client ";
        conn = DataSource.getInstance().getConnection();
        Statement pstmt = super.conn.createStatement();
        ResultSet rset = pstmt.executeQuery(sql);
        int numcols = rset.getMetaData().getColumnCount();

            if (!rset.isBeforeFirst()) {
            // Empty table
            return null;
        }

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
        ResultSet rset = pstmt.executeQuery();
        int numcols = rset.getMetaData().getColumnCount();

        if (!rset.isBeforeFirst()) {
            // Empty table
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
        super.conn.close();
        return client;
    }

    @Override
    public Client getClientByFirstname(String firstname) throws SQLException {
        Connection conn = DataSource.getInstance().getConnection();
        Client client = null;
        String sql = "SELECT * FROM client WHERE firstname = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, firstname);
        ResultSet rset = pstmt.executeQuery();
        int numcols = rset.getMetaData().getColumnCount();

        if (!rset.isBeforeFirst()) {
            // Empty table
            return null;
        }

        rset.next();
        String lastName = rset.getString("lastname");
        String phoneNumber = rset.getString("phonenumber");
        String email = rset.getString("email");

        client = new Client();
        client.setFirstName(firstname);
        client.setLastName(lastName);
        client.setPhoneNumber(phoneNumber);
        client.setEmail(email);
        return client;
    }
}
