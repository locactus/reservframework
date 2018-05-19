package com.mum.dao;

public class DataAccessContext {
    private IStrategy strategy;
    public void setStragegy(IStrategy strategy) {
        this.strategy = strategy;
    }

    public IAppointmentDAO createAppointmentDao() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return strategy.createAppointmentDao();
    }

    public IClientDAO createClientDao() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return strategy.createClientDao();
    }

    public IRequestDAO createRequestDao() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return strategy.createRequestDao();
    }

    public IStaffDAO createStaffDao() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return strategy.createStaffDao();
    }

    public ITimeslotDAO createTimeslotDao() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return strategy.createTimeslotDao();
    }
}
