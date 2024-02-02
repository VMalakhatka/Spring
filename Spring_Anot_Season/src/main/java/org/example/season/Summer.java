package org.example.season;

public class Summer implements Season{
    public Summer() {
        System.out.println("Пришла " + this.getClass().getSimpleName());
    }
}
