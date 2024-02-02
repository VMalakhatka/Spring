package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import product.FoodItem;

@Configuration
@ComponentScan("product")
public class AppConfig {
    @Bean
    @Scope("prototype")
    public FoodItem fish(){
        return new FoodItem("Fish");
    }
    @Bean
    @Scope("prototype")
    public FoodItem meat(){
        return new FoodItem("Meat");
    }
    @Bean
    @Scope("prototype")
    public FoodItem apple(){
        return new FoodItem("Apple");
    }
    @Bean
    @Scope("prototype")
    public FoodItem tomato(){
        return new FoodItem("Tomato");
    }
    @Bean
    @Scope("prototype")
    public FoodItem milk(){
        return new FoodItem("Milk");
    }
    @Bean
    @Scope("prototype")
    public FoodItem cheese(){
        return new FoodItem("Cheese");
    }
}
