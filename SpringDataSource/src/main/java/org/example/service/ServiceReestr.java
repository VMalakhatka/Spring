package org.example.service;

import org.example.dao.ReestrDao;
import org.example.dto.ReestrDto;
import org.example.entity.reestr.Reestr;
import org.example.mapper.ReestrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;



@Service
public class ServiceReestr {
    private final ReestrDao reestrDao;
    private final ReestrMapper reestrMapper;

    @Autowired
    public ServiceReestr(ReestrMapper reestrMapper, ReestrDao reestrDao) {
        this.reestrDao = reestrDao;
        this.reestrMapper = reestrMapper;
    }

    public ReestrDto create(ReestrDto candidate){
        return reestrMapper.toReestrDto(reestrDao.create(reestrMapper.toReestr(candidate)));
    }
    public List<ReestrDto> read(String klass){
        return reestrDao.read(klass).stream().map(reestrMapper::toReestrDto).toList();
    }

    public List<ReestrDto> readAll(){
        return reestrDao.readAll().stream().map(reestrMapper::toReestrDto).toList();
    }
    public void update(long id, ReestrDto reestrDto) {
        reestrDao.update(id, reestrMapper.toReestr(reestrDto));
    }
    public void delete(long id){
        reestrDao.delete(id);
    }

    public List<Reestr> getByNameAndKlass(String klass, String first_name, String last_name){
       return reestrDao.read(klass,first_name,last_name);
    }
}
