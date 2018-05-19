package com.mum.dao;
import com.mum.dao.h2.*;
import com.mum.dao.mysql.ClientDAO;

public class H2Strategy implements IStrategy {
    @Override
    public IAppointmentDAO createAppointmentDao() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return new AppointmentDAO();
    }

    @Override
    public IClientDAO createClientDao() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return new ClientDAO();
    }

    @Override
    public IRequestDAO createRequestDao() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return new RequestDAO();
    }

    @Override
    public IStaffDAO createStaffDao() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return new StaffDAO();
    }

    @Override
    public ITimeslotDAO createTimeslotDao() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return new TimeslotDAO();
    }
}
