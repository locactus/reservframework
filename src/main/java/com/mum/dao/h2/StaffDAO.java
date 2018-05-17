package com.mum.dao.h2;

import com.mum.dao.IStaffDAO;
import com.mum.dao.IVisitor;
import com.mum.model.Staff;
import java.sql.SQLException;

public class StaffDAO extends BaseDAO implements IStaffDAO {

    @Override
    public Staff getStaffByStaffId(int staffId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");

    }

    @Override
    public Staff getStaffByUserName(String userName) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
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
