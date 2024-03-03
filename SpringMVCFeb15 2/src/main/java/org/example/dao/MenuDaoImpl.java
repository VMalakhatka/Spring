package org.example.dao;

import org.example.entity.dish.Dish;
import org.springframework.stereotype.Component;

import java.util.*;
@Component
public class MenuDaoImpl implements MenuDao {
    private final Map<Long, Dish> idToDish;
    private static long count = 0;

    public MenuDaoImpl() {
        this.idToDish = new HashMap<>();
    }

    @Override
    public Dish create(Dish candidate) {
        Objects.requireNonNull(candidate, "Candidate cant be null");
        long id = count++;
        Dish dish = new Dish(id, candidate.getName(), candidate.getIngredientsToAmount());
        idToDish.put(id, dish);
        return dish;
    }

    @Override
    public Dish read(long id) {
        return idToDish.get(id);
    }

    @Override
    public List<Dish> readAll() {
        return new ArrayList<>(idToDish.values());
    }

    @Override
    public void update(long id, Dish dish) {
        idToDish.put(id, dish);
    }

    @Override
    public void delete(long id) {
        idToDish.remove(id);
    }
}
