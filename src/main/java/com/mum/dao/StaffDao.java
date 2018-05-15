package com.mum.dao;

import com.mum.datasource.DataSource;
import com.mum.model.Staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffDao {
    public Staff getStaffByStaffId(String staffId) {
        Connection conn = DataSource.getInstance().getConnection();
        Staff staff = null;
        try {
            String sql = "SELECT * FROM staff WHERE staffId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, staffId);
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

            staff = new Staff();
            staff.setStaffId(staffId);
            staff.setFirstName(firstName);
            staff.setLastName(lastName);
            staff.setPhoneNumber(phoneNumber);
            staff.setEmail(email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return staff;
    }
}
