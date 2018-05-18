package com.mum.dao.mysql;

import com.mum.dao.IStaffDAO;
import com.mum.dao.IVisitor;
import com.mum.datasource.DataSource;
import com.mum.model.Staff;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffDAO extends BaseDAO implements IStaffDAO {

    @Override
    public Staff getStaffByStaffId(int staffId) throws SQLException {
        conn = DataSource.getInstance().getConnection();
        Staff staff = null;
        String sql = "SELECT * FROM staff WHERE staffId = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, staffId);
        ResultSet rset = pstmt.executeQuery();

        if(rset.next()) {
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
        }
        rset.close();
        pstmt.close();
        conn.close();
        return staff;
    }

    @Override
    public Staff getStaffByUserName(String userName) throws SQLException {
        conn = DataSource.getInstance().getConnection();
        String sql = "SELECT * FROM staff WHERE userName = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, userName);
        System.out.println(pstmt);
        ResultSet rset = pstmt.executeQuery();
        Staff staff = null;
        if (rset.next()) {
            String firstName = rset.getString("firstname");
            String lastName = rset.getString("lastname");
            String phoneNumber = rset.getString("phonenumber");
            String email = rset.getString("email");

            staff = new Staff();
            staff.setUserName(userName);
            staff.setFirstName(firstName);
            staff.setLastName(lastName);
            staff.setPhoneNumber(phoneNumber);
            staff.setEmail(email);
        }
        pstmt.close();
        pstmt.close();
        conn.close();
        return staff;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visitStaffDAO(this);
    }

    @Override
    public String getLastExecutedStatement() {
        return null;
    }
}
