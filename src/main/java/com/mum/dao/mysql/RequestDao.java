package com.mum.dao.mysql;

import com.mum.dao.IRequestDao;
import com.mum.datasource.DataSource;
import com.mum.model.Request;
import com.mum.model.enums.RequestState;
import com.mum.model.enums.RequestType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RequestDao extends BaseDao implements IRequestDao {

    private List<Request> _get(String sql) throws SQLException{
        List<Request> result = null;

        conn = DataSource.getInstance().getConnection();
        Statement pstmt = super.conn.createStatement();
        ResultSet rset = pstmt.executeQuery(sql);
        int numcols = rset.getMetaData().getColumnCount();

        if (!rset.isBeforeFirst()) {
            // Empty table
            return null;
        }

        result = new ArrayList<>();

        while (rset.next()) {
            int requestId = rset.getInt("requestId");
            RequestType type = RequestType.values()[rset.getInt("type")];
            RequestState state = RequestState.values()[rset.getInt("state")];
            int appointmentId = rset.getInt("appointmentId");
            Date datetimeCreated = new Date(rset.getTimestamp("datetimeCreated").getTime());

            Request request = new Request();
            request.setRequestId(requestId);
            request.setAppointmentId(appointmentId);
            request.setType(type);
            request.setState(state);
            request.setDatetimeCreated(datetimeCreated);

            result.add(request);
        }
        conn.close();
        return result;
    }

    @Override
    public List<Request> getAll() throws SQLException {
        return this._get("SELECT * FROM request");
    }

    //Get the latest request object
    @Override
    public List<Request> getRequestsByAppointmentId(int apotmentId) throws SQLException {
        return this._get(String.format("SELECT * FROM request WHERE appointmentId = %d order by datetimeCreated desc " +
                "limit 1", apotmentId));
    }

    @Override
    public int insert(Request request) throws SQLException {
        conn = DataSource.getInstance().getConnection();
        String sql = "INSERT INTO request(appointmentId, type, state) VALUES(?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstmt.setInt(1, request.getAppointmentId());
        pstmt.setInt(2, request.getType().ordinal());
        pstmt.setInt(3, request.getState().ordinal());
        System.out.println(pstmt);
        pstmt.executeUpdate();
        ResultSet keys = pstmt.getGeneratedKeys();
        keys.next();
        int requestId = keys.getInt(1);
        conn.close();
        return requestId;
    }

    @Override
    public boolean delete(int requestId) throws SQLException {
        conn = DataSource.getInstance().getConnection();
        String sql = "DELETE FROM request WHERE requestId = ? ";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, requestId);
        System.out.println(pstmt);
        pstmt.executeUpdate();
        conn.close();
        return true;
    }

    @Override
    public boolean update(Request request) throws SQLException {
        conn = DataSource.getInstance().getConnection();
        String SQL = "UPDATE request SET state = ? WHERE requestId = ?";
        PreparedStatement pstmt = conn.prepareStatement(SQL);
        pstmt.setInt(1, request.getState().ordinal());
        pstmt.setInt(2, request.getType().ordinal());
        System.out.println(pstmt);
        pstmt.executeUpdate();
        conn.close();
        return true;
    }
}