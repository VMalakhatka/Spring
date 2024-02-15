package org.example.mapper;

import org.example.dto.DishDto;
import org.example.dto.IngredientDto;
import org.example.entity.dish.Dish;
import org.example.entity.dish.Ingredient;
import org.springframework.stereotype.Component;

@Component
public class DishMapper {
    public DishDto toDishDto(Dish dish){
        return new DishDto(dish.getId(), dish.getName(), dish.getIngredientsToAmount());
    }

    public Dish toDish(DishDto dishDto){
        return new Dish(dishDto.id(), dishDto.name(), dishDto.ingredientsToAmount());
    }

    public IngredientDto toIngredientDto(Ingredient ingredient){
       return new IngredientDto(ingredient.name(), ingredient.nutrition(),ingredient.cookingTime(),ingredient.price());
    }
}
