package com.mum.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")

public interface ILoginServlet {
        void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
    }
