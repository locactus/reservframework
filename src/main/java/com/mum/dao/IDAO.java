package com.mum.dao;

public interface IDAO {
    void accept(IVisitor visitor);
    String getLastExecutedStatement();
}
