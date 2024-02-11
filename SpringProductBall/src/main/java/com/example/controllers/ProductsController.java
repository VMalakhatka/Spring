package com.example.controllers;

import com.example.model.ProductForm;
import com.example.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Controller
public class ProductsController {

  private final ProductService productService;

  public ProductsController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/products")
  public String viewProducts(Model model) {
    var products = productService.findAll();
    model.addAttribute("products", products);

    return "products.html";
  }

  @GetMapping("/product/id")
  public String viewAveregeBall(@RequestParam("id") String id, Model model) {
    System.out.println(id);
    System.out.println();
    var product = productService.findProdukt(id);
    System.out.println(product);
    System.out.println(product.getId());
    System.out.println(product.getBall());
    model.addAttribute("id", product.getId());
    model.addAttribute("ball", product.getBall());

    return "productId.html";
  }

  @PostMapping("/products")
  public String addProduct(ProductForm p, Model model) {
    productService.addProduct(p);

    var products = productService.findAll();
    model.addAttribute("products", products);
    System.out.println(products);

    return "products.html";
  }
}
