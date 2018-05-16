package com.mum.dao;

import com.mum.model.Staff;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class StaffDaoTest {

    @Test
    public void getStaffByStaffId() {
        StaffDao dao = new StaffDao();
        Staff staff = null;
        try {
            staff = dao.getStaffByStaffId(1001);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertTrue(staff.getFirstName().equals("Carl"));
    }
}