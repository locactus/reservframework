package com.mum.dao;

/**
 * Factory method to create the dao instance based on the db type assigned.
 */
public class DataAccessFactory {

    // switch db type
    private static final String db = "mysql";
    // private static final String db = "h2";

    public static IAppointmentDAO createAppointmentDao() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // IAppointmentDAO dao = null;
        // switch (db) {
        //    case "mysql":
        //        dao = new com.mum.dao.mysql.AppointmentDAO();
        //        break;
        //    case "h2":
        //        dao = new com.mum.dao.h2.AppointmentDAO();
        //        break;
        // }
        // use reflection
        String fullName = String.format("com.mum.dao.%s.AppointmentDAO", db);
        System.out.println(fullName);
        IAppointmentDAO dao = (IAppointmentDAO) Class.forName(fullName).newInstance();

        return dao;
    }

    public static IClientDAO createClientDao() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String fullName = String.format("com.mum.dao.%s.ClientDAO", db);
        System.out.println(fullName);
        IClientDAO dao = (IClientDAO) Class.forName(fullName).newInstance();
        return dao;
    }

    public static IRequestDAO createRequestDao() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String fullName = String.format("com.mum.dao.%s.RequestDAO", db);
        System.out.println(fullName);
        IRequestDAO dao = (IRequestDAO) Class.forName(fullName).newInstance();
        return dao;
    }

    public static IStaffDAO createStaffDao() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String fullName = String.format("com.mum.dao.%s.StaffDAO", db);
        System.out.println(fullName);
        IStaffDAO dao = (IStaffDAO) Class.forName(fullName).newInstance();
        return dao;
    }

    public static ITimeslotDAO createTimeslotDao() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String fullName = String.format("com.mum.dao.%s.TimeslotDAO", db);
        System.out.println(fullName);
        ITimeslotDAO dao = (ITimeslotDAO) Class.forName(fullName).newInstance();
        return dao;
    }
}
