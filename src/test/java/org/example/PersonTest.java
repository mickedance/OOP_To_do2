package org.example;

import org.example.Models.Person;
import org.junit.Assert;
import org.junit.Test;

public class PersonTest {
    @Test(expected = Exception.class)
    public void _null_values_should_be_declined_0_param() {
        Person p1 = new Person("", null, null);
    }

    @Test(expected = Exception.class)
    public void _null_values_should_be_declined_1_param() {
        Person p1 = new Person("Mikael", null, null);
    }

    @Test(expected = Exception.class)
    public void _null_values_should_be_declined_2_param() {
        Person p1 = new Person("Mikael", "Svensson", null);
    }

    @Test
    public void _with_all_params_should_be_fine() {
        Person p1 = null;
        String fName = "Micke";
        String lName = "Eriksson";
        String email = "erik@eriksson.se";
        try {
            p1 = new Person(fName, lName, email);
        } catch (Exception e) {
        }
        Assert.assertNotNull("Should not be null", p1);
    }
}