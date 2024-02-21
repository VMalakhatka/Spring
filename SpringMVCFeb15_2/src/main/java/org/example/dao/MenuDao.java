package org.example.dao;

import org.example.entity.dish.Dish;

import java.util.List;

public interface MenuDao {
    Dish create(Dish candidate);
    Dish read(long id);
    List<Dish> readAll();
    void update(long id, Dish dish);
    void delete(long id);
}

//1 Добавьте в проект приложения для кафе зависимость для драйвера, работающего с СУБД
// https://mvnrepository.com/artifact/org.postgresql/postgresql
//        2 Создайте подключение к БД (правая панель Database -> “+” -> в списке выберите
//        PostgreSQL -> в настройках введите параметры и, при необходимости, скачайте драйвер).
//        Нажмите Test Connection. Если показал зелёную галочку, то соединение настроено.
//        3 Создайте БД MenuApp.
//4 Создайте подключение к БД в IntelliJ IDEA.
//5 После создания откроется консоль для ввода SQL-запросов. Создайте таблицу dishes со столбцами,
// соответствующими полям класса Dish.
//        6 Заполните таблицу тремя записями о блюдах.
//        7 Дополните проект так, чтобы DAO работали с реальной БД.