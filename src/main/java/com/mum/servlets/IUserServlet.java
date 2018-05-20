package com.mum.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface IUserServlet {
    void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
