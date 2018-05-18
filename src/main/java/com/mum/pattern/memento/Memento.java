package com.mum.pattern.memento;

public class Memento {
  private String state;
  private ProcessState processState;
  private int businessId;

  public void setState(String state) {
    this.state = state;
  }

  public ProcessState getProcessState() {
    return processState;
  }

  public void setProcessState(ProcessState processState) {
    this.processState = processState;
  }

  public int getBusinessId() {
    return businessId;
  }

  public void setBusinessId(int businessId) {
    this.businessId = businessId;
  }

  public Memento(String state){
    this.state = state;
  }

  public String getState(){
    return state;
  }

  public Memento(String state, ProcessState processState, int businessId) {
    this.state = state;
    this.processState = processState;
    this.businessId = businessId;
  }
}
