package com.mum.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/appointment")
public abstract class IAppointmentServlet extends BaseTemplate {
    protected abstract void doGet(HttpServletRequest req, HttpServletResponse resp);
    protected abstract void confirmAppointment(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException;
    protected abstract void listAllAppointment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException;
    protected abstract void listAdminAppointment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException;
    protected abstract void addAppointment(HttpServletRequest req, HttpServletResponse resp);
}
