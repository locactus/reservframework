package com.mum.dao.abstractfactory2;

import com.mum.dao.IClientDAO;

public interface AbstractFactory {
    IClientDAO createClientDAO();
}
