package org.example.service;

import org.example.dto.Weather;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class WeatherService {
    private Random random=new Random();
    public Weather getWeather(String name){
        return new Weather(random.nextDouble(-50.0,45.0),
                random.nextInt(101),
                random.nextInt(300,400) );
    }
}
