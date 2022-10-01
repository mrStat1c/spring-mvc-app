package ru.amelin.mvc.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.amelin.mvc.models.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

//если названия всех полей объекта совпадает с названием полей в таблице, можно
//вместо собственного маппера использовать стандартный BeanPropertyRowMapper
public class PersonMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Person person = new Person();
        person.setId(resultSet.getInt("id"));
        person.setName(resultSet.getString("name"));
        person.setAge(resultSet.getInt("age"));
        person.setEmail(resultSet.getString("email"));
        return person;
    }
}
