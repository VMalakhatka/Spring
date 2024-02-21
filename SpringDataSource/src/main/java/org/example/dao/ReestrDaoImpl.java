package org.example.dao;

import org.example.entity.reestr.Reestr;
import org.example.mapper.DishDaoMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.*;
@Component
public class ReestrDaoImpl implements ReestrDao {
private  final JdbcTemplate jdbcTemplate;


    public ReestrDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Reestr create(Reestr record) {
        Objects.requireNonNull(record, "Record to reestr cant be null");
        jdbcTemplate.update("INSERT INTO reestr (klass,first_name,last_name,subject,mark,date_of_mark) values (?,?,?,?,?,?)",
                record.klass(), record.first_name(), record.last_name(),record.subject(),record.mark(),record.date_of_mark());

        return findByAllParameter(record);
    }

    @Override
    public List<Reestr> read(String klass, String first_name, String last_name) {
        return jdbcTemplate.query("SELECT *  FROM reestr WHERE klass=? AND first_name=? AND last_name=?",
                        new DishDaoMapper(),klass, first_name, last_name);
    }

    @Override
    public List<Reestr> readAll(String klass) {
        return null;
    }

    public Reestr findByAllParameter(Reestr record){
        return jdbcTemplate.query("SELECT *  FROM reestr WHERE klass=? AND first_name=? AND last_name=? AND subject=? AND mark=? AND date_of_mark=?",
                new DishDaoMapper(),record.klass(), record.first_name(), record.last_name(),record.subject(),record.mark(),record.date_of_mark()).stream().findFirst().orElseThrow();
    }

    @Override
    public List<Reestr>  read(String klass) {
        return jdbcTemplate.query("SELECT *  FROM reestr WHERE klass=?", new DishDaoMapper(),klass);
    }

    @Override
    public List<Reestr> readAll() {
        return jdbcTemplate.query("SELECT *  FROM reestr;", new DishDaoMapper());
    }


    @Override
    public void update(long id, Reestr record) {
        Objects.requireNonNull(record,"Candidat can't be Null");
        jdbcTemplate.update("UPDATE reestr SET klass=?,first_name=?,last_name=?,subject=?,mark=?,date_of_mark=? WHERE id=?;",
                record.klass(), record.first_name(), record.last_name(),record.subject(),record.mark(),record.date_of_mark(),id);
    }

    @Override
    public void delete(long id) {
        jdbcTemplate.update("DELETE FROM reestr WHERE id=?;",id);
    }
}
