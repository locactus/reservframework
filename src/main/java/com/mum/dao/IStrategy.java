package com.mum.dao;

public interface IStrategy {
    IAppointmentDAO createAppointmentDao() throws ClassNotFoundException, IllegalAccessException, InstantiationException;

    IClientDAO createClientDao() throws ClassNotFoundException, IllegalAccessException, InstantiationException;

    IRequestDAO createRequestDao() throws ClassNotFoundException, IllegalAccessException, InstantiationException;

    IStaffDAO createStaffDao() throws ClassNotFoundException, IllegalAccessException, InstantiationException;

    ITimeslotDAO createTimeslotDao() throws ClassNotFoundException, IllegalAccessException, InstantiationException;
}
