package com.mum.model;

public class Appointment {
    private int appointmentId;
    private int timeslotId;
    private int clientId;

    public Appointment(int appointmentId, int timeslotId, int clientId) {
        this.appointmentId = appointmentId;
        this.timeslotId = timeslotId;
        this.clientId = clientId;
    }

    public Appointment(int timeslotId, int clientId) {
        this.timeslotId = timeslotId;
        this.clientId = clientId;
    }

    public Appointment() {

    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getTimeslotId() {
        return timeslotId;
    }

    public void setTimeslotId(int timeslotId) {
        this.timeslotId = timeslotId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId='" + appointmentId + '\'' +
                ", timeslotId='" + timeslotId + '\'' +
                ", clientId='" + clientId + '\'' +
                '}';
    }
}
