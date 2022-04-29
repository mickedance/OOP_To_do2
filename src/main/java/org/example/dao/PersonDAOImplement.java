package org.example.dao;

import org.example.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDAOImplement implements PersonDAO {
    private List<Person> personList;

     public PersonDAOImplement() {
        personList = new ArrayList<>();
    }

    @Override
    public Person persist(Person person) {
        if (person == null) throw new IllegalArgumentException("person to add was null");
        if (personList == null) personList = new ArrayList<>();
        if(findByEmail(person.getEmail())!=null) throw new IllegalArgumentException("user with email: "+ person.getEmail()+ " already Exists");
        if (personList.add(person)) {
            return person;
        }
        return null;
    }

    @Override
    public Person findById(Integer id) {
        if (id == null) throw new IllegalArgumentException("id was null");
        for (Person p : personList) {
            if (id.intValue() == p.getId().intValue())
                return p;
        }
        return null;
    }

    @Override
    public List<Person> findAll() {
        return personList;
    }

    @Override
    public boolean remove(Integer id) {
        if (id == null) throw new IllegalArgumentException("Id was null");
        for (Person p : personList) {
            if (p.getId().equals(id))
                return personList.remove(p);
        }
        return false;
    }

    @Override
    public Person findByEmail(String email) {
        if (email == null) throw new IllegalArgumentException("email was null");
        for (Person p : personList) {
            if (p.getEmail().equalsIgnoreCase(email))
                return p;
        }
        return null;
    }
}
