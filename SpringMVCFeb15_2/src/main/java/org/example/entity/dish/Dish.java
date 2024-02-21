package org.example.entity.dish;

import lombok.*;

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
    private final String ingredients;


}
