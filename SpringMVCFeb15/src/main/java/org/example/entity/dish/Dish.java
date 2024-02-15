package org.example.entity.dish;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.Duration;
import java.util.Comparator;
import java.util.Map;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString

public class Dish {
    private final long id;
    private final String name;
    private final Map<Ingredient, Integer> ingredientsToAmount;



    public double calculatePrice(){
        return ingredientsToAmount.entrySet().stream().mapToDouble(pair -> pair.getValue()* pair.getKey().price()).sum();
    }

    public int calculateNutrition(){
        return ingredientsToAmount.entrySet().stream().mapToInt(p -> p.getValue() * p.getKey().nutrition()).sum();
    }
    public Duration calculateTime(){
        return ingredientsToAmount.keySet().stream().map(Ingredient::cookingTime).max(Comparator.naturalOrder()).orElseThrow();

        //return ingredientsToAmount.keySet().stream().max(Comparator.comparing(Ingredient::cookingTime)).orElseThrow().cookingTime();
    }
}
