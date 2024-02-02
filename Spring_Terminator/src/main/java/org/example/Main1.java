package org.example;

import org.example.pojo.JohnConnor;
import org.example.pojo.Terminator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.ThreadLocalRandom;

public class Main1 {
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        JohnConnor johnConnor = context.getBean("johnConnor", JohnConnor.class);
        System.out.println(johnConnor);
        for (LocalTime i = LocalTime.now();
             LocalTime.now().isBefore( i.plus(1, ChronoUnit.MINUTES));) {
            Terminator terminator=context.getBean("terminator",Terminator.class);
            System.out.println(terminator);
            boolean isConnorAlive =johnConnor.destroyTerminator(terminator)>0;
            System.out.println(johnConnor);
            if (!isConnorAlive){
                System.out.println(" Победил Терминаьо");
                return;
            }
            Thread.sleep(3000);
        }
        System.out.println("Победил "+johnConnor);

        context.close();
    }
}

// Создайте бины классов Terminator и JohnConnor. JohnConnor обладает
// запасом здоровья, равным 100%. Каждый терминатор обладает случайным запасом
// здоровья от 1 до 10. Новый терминатор нападает на Джона раз в 3 секунды,
// каждый терминатор отнимает у Джона столько здоровья, сколько есть у этого
// терминатора. Битва продолжается до тех пор, пока Джон ещё жив или пока
// не вышла 1 минута времени.