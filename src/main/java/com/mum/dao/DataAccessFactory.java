package com.mum.dao;

/**
 * Simple factory to create the dao instance based on the db type assigned.
 */
public class DataAccessFactory {

    // switch db type
    private static final String db = "mysql";
    // private static final String db = "h2";

    public static IAppointmentDao createAppointmentDao() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//        IAppointmentDao dao = null;
//        switch (db) {
//            case "mysql":
//                dao = new com.mum.dao.mysql.AppointmentDao();
//                break;
//            case "h2":
//                dao = new com.mum.dao.h2.AppointmentDao();
//                break;
//        }
        // use reflection
        String fullName = String.format("com.mum.dao.%s.AppointmentDao", db);
        System.out.println(fullName);
        IAppointmentDao dao = (IAppointmentDao)Class.forName(fullName).newInstance();

        return dao;
    }

    public static IClientDao createClientDao() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String fullName = String.format("com.mum.dao.%s.ClientDao", db);
        System.out.println(fullName);
        IClientDao dao = (IClientDao)Class.forName(fullName).newInstance();
        return dao;
    }

    public static IRequestDao createRequestDao() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String fullName = String.format("com.mum.dao.%s.RequestDao", db);
        System.out.println(fullName);
        IRequestDao dao = (IRequestDao)Class.forName(fullName).newInstance();
        return dao;
    }

    public static IStaffDao createStaffDao() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String fullName = String.format("com.mum.dao.%s.StaffDao", db);
        System.out.println(fullName);
        IStaffDao dao = (IStaffDao)Class.forName(fullName).newInstance();
        return dao;
    }

    public static ITimeslotDao createTimeslotDao()  throws ClassNotFoundException, IllegalAccessException, InstantiationException{
        String fullName = String.format("com.mum.dao.%s.TimeslotDao", db);
        System.out.println(fullName);
        ITimeslotDao dao = (ITimeslotDao)Class.forName(fullName).newInstance();
        return dao;
    }
}
