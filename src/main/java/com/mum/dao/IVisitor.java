package com.mum.dao;

public interface IVisitor {
    void visitClientDAO(IClientDAO dao);
    void visitStaffDAO(IStaffDAO dao);
    void visitAppointmentDAO(IAppointmentDAO dao);
    void visitRequestDAO(IRequestDAO dao);
    void visitTimeslotDAO(ITimeslotDAO dao);
}
