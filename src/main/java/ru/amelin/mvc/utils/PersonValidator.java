package ru.amelin.mvc.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.amelin.mvc.dao.PersonDAO;
import ru.amelin.mvc.models.Person;

/**
 * Для более сложной валидации полей форм (например, когда нужно ходить в бд для проверки уникальности значения поля)
 */
@Component
public class PersonValidator implements Validator {

    private final PersonDAO personDAO;

    @Autowired
    public PersonValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    // настройка классов, для которых используется валидатор
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        //проверяем, есть если ли человек с таким же email в бд
        if (personDAO.show(person.getEmail()).isPresent()) {
            errors.rejectValue("email", "", "This email is already taken");
        }

    }
}