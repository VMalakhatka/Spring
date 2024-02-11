package com.example.services;

import com.example.model.Product;
import com.example.model.ProductForm;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
  private int count=1;

  private final List<Product> products = new ArrayList<>();

  public void addProduct(ProductForm p) {
    if(p.getId().isEmpty()){
      p.setId(String.valueOf( count++));
      Product product=new Product(p);
      products.add(product);
      product.setBall(p.getBall());
      return;
    }
      products.forEach(product -> {
        if (product.getId().equals( p.getId())) {
            product.setReactions((int)p.getBall(),p.getNote());
            int sizeOfReactions = product.getReactions().size();
            double ball=(product.getBall()*(double) (sizeOfReactions-1)+ (double) p.getBall())/sizeOfReactions;
            product.setBall(ball);
        }
      });
  }

  public List<Product> findAll() {
    return products;
  }

  public Product getProduct(long id){

      return null;
  }

  public  Product findProdukt(String id){
      return  products.stream().filter(product -> product.getId().equals(id)).findFirst().orElseThrow();
  }

}
