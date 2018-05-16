package com.mum.dao;


public class DataAccess {

    // switch db type
    private static final String db = "mysql";
    // private static final String db = "h2";

    public static IAppointmentDao createAppointmentDao() {
        IAppointmentDao dao = null;
        switch (db) {
            case "mysql":
                dao = new com.mum.dao.mysql.AppointmentDao();
                break;
            case "h2":
                dao = new com.mum.dao.h2.AppointmentDao();
                break;
        }
        return dao;
    }

    public static IClientDao createClientDao() {
        IClientDao dao = null;
        switch (db) {
            case "mysql":
                dao = new com.mum.dao.mysql.ClientDao();
                break;
            case "h2":
                dao = new com.mum.dao.h2.ClientDao();
                break;
        }
        return dao;
    }

    public static IRequestDao createRequestDao() {
        IRequestDao dao = null;
        switch (db) {
            case "mysql":
                dao = new com.mum.dao.mysql.RequestDao();
                break;
            case "h2":
                dao = new com.mum.dao.h2.RequestDao();
                break;
        }
        return dao;
    }

    public static IStaffDao createStaffDao() {
        IStaffDao dao = null;
        switch (db) {
            case "mysql":
                dao = new com.mum.dao.mysql.StaffDao();
                break;
            case "h2":
                dao = new com.mum.dao.h2.StaffDao();
                break;
        }
        return dao;
    }

    public static ITimeslotDao createTimeslotDao() {
        ITimeslotDao dao = null;
        switch (db) {
            case "mysql":
                dao = new com.mum.dao.mysql.TimeslotDao();
                break;
            case "h2":
                dao = new com.mum.dao.h2.TimeslotDao();
                break;
        }
        return dao;
    }


}
