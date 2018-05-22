package com.mum.dao.abstractfactory2;

import com.mum.dao.IClientDAO;
import com.mum.dao.h2.ClientDAOAdapter;

public class H2Factory implements AbstractFactory {
    @Override
    public IClientDAO createClientDAO() {
        return new ClientDAOAdapter();
    }
}
