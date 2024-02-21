package org.example.mapper;

import org.example.entity.reestr.Reestr;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DishDaoMapper implements RowMapper<Reestr> {
    @Override
    public Reestr mapRow(ResultSet rs, int rowNum) throws SQLException {
        return  new Reestr(
                rs.getLong("id"),
                rs.getString("klass"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("subject"),
                rs.getInt("mark"),
                rs.getDate("date_of_mark")
        );
    }
}
