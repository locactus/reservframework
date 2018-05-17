package com.mum.service;


import com.mum.dao.IRequestDAO;
import java.sql.SQLException;

public abstract class RequestCommand {

    protected IRequestDAO requestDao;
    public void setWorker(IRequestDAO requestDao) {
        this.requestDao = requestDao;
    }

    public abstract void execute() throws SQLException;
}
