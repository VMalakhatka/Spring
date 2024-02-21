package org.example.controller;

import org.example.dto.ReestrDto;
import org.example.entity.reestr.Reestr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/reestr")
public class ControllerReestr {
    private org.example.service.ServiceReestr serviceReestr;

    @Autowired
    public ControllerReestr(org.example.service.ServiceReestr serviceReestr) {
        this.serviceReestr = serviceReestr;
    }

    @PostMapping()
    public ReestrDto create(@RequestBody ReestrDto candidate){
        return serviceReestr.create(candidate);
    }

    @GetMapping("/{klass}")
    public List<ReestrDto> read(@PathVariable("klass") String klass){
        return serviceReestr.read(klass);
    }

    @GetMapping("/{klass}/first/{first_name}/last/{last_name}")
    public List<Reestr> readByName(@PathVariable("klass") String klass,
                                   @PathVariable("first_name") String first_name,
                                   @PathVariable("last_name") String last_name){
        return serviceReestr.getByNameAndKlass(klass,first_name,last_name);
    }

    @GetMapping()
    public List<ReestrDto> readAll(){
        System.out.println("!!!!!!!");
        return serviceReestr.readAll();
    }
    @PutMapping("/{id}")
    public void update(@PathVariable("id") long id, @RequestBody ReestrDto reestrDto){
        serviceReestr.update(id, reestrDto);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id){
        serviceReestr.delete(id);
    }
}