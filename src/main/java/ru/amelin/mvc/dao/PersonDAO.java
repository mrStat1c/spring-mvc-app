package ru.amelin.mvc.dao;

import org.springframework.stereotype.Component;
import ru.amelin.mvc.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Tom", 24, "sdf@dfg.drg"));
        people.add(new Person(++PEOPLE_COUNT, "Jack", 30, "fsd@og.ty"));
        people.add(new Person(++PEOPLE_COUNT, "Martin", 17, "jtgy@fdg.hg"));
        people.add(new Person(++PEOPLE_COUNT, "Maria", 20, "tfh@,pdf.dg"));
    }

    public List<Person> index() {
        return this.people;
    }

    public Person show(int id) {
        return this.people.stream()
                .filter(person -> person.getId() == id)
                .findAny()
                .orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id){
        people.removeIf(person -> person.getId() == id);
    }
}
