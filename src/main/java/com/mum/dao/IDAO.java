package com.mum.dao;

import com.mum.dao.visitor.IVisitor;

public interface IDAO {
    void accept(IVisitor visitor);
    String getLastExecutedStatement();
}
