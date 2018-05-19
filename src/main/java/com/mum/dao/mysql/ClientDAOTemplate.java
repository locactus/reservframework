package com.mum.dao.mysql;


import com.mum.dao.IDAO;
import com.mum.datasource.DataSource;
import com.mum.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * An abstract class to provide two Template Method for ClientDao class.
 */
public abstract class ClientDAOTemplate extends BaseDAO implements IDAO {
    protected Connection conn = null;
    protected PreparedStatement pstmt = null;
    protected ResultSet rset = null;
    protected abstract Client buildClient(ResultSet rs) throws SQLException;


    /**
     * Open the connection, then execute the SQL statement with params
     * @param sql
     * @param params
     * @throws SQLException
     */
    protected void execute(String sql, Map<Integer, Object> params) throws SQLException {
        conn = DataSource.getInstance().getConnection();
        pstmt = conn.prepareStatement(sql);

        for (Map.Entry<Integer, Object> entry: params.entrySet()) {
            pstmt.setObject(entry.getKey(), entry.getValue());
        }
        this.lastExecutedStatement = pstmt.toString();
        rset = pstmt.executeQuery();
    }

    /**
     * Release all the resources: connection, preparedStatement and resultSet
     * @throws SQLException
     */
    protected void closeConnection() throws SQLException {
        rset.close();
        pstmt.close();
        conn.close();
    }

    /**
     * Template Method: Fetch client list from db by SQL statement with params
     * @param sql
     * @param params
     * @return
     * @throws SQLException
     */
    protected List<Client> getClientList(String sql, Map<Integer, Object> params) throws SQLException {
        List<Client> clients = null;
        execute(sql, params);
        if (rset.isBeforeFirst()) {
            clients = new ArrayList<>();
            while (rset.next()) {
                clients.add(buildClient(rset));
            }
        }
        closeConnection();
        return clients;
    }

    /**
     * Template Method: Fetch specific client from db by SQL statement with patams
     * @param sql
     * @param params
     * @return
     * @throws SQLException
     */
    protected Client getClient(String sql, Map<Integer, Object> params) throws SQLException {
        Client client = null;
        execute(sql, params);
        if (rset.isBeforeFirst()) {
            client = new Client();
            while (rset.next()) {
                client = buildClient(rset);
            }
        }
        closeConnection();
        return client;
    }
}
