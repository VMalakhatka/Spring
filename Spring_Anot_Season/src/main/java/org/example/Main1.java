package org.example;

import org.example.config.AppConfig;
import org.example.season.Season;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        Season season = context.getBean(Season.class);
        System.out.println(season);
        Season curentSeason =context.getBean("currentSeason",Season.class);
        System.out.println(curentSeason);
        context.close();
    }
}

//Переведите ранее созданное приложение на конфигурацию без использования xml.
//Создайте класс Connector, который использует бин настроек приложения (host, port и token).
// В классе создайте метод, эмулирующий подключение к удалённому серверу. Получите бин Connector
// из контекста и запустите метод подключения.

//Дополните предыдущее задание. Создайте также бины классов Лето, Весна, Осень, имплементирующие
// интерфейс Сезон. Создайте бин Текущий сезон, который хранит текущий сезон года (когда бы ни
// запускалась программа, сезон должен быть правильный). Создайте бин Туристический сезон – каждый
// новый туристический сезон должен начинаться с Зимы (используйте @Primary). Создайте бин класса
// Год и внедрите в него все 4 сезона года.