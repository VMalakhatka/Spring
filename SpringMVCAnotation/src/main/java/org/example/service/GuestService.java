package org.example.service;

import org.example.guest.Guest;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@SessionScope
@Service
public class GuestService {
    private final Map<Long,Guest> idToGuest;
    private long count;

    public GuestService() {
        idToGuest =new HashMap<>();
        count=0;
    }

    public Guest createGuest(String name){
        Guest guest=new Guest(++count,name,1);
        idToGuest.put(guest.id(), guest);
        return guest;
    }

    public void addOrder(long id){
        Guest oldGuest= get(id);
        Guest guest=new Guest(id,oldGuest.name(),oldGuest.order()+1);
        idToGuest.put(id,guest);
    }

    public Guest get(long id){
        return Optional.ofNullable(idToGuest.get(id)).orElseThrow();
    }

}
