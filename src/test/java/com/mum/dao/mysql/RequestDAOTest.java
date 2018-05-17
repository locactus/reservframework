package com.mum.dao.mysql;

import com.mum.dao.DataAccessFactory;
import com.mum.dao.IRequestDAO;
import com.mum.model.Request;
import com.mum.model.enums.RequestState;
import com.mum.model.enums.RequestType;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class RequestDAOTest {
    IRequestDAO dao = null;
    public RequestDAOTest() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        dao = DataAccessFactory.createRequestDao();
    }

    @Test
    public void getAll() {
        try {
            List<Request> result = dao.getAll();
            assertTrue(!result.isEmpty());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getRequestsByAppointmentId() {
        Request request = new Request();
        int appointmentId = 4001;
        request.setAppointmentId(appointmentId);
        request.setState(RequestState.PENDING);
        request.setType(RequestType.MAKE);
        try {
            dao.insert(request);
            assertTrue(!dao.getRequestsByAppointmentId(appointmentId).isEmpty());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insert() {
        Request request = new Request();
        int appointmentId = 4001;
        request.setAppointmentId(appointmentId);
        request.setState(RequestState.PENDING);
        request.setType(RequestType.MAKE);
        try {
            assertTrue(dao.insert(request) > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void delete() {
        // insert
        Request request = new Request();
        int appointmentId = 4001;
        request.setAppointmentId(appointmentId);
        request.setState(RequestState.PENDING);
        request.setType(RequestType.MAKE);
        int newRequestId = 0;
        try {
            newRequestId = dao.insert(request);
            assertTrue(dao.delete(newRequestId));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void update() {
        try {
            // insert
            Request request = new Request();
            int appointmentId = 4001;
            request.setAppointmentId(appointmentId);
            request.setState(RequestState.PENDING);
            request.setType(RequestType.MAKE);
            int newRequestId = dao.insert(request);

            // update
            request.setRequestId(newRequestId);
            request.setState(RequestState.ACCEPT);

            assertTrue(dao.update(request));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}