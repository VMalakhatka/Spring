package org.example.message;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

public class MessageGenerator {
  boolean firstTime;

    public MessageGenerator() {this.firstTime = true;}
    public String welcome() {
        if (firstTime) {
            firstTime=false;
            return "Welcome, new user!";
        }
        return "Welcome back!";
    }

}
