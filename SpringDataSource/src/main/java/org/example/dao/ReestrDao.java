package org.example.dao;

import org.example.entity.reestr.Reestr;

import java.util.List;

public interface ReestrDao {
    Reestr create(Reestr record);
    List<Reestr> read(String klass, String first_name,String last_name);
    List<Reestr> read(String klass);
    List<Reestr> readAll(String klass);
    List<Reestr> readAll();
    void update(long id, Reestr reestr);
    void delete(long id);
}
