package com.mum.dao;

import com.mum.dao.mysql.StaffDao;
import com.mum.model.Staff;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class StaffDaoTest {
    IStaffDao dao = null;

    public StaffDaoTest() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        dao = DataAccessFactory.createStaffDao();
    }

    @Test
    public void getStaffByStaffId() {
        IStaffDao dao = new StaffDao();
        Staff staff = null;
        try {
            staff = dao.getStaffByStaffId(1001);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertTrue(staff.getFirstName().equals("Carl"));
    }
}