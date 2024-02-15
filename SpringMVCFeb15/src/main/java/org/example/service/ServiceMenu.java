package org.example.service;

import org.example.dao.MenuDao;
import org.example.dto.DishDto;
import org.example.entity.dish.Dish;
import org.example.mapper.DishMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Objects;

//Создайте RESTful-приложение для приёма заказов от клиентов кафе. Бэкенд должен
//1 отдавать список доступных сегодня блюд (меню)
//2 принимать заказ: какие блюда и в каком количестве, комментарии к блюду
// (например, «Без добавления молока» или «Подать кофе первым» т.д.).
//3 методы удаления старых блюд из меню и добавление новых, изменение данных о блюде.
//
//Приложение должно использовать сущности доменной модели, DTO и DAO (используйте
// внутреннюю коллекцию вместо подключения к БД).

@Service
public class ServiceMenu {

    private MenuDao menuDao;
    private DishMapper dishMapper;
    @Autowired
    public ServiceMenu(MenuDao menuDao, DishMapper dishMapper) {
        this.menuDao = menuDao;
        this.dishMapper = dishMapper;
    }

    public DishDto


    public DishDto getByName(String name){
        Dish dish = menu.stream().filter(d -> Objects.equals(d.getName(),name )).findFirst().orElseThrow();

        return dishMapper.toDishDto(dish);
    }
}
