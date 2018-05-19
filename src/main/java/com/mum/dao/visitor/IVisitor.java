package com.mum.dao.visitor;

import com.mum.dao.*;

public interface IVisitor {
    void visit(IClientDAO dao);
    void visit(IStaffDAO dao);
    void visit(IAppointmentDAO dao);
    void visit(IRequestDAO dao);
    void visit(ITimeslotDAO dao);
}
