package com.mum.model;

import com.mum.model.enums.RequestState;
import com.mum.model.enums.RequestType;

import java.util.Date;

public class Request  {
    private int requestId;
    private RequestType type;
    private RequestState state;
    private int appointmentId;
    private Date datetimeCreated;

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
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

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Date getDatetimeCreated() {
        return datetimeCreated;
    }

    public void setDatetimeCreated(Date datetimeCreated) {
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
