package org.example.config;

import org.example.color.Color;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;


@Configuration
@ComponentScan( "org.example.color")
public class AppConfig {


    @Order(2)
    @Bean
    public Color orange(){
        return new Color("Orange");
    }

    @Order(3)
    @Bean
    public Color yellow(){
        return new Color("Yellow");
    }

    @Order(4)
    @Bean
    @Primary
    public Color green(){
        return new Color("Green");
    }

    @Order(5)
    @Bean
    public Color blue(){
        return new Color("Blue");
    }

    @Order(6)
    @Bean
    public Color darkBlue(){
        return new Color("DarkBlue");
    }

    @Order(1)
    @Bean
    public Color red(){
        return new Color("Red");
    }

    @Order(7)
    @Bean
    public Color violet(){
        return new Color("Violet");
    }


}

