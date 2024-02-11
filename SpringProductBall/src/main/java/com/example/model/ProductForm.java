package com.example.model;

public class ProductForm {
  private String id;

  private String name;
  private double ball;

  private String note;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getBall() {
    return ball;
  }

  public void setBall(double ball) {
    this.ball = ball;
  }

  public String getNote() {return note;}

  public void setNote(String note) {this.note = note;}

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
