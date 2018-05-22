package com.mum.dao.abstractfactory2;

import com.mum.dao.IClientDAO;
import com.mum.dao.mysql.ClientDAO;

public class MySQLFactory implements AbstractFactory {
    @Override
    public IClientDAO createClientDAO() {
        return new ClientDAO();
    }
}
