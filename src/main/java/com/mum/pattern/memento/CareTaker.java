package com.mum.pattern.memento;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
  private List<Memento> mementoList = new ArrayList<Memento>();

  public void add(Memento state){
    mementoList.add(state);
  }

  public Memento get(int index){
    return mementoList.get(index);
  }

  public List<Memento> getMementoList() {
    return mementoList;
  }

  public void setMementoList(List<Memento> mementoList) {
    this.mementoList = mementoList;
  }
}
