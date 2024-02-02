package org.example;

import org.example.color.ColorProvider;
import org.example.color.FavoriteColor;
import org.example.color.Rainbow;
import org.example.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        FavoriteColor favoriteColor = context.getBean(FavoriteColor.class);
        System.out.println(favoriteColor.getColor().name());
        Rainbow rainbow = context.getBean(Rainbow.class);
        System.out.println(rainbow.getColors());
        ColorProvider colorProvider=context.getBean(ColorProvider.class);
        System.out.println(colorProvider.getColor("Orange"));
        System.out.println(colorProvider.getNameToColor());
        context.close();
    }
}

//Создайте 7 бинов цветов радуги Color в классе конфигурации. С помощью аннотации @Order
// задайте их порядок внедрения в поле типа List<Color> компонента Rainbow. Выведите поле
// с цветами в консоль.
//Создайте компонент ColorProvider, содержащий поле типа Map<String, Color> . Создайте
// метод получения цвета по его названию (имени бина).