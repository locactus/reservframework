package com.mum.dao;

import com.mum.model.Staff;
import java.sql.SQLException;

public interface IStaffDao {
    public Staff getStaffByStaffId(int staffId) throws SQLException;
    public Staff getStaffByUserName(String userName) throws SQLException;
}
