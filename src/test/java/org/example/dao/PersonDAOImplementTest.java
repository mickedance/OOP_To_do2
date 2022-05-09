package org.example.dao;

import org.example.model.Person;
import org.example.dao.Implement.PersonDAOImplement;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PersonDAOImplementTest {
    private PersonDAOImplement personDAOImplement = new PersonDAOImplement();
    private Person p1 = new Person("micke1", "ericsson1", "1micke@test.com");
    private Person p2 = new Person("micke2", "ericsson2", "2micke@test.com");

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnException_persistWithNullValue() {
        personDAOImplement.persist(null);
    }

    @Test
    public void shouldReturnSameObject_persistWithValue() {
        Person p = new Person("micke", "ericsson", "micke@test.com");
        Person result = personDAOImplement.persist(p);
        Assert.assertEquals(p, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnException_persistWithDuplicateValue() {
        Person p = new Person("micke", "ericsson", "micke@test.com");
        personDAOImplement.persist(p);
        personDAOImplement.persist(p);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnException_findByIdWithNullValue() {
        personDAOImplement.findById(null);
    }

    @Test
    public void shouldReturnNull_findByIdWithNonExistingValue() {
        Assert.assertNull(personDAOImplement.findById(-1));
    }

    @Test
    public void shouldReturnObject_findByIdWithValue() {
        Person p = new Person("mick----e", "ericsson---", "micke@test.com");
        personDAOImplement.persist(p);
        Assert.assertEquals(p, personDAOImplement.findById(p.getId()));
    }

    @Test
    public void shouldReturnObject_findAll() {
        List<Person> result = personDAOImplement.findAll();
        Assert.assertNotNull(result);
        ;
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnException_removeWithNullValue() {
        personDAOImplement.remove(null);
    }

    @Test
    public void shouldReturnFalse_removeWithNonExistinglValue() {
        Assert.assertFalse(personDAOImplement.remove(-1));
    }

    @Test
    public void shouldReturnTrue_removeWithValue() {
        Person p = new Person("is", "mi", "mi@mi.se");
        personDAOImplement.persist(p);
        Assert.assertTrue(personDAOImplement.remove(p.getId()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnException_findByEmailWithNullValue() {
        personDAOImplement.findByEmail(null);
    }

    @Test
    public void shouldReturnFalse_findByEmailWithNonExistingValue() {
        Assert.assertNull(personDAOImplement.findByEmail("-"));
    }

    @Test
    public void shouldReturnObject_findByEmailWithValue() {
        Person p = new Person("is", "mi", "mi--@mi.se");
        personDAOImplement.persist(p);
        Assert.assertEquals(p, personDAOImplement.findByEmail(p.getEmail()));
    }

}