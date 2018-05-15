package com.mum.dao;

import com.mum.datasource.DataSource;
import com.mum.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDao {
    public Client getClientByClientId(String clientId) {
        Connection conn = DataSource.getInstance().getConnection();
        Client client = null;
        try {
            String sql = "SELECT * FROM client WHERE clientId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, clientId);
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }
}
