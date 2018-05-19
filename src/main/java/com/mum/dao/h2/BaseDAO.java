package com.mum.dao.h2;

import com.mum.dao.IVisitor;

import java.sql.Connection;

public class BaseDAO {
    protected Connection conn = null;
    protected String lastExecutedStatement = null;
}