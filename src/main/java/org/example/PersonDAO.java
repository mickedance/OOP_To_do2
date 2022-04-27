package org.example;

import org.example.Models.Person;

public interface PersonDAO extends CrudInterface<Person, Integer>{
    Person findByEmail(String email);
}
