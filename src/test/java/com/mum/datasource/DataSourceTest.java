package com.mum.datasource;

import org.junit.Test;

import java.sql.*;

import static org.junit.Assert.*;

public class DataSourceTest {

    @Test
    public void getInstance() {
        Connection conn  = DataSource.getInstance().getConnection();
        if (conn == null) {
            assertTrue(false);
            return;
        }
        try {
            String sql = "SELECT * FROM client";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rset = stmt.executeQuery();
            int numcols = rset.getMetaData().getColumnCount();

            if (!rset.isBeforeFirst()) {
                // Empty table
                assertTrue(numcols == 0);
            }

            rset.next();
            String firstName = rset.getString("firstname");
            assertTrue(firstName.equals("Eleven"));
            assertTrue(numcols > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}