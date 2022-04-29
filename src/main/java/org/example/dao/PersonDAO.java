package org.example.dao;

import org.example.model.Person;

public interface PersonDAO extends CrudInterface<Person, Integer>{
    Person findByEmail(String email);
    Person findById(Integer id);

}
