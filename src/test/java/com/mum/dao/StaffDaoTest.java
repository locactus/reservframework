package com.mum.dao;

import com.mum.model.Staff;
import org.junit.Test;

import static org.junit.Assert.*;

public class StaffDaoTest {

    @Test
    public void getStaffByStaffId() {
        StaffDao dao = new StaffDao();
        Staff staff = dao.getStaffByStaffId("1001");
        assertTrue(staff.getFirstName().equals("Carl"));
    }
}