package org.example.dao;

import org.example.entity.dish.Dish;
import org.example.mapper.DishDaoMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.*;
@Component
public class MenuDaoImpl implements MenuDao {
private  final JdbcTemplate jdbcTemplate;


    public MenuDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Dish create(Dish candidate) {
        Objects.requireNonNull(candidate, "Candidate cant be null");
        jdbcTemplate.update("INSERT INTO dishes (name, ingredients) values (?,?)",
                candidate.getName(),candidate.getIngredients());

        return readAll().stream().filter(dish -> dish.getName().equals(candidate.getName())).findFirst().orElseThrow();
    }

    @Override
    public Dish read(long id) {
        List<Dish> dishes = jdbcTemplate.query("SELECT *  FROM dishes WHERE id=?", new DishDaoMapper(),id);
        if (dishes.size()>1) throw new IllegalStateException("id more one");
        return dishes.stream().findFirst().orElseThrow();
    }

    @Override
    public List<Dish> readAll() {
        return jdbcTemplate.query("SELECT *  FROM dishes;", new DishDaoMapper());
    }


    @Override
    public void update(long id, Dish dish) {
        Objects.requireNonNull(dish,"Candidat can't be Null");
        jdbcTemplate.update("UPDATE dishes SET name=? , ingredients=? WHERE id=?;",dish.getName(),dish.getIngredients(),id);
    }

    @Override
    public void delete(long id) {
        jdbcTemplate.update("DELETE FROM dishes WHERE id=?;",id);
    }
}
