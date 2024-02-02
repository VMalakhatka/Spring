package org.example.season;

public class Autumn implements Season{
    public Autumn() {
        System.out.println("Пришла " + this.getClass().getSimpleName());
    }
}
