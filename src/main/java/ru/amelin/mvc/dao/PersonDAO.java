package ru.amelin.mvc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.amelin.mvc.models.Person;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


    public Optional<Person> show(String email) {
        return jdbcTemplate.query(
                "SELECT * FROM Person WHERE email=?",
                new Object[]{email},
                new PersonMapper()
        ).stream().findAny();

    }

    public void save(Person person) {
        String sql = "INSERT INTO Person (name, age, email, address) VALUES(?,?,?,?)";
        this.jdbcTemplate.update(
                sql,
                person.getName(),
                person.getAge(),
                person.getEmail(),
                person.getAddress()
        );
    }

    public void update(int id, Person updatedPerson) {
        String sql = "UPDATE Person SET name=?, age=?, email=?, address=? WHERE id=?";
        this.jdbcTemplate.update(
                sql,
                updatedPerson.getName(),
                updatedPerson.getAge(),
                updatedPerson.getEmail(),
                updatedPerson.getAddress(),
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

    public void batchUpdate() {
        List<Person> people = create1000People();
        jdbcTemplate.batchUpdate("INSERT INTO Person VALUES(?,?,?,?,?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setInt(1, people.get(i).getId());
                        ps.setString(2, people.get(i).getName());
                        ps.setInt(3, people.get(i).getAge());
                        ps.setString(4, people.get(i).getEmail());
                        ps.setString(5, people.get(i).getAddress());
                    }

                    @Override
                    public int getBatchSize() {
                        return people.size();
                    }
                });
    }

    private List<Person> create1000People() {
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            people.add(new Person(i, "Name" + i, 30, "test" + i + "@mail.ru", "some address"));
        }
        return people;
    }
}
