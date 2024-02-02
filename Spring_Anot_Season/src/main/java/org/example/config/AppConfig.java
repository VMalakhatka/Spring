package org.example.config;

import org.example.season.*;
import org.springframework.context.annotation.*;

import java.time.LocalDate;

@Configuration
@ComponentScan( "org.example.season")
public class AppConfig {

    @Bean
    @Scope("prototype")
    public Snow snow() {
        return new Snow();
    }

    @Bean
    public Season winter() {
        return new Winter(snow());
    }

    @Bean
    public Season spring() {
        return new Spring();
    }

    @Bean
    @Primary
    public Season summer() {
        return new Summer();
    }

    @Bean
    public Season autumn() {
        return new Autumn();
    }

    @Bean(name = "currentSeason")
    public Season currentSeason() {
        return switch (LocalDate.now().getMonth()) {
            case JANUARY, FEBRUARY, DECEMBER -> winter();
            case MAY, MARCH, APRIL -> spring();
            case JUNE, JULY, AUGUST -> summer();
            case OCTOBER, SEPTEMBER, NOVEMBER -> autumn();
        };

    }
}

