package org.example.controller;

import org.example.dto.DishDto;
import org.example.service.ServiceMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/menu")
public class MenuController {
    private ServiceMenu serviceMenu;

    @Autowired
    public MenuController(ServiceMenu serviceMenu) {
        this.serviceMenu = serviceMenu;
    }

    @PostMapping()
    public DishDto create(@RequestBody DishDto candidate){
        return serviceMenu.create(candidate);
    }
    @GetMapping("/{id}")
    public DishDto read(@PathVariable("id") long id){
        return serviceMenu.read(id);
    }
    @GetMapping()
    public List<DishDto> readAll(){
        return serviceMenu.readAll();
    }
    @PutMapping("/{id}")
    public void update(@PathVariable("id") long id, @RequestBody DishDto dish){
        serviceMenu.update(id, dish);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id){
        serviceMenu.delete(id);
    }
}
