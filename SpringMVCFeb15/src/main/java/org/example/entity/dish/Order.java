package org.example.entity.dish;

import java.util.List;
import java.util.Map;

public record Order(List<OrderDetail> orderDetails) {
    ;

    public record OrderDetail(Dish dish, Integer amount, String comment){}
}
