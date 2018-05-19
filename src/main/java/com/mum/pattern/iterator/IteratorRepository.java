package com.mum.pattern.iterator;

import com.mum.model.Appointment;

import java.util.ArrayList;
import java.util.List;

public class IteratorRepository implements Iterator{
  private List<Appointment> objectList;

  public IteratorRepository(List<Appointment> objectList) {
    this.objectList = objectList;
  }

  int index;

  @Override
  public boolean hasNext() {
    return index < objectList.size();
  }

  @Override
  public Object next() {
    return objectList.get(index++);
  }

  public static void main(String[] args) {
    Appointment appointment = new Appointment(1, 2, 3);
    Appointment appointment1 = new Appointment(1, 2, 3);
    Appointment appointment2 = new Appointment(1, 2, 3);
    Appointment appointment3 = new Appointment(1, 2, 3);

    ArrayList<Appointment> appointments = new ArrayList<Appointment>();
    appointments.add(appointment);
    appointments.add(appointment1);
    appointments.add(appointment2);
    appointments.add(appointment3);

    IteratorRepository iteratorRepository = new IteratorRepository(appointments);
    while(iteratorRepository.hasNext()) {
      System.out.println(iteratorRepository.next());
    }
  }
}
