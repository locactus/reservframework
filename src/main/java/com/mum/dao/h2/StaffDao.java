package com.mum.dao.h2;

import com.mum.dao.IStaffDao;
import com.mum.model.Staff;
import java.sql.SQLException;

public class StaffDao extends BaseDao implements IStaffDao {

    @Override
    public Staff getStaffByStaffId(int staffId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");

    }

    @Override
    public Staff getStaffByUserName(String userName) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
