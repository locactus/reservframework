package com.mum.dao;

import com.mum.model.Staff;
import java.sql.SQLException;

public interface IStaffDAO extends IDAO {
    Staff getStaffByStaffId(int staffId) throws SQLException;
    Staff getStaffByUserName(String userName) throws SQLException;
}
