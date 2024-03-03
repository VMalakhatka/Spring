package org.example.service;

import org.example.dao.MenuDao;
import org.example.dto.DishDto;
import org.example.entity.dish.Dish;
import org.example.mapper.DishMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
    public ServiceMenu( DishMapper dishMapper, MenuDao menuDao) {
        this.menuDao = menuDao;
        this.dishMapper = dishMapper;
    }

    public DishDto create(DishDto candidate){
        return dishMapper.toDishDto(menuDao.create(dishMapper.toDish(candidate)));
    }
    public DishDto read(long id){
        return dishMapper.toDishDto(menuDao.read(id));
    }
    public List<DishDto> readAll(){
        return menuDao.readAll().stream().map(d -> dishMapper.toDishDto(d)).toList();
    }
    public void update(long id, DishDto dishDto) {
        menuDao.update(id, dishMapper.toDish(dishDto));
    }
    public void delete(long id){
        menuDao.delete(id);
    }

    public DishDto getByName(String name){
       return readAll().stream().filter(d -> Objects.equals(d.name(),name )).findFirst().orElseThrow();
    }
}
