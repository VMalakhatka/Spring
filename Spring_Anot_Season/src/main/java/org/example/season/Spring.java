package org.example.season;

public class Spring implements Season{
    public Spring() {
        System.out.println("Пришла " + this.getClass().getSimpleName());
    }
}
