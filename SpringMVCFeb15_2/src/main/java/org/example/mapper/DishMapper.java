package org.example.mapper;

import org.example.dto.DishDto;
import org.example.dto.IngredientDto;
import org.example.entity.dish.Dish;
import org.example.entity.dish.Ingredient;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

@Component
public class DishMapper {
    public DishDto toDishDto(Dish dish) {
        return new DishDto(dish.getId(), dish.getName(), dish.getIngredients());
    }
    public Dish toDish(DishDto dishDto){
        return new Dish(dishDto.id(), dishDto.name(), dishDto.ingredient());
    }
    public IngredientDto toIngredientDto(Ingredient ingredient){
        return new IngredientDto(ingredient.name(), ingredient.nutrition(), ingredient.cookingTime(), ingredient.price());
    }
    public Ingredient toIngredient(IngredientDto ingredientDto){
        return new Ingredient(ingredientDto.name(), ingredientDto.nutrition(), ingredientDto.cookingTime(), ingredientDto.price());
    }
    public Map<Ingredient, Integer> toIngredientDtoMap(Map<IngredientDto, Integer> mapIngredientsDto){
        return  mapIngredientsDto.entrySet().stream()
                .collect(Collectors.toMap(p -> toIngredient(p.getKey()), Map.Entry::getValue));
    }
    public Map<IngredientDto, Integer> toIngredientMap(Map<Ingredient, Integer> mapIngredients){
        return  mapIngredients.entrySet().stream()
                .collect(Collectors.toMap(p -> toIngredientDto(p.getKey()), Map.Entry::getValue));
    }
}
