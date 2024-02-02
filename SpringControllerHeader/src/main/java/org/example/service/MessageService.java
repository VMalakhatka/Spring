package org.example.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    private List<String> messages;

    public MessageService() {
        messages=new ArrayList<>();
    }

    public List<String> getMessages() {
        return new ArrayList<>(messages);
    }

    public void putMessage(String message){
        this.messages.add(message);
    }

}
