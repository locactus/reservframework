package com.mum.dao;

public class StatementLogVisitor implements IVisitor {
    @Override
    public void visitClientDAO(IClientDAO dao) {
        dao.getLastExecutedStatement();
    }

    @Override
    public void visitStaffDAO(IStaffDAO dao) {

    }

    @Override
    public void visitAppointmentDAO(IAppointmentDAO dao) {

    }

    @Override
    public void visitRequestDAO(IRequestDAO dao) {

    }

    @Override
    public void visitTimeslotDAO(ITimeslotDAO dao) {

    }
}
