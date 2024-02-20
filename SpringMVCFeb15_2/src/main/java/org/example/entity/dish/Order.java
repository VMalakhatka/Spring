package org.example.entity.dish;

import java.util.List;

public class Order {
    private List<OrderDetails> orderDetailList;

    public record OrderDetails (Dish dish, Integer amount, String comment){

    }
}
