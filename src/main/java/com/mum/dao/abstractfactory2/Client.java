package com.mum.dao.abstractfactory2;

import com.mum.dao.IClientDAO;

public class Client {
    AbstractFactory factory = new MySQLFactory();

    void run() {
        IClientDAO dao = factory.createClientDAO();
    }
}
