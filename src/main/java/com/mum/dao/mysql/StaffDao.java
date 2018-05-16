package com.mum.dao.mysql;

import com.mum.dao.IStaffDao;
import com.mum.datasource.DataSource;
import com.mum.model.Staff;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffDao extends BaseDao implements IStaffDao {

    @Override
    public Staff getStaffByStaffId(int staffId) throws SQLException {
        conn = DataSource.getInstance().getConnection();
        Staff staff = null;
        String sql = "SELECT * FROM staff WHERE staffId = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, staffId);
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
        conn.close();
        return staff;
    }

    @Override
    public Staff getStaffByUserName(String userName) throws SQLException {
        conn = DataSource.getInstance().getConnection();
        String sql = "SELECT * FROM staff WHERE userName = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, userName);
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

        Staff staff = new Staff();
        staff.setUserName(userName);
        staff.setFirstName(firstName);
        staff.setLastName(lastName);
        staff.setPhoneNumber(phoneNumber);
        staff.setEmail(email);
        return staff;
    }
}
