package com.mum.dao.mysql;

import com.mum.dao.DataAccessFactory;
import com.mum.dao.IStaffDAO;
import com.mum.model.Staff;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class StaffDAOTest {
    IStaffDAO dao = null;

    public StaffDAOTest() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        dao = DataAccessFactory.createStaffDao();
    }

    @Test
    public void getStaffByStaffId() {
        IStaffDAO dao = new StaffDAO();
        Staff staff = null;
        try {
            staff = dao.getStaffByStaffId(1001);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertTrue(staff.getFirstName().equals("Carl"));
    }
}