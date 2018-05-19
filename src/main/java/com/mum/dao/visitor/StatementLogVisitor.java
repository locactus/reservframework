package com.mum.dao.visitor;

import com.mum.dao.*;

public class StatementLogVisitor implements IVisitor {

    @Override
    public void visit(IClientDAO dao) {
        print(dao);
    }

    @Override
    public void visit(IStaffDAO dao) {
        print(dao);
    }

    @Override
    public void visit(IAppointmentDAO dao) {
        print(dao);
    }

    @Override
    public void visit(IRequestDAO dao) {
        print(dao);
    }

    @Override
    public void visit(ITimeslotDAO dao) {
        print(dao);
    }

    private void print(IDAO dao) {
        System.out.println(">>>>>>>>>>>>>>>> SQL Statement: " + dao.getLastExecutedStatement());
    }
}
