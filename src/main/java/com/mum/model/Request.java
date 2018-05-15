package com.mum.model;

import com.mum.model.enums.RequestState;
import com.mum.model.enums.RequestType;

public class Request {
    private String requestId;
    private RequestType type;
    private RequestState state;
    private String appointmentId;
    private String datetimeCreated;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public RequestType getType() {
        return type;
    }

    public void setType(RequestType type) {
        this.type = type;
    }

    public RequestState getState() {
        return state;
    }

    public void setState(RequestState state) {
        this.state = state;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getDatetimeCreated() {
        return datetimeCreated;
    }

    public void setDatetimeCreated(String datetimeCreated) {
        this.datetimeCreated = datetimeCreated;
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestId='" + requestId + '\'' +
                ", type=" + type +
                ", state=" + state +
                ", appointmentId='" + appointmentId + '\'' +
                ", datetimeCreated='" + datetimeCreated + '\'' +
                '}';
    }
}
