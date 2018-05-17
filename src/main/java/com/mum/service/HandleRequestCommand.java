package com.mum.service;


import com.mum.model.Request;
import com.mum.model.enums.RequestState;

import java.sql.SQLException;

public class HandleRequestCommand extends RequestCommand {
    private int requestId;
    private RequestState state;

    public HandleRequestCommand(int requestId, RequestState state) {
        this.requestId = requestId;
        this.state = state;
    }

    @Override
    public void execute() throws SQLException {
        Request request = new Request();
        request.setRequestId(requestId);
        request.setState(state);
        this.requestDao.update(request);
    }
}
