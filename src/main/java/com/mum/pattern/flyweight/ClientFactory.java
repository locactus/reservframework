package com.mum.pattern.flyweight;

import com.mum.model.Client;
import com.mum.model.enums.UserType;

import java.util.HashMap;

public class ClientFactory {
  public static final HashMap<UserType, Client> userMap = new HashMap<>();

  public synchronized static User getUser(UserType userType) {
    Client client = userMap.get(userType);
    if(client == null) {
      client = new Client(userType);
      userMap.put(userType, client);
    }

    return client;
  }
}
