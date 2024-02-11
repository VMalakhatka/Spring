package com.example.model;

public class Reaction {
    private int ball;
    private String note;

    public Reaction(int ball, String note) {
        this.ball = ball;
        this.note = note;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


}
