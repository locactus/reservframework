package com.mum.dto;

import com.mum.model.Appointment;
import com.mum.model.Timeslot;
import com.mum.model.enums.RequestState;

public class AppointmentDTO extends Appointment {
  private Timeslot timeslot;
  private String firstName;
  private String lastName;
  private String phoneNumber;
  private String email;
  private RequestState state;

  private String startTimeStr;
  private String endTimeStr;

  public AppointmentDTO(int appointmentId, int timeslotId, int clientId, Timeslot timeslot, String firstName, String
      lastName, String phoneNumber, String email, RequestState state) {
    super(appointmentId, timeslotId, clientId);
    this.timeslot = timeslot;
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.state = state;
  }

  public AppointmentDTO(int appointmentId, int timeslotId, int clientId) {
    super(appointmentId, timeslotId, clientId);
  }

  public AppointmentDTO() {
  }

  public Timeslot getTimeslot() {
    return timeslot;
  }

  public void setTimeslot(Timeslot timeslot) {
    this.timeslot = timeslot;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public RequestState getState() {
    return state;
  }

  public void setState(RequestState state) {
    this.state = state;
  }

  public String getStartTimeStr() {
    return startTimeStr;
  }

  public void setStartTimeStr(String startTimeStr) {
    this.startTimeStr = startTimeStr;
  }

  public String getEndTimeStr() {
    return endTimeStr;
  }

  public void setEndTimeStr(String endTimeStr) {
    this.endTimeStr = endTimeStr;
  }
}
