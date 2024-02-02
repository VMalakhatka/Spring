package com.malakhatkave.pojo;

public class Plant {
    private Plant() {

    }
    public  static Plant produceNewPlant(){
        System.out.println("Выращиваем новое растение ");
        return new Plant();
    }
}
