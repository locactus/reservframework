package com.mum.dao.mysql;

import java.sql.Connection;

public abstract class BaseDAO {
    protected Connection conn = null;
    protected String lastExecutedStatement = null;
}