package com.mum.dao.mysql;

import com.mum.dao.IDAO;
import com.mum.dao.IVisitor;
import com.mum.datasource.DataSource;

import java.sql.Connection;

public class BaseDAO {
    protected Connection conn = null;
    protected String lastExecutedStatement = null;
}