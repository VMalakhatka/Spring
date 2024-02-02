package org.example.conrollers;

import org.example.dto.Weather;
import org.example.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClimateController {

    @Autowired
    private WeatherService service;

   @GetMapping("/town")
   public Weather getWether(@RequestParam(name = "name",defaultValue = "Berlin") String name){
       return service.getWeather(name);
   }
}


//Разработайте RESTful API, которое принимает название города и возвращает
// информацию о погоде в этом городе. Для простоты возвращайте заранее
// определенные данные.