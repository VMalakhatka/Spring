package org.example.guest;

import java.time.LocalDateTime;

public record Guest(long id, String name, int order){}


//Создайте приложение для кафе, которое запоминает имя посетителя и
// время его первого заказа в день. Посетитель может делать заказы и
// получать скидку на каждый новый заказ в течение текущих суток (для
// упрощения в течение 30 секунд). После 23:59 система «забывает» посетителей.
// Используйте Session scope бин для хранения информации о посетителе и
// времени его первого заказа. Создайте контроллер для обработки заказов и выдачи скидок.