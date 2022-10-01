package ru.amelin.mvc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.amelin.mvc.models.Person;

import java.util.List;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        String sql = "SELECT * FROM Person";
        return this.jdbcTemplate.query(sql, new PersonMapper());
    }

    public Person show(int id) {
        String sql = "SELECT * FROM Person WHERE id=?";
        return this.jdbcTemplate.query(
                sql,
                new Object[]{id},
                new PersonMapper()
        ).stream().findAny().orElse(null);
    }

    public void save(Person person) {
        String sql = "INSERT INTO Person VALUES(1,?,?,?)";
        this.jdbcTemplate.update(
                sql,
                person.getName(),
                person.getAge(),
                person.getEmail()
        );
    }

    public void update(int id, Person updatedPerson) {
        String sql = "UPDATE Person SET name=?, age=?, email=? WHERE id=?";
        this.jdbcTemplate.update(
                sql,
                updatedPerson.getName(),
                updatedPerson.getAge(),
                updatedPerson.getEmail(),
                id
        );
    }

    public void delete(int id) {
        String sql = "DELETE FROM Person WHERE id=?";
        this.jdbcTemplate.update(
                sql,
                id
        );
    }
}
