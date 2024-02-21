package org.example.dto;

import org.example.entity.dish.Ingredient;

import java.util.Map;

public record DishDto(long id, String name, String ingredient){
}
