package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class Product extends ProductForm{

  private final List<Reaction> reactions;

  public Product(ProductForm productForm) {
    super.setId(productForm.getId());
    super.setName(productForm.getName());
    reactions=new ArrayList<>();
    setReactions((int) productForm.getBall(),productForm.getNote());
  }

  public List<Reaction> getReactions() {
    return reactions;
  }

  public void setReactions(Reaction reaction) {
    this.reactions.add( reaction);
  }
  public void setReactions(int ball, String note ){
    Reaction reaction = new Reaction(ball,note);
    this.reactions.add(reaction);
  }
}
