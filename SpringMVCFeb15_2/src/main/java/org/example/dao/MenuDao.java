package org.example.dao;

import org.example.entity.dish.Dish;

import java.util.List;

public interface MenuDao {
    Dish create(Dish candidate);
    Dish read(long id);
    List<Dish> readAll();
    void update(long id, Dish dish);
    void delete(long id);
}
