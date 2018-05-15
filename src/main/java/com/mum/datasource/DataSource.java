package com.mum.datasource;

import org.apache.commons.dbcp2.*;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;

import javax.xml.crypto.Data;
import java.sql.*;

public class DataSource {

    private static DataSource instance = null;
    public static DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
        }
        return instance;
    }


    private static Connection conn = null;
//    private DataSource() {
//
//    }
    private DataSource() {
        //
        // First we load the underlying JDBC driver.
        // You need this if you don't use the jdbc.drivers
        // system property.
        //
        System.out.println("Loading underlying JDBC driver.");
        try {
//            Class.forName("org.h2.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Done.");


        //
        // Then we set up and register the PoolingDriver.
        // Normally this would be handled auto-magically by
        // an external configuration, but in this example we'll
        // do it manually.
        //
        System.out.println("Setting up driver.");
        try {
//            String connectUri = "jdbc:mysql://167.99.1.180:3306/reservdb?useSSL=false";
//            String connectUri = "jdbc:mysql://206.189.206.96:3306/reservdb?useSSL=false";
            String connectUri = "jdbc:mysql://206.189.227.161:3306/reservdb?useSSL=false";


            String uname = "myuser";
            String passwd = "123456";
            setupDriver(connectUri, uname, passwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Done.");
    }

    public Connection getConnection() {
        try {
            System.out.println("Creating connection.");
            conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:framework");
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void setupDriver(String connectURI, String uname, String passwd) throws Exception {
        //
        // First, we'll create a ConnectionFactory that the
        // pool will use to create Connections.
        // We'll use the DriverManagerConnectionFactory,
        // using the connect string passed in the command line
        // arguments.
        //

        ConnectionFactory connectionFactory =
                new DriverManagerConnectionFactory(connectURI, uname, passwd);

        //
        // Next, we'll create the PoolableConnectionFactory, which wraps
        // the "real" Connections created by the ConnectionFactory with
        // the classes that implement the pooling functionality.
        //
        PoolableConnectionFactory poolableConnectionFactory =
                new PoolableConnectionFactory(connectionFactory, null);

        //
        // Now we'll need a ObjectPool that serves as the
        // actual pool of connections.
        //
        // We'll use a GenericObjectPool instance, although
        // any ObjectPool implementation will suffice.
        //
        ObjectPool<PoolableConnection> connectionPool =
                new GenericObjectPool<>(poolableConnectionFactory);

        // Set the factory's pool property to the owning pool
        poolableConnectionFactory.setPool(connectionPool);

        //
        // Finally, we create the PoolingDriver itself...
        //
        Class.forName("org.apache.commons.dbcp2.PoolingDriver");
        PoolingDriver driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");

        //
        // ...and register our pool with it.
        //
        driver.registerPool("framework",connectionPool);

        //
        // Now we can just use the connect string "jdbc:apache:commons:dbcp:framework"
        // to access our pool of Connections.
        //
    }

    public void printDriverStats() throws Exception {
        PoolingDriver driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
        ObjectPool<? extends Connection> connectionPool = driver.getConnectionPool("framework");

        System.out.println("NumActive: " + connectionPool.getNumActive());
        System.out.println("NumIdle: " + connectionPool.getNumIdle());
    }

    public void shutdownDriver() throws Exception {
        PoolingDriver driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
        driver.closePool("framework");
    }
}
