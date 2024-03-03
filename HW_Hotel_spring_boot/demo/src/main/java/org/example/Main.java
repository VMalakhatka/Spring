package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}

// 1 уровень сложности: Создайте Spring Boot приложение с RESTful API для бронирования
// номеров в отеле (Hotel Booking Application), которое позволяет пользователям просматривать
// доступные номера, бронировать их на определенные даты, а также отменять бронирование.
//
//Дополнительно (по желанию) можно реализовать систему отзывов о номерах и отелях, а также
// различные способы фильтрации номеров (по цене, количеству звезд, расположению и т.д.).