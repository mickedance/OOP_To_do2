package org.example.model;

import org.example.model.sequencer.PersonIdSequencer;
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

    @Test
    public void shouldReturnSameFirstName_getFirstName() {
        Person p = new Person("mick", "kinneberg", "mic@hooole.com");
        Assert.assertEquals("mick", p.getFirstName());
    }

    @Test
    public void shouldReturnSameId_getId() {
        Person p = new Person("mick", "kinneberg", "mic@hooole.com");
        Assert.assertEquals(PersonIdSequencer.getCurrentId().intValue(), p.getId().intValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnException_setFirstNameWithNullValue() {
        Person p = new Person("mick", "kinneberg", "mic@hooole.com");
        p.setFirstName(null);
    }

    @Test
    public void shouldSetFirstName_setFirstNameWithValue() {
        Person p = new Person("mick", "kinneberg", "mic@hooole.com");
        p.setFirstName("inneboy");
        Assert.assertEquals("inneboy", p.getFirstName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnException_setLastNameWithNullValue() {
        Person p = new Person("mick", "kinneberg", "mic@hooole.com");
        p.setLastName(null);
    }

    @Test
    public void shouldReturnSameLastName_getLastName() {
        Person p = new Person("mick", "kinneberg", "mic@hooole.com");
        Assert.assertEquals("kinneberg", p.getLastName());
    }

    @Test
    public void shouldReturnSameLastNameAsSet_getLastName() {
        Person p = new Person("mick", "kinneberg", "mic@hooole.com");
        p.setLastName("jo");
        Assert.assertEquals("jo", p.getLastName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnException_setEmailWithNullValue() {
        Person p = new Person("mick", "kinneberg", "mic@hooole.com");
        p.setEmail(null);
    }
    @Test
    public void shouldReturnSameEmailAsSet_setEmailWithValue() {
        Person p = new Person("mick", "kinneberg", "mic@hooole.com");
        p.setEmail("newEmail");
        Assert.assertEquals("newEmail", p.getEmail());
    }
    @Test
    public void shouldReturnNull_getAppUser() {
        Person p = new Person("mick", "kinneberg", "mic@hooole.com");
        Assert.assertEquals(null, p.getAppUser());
    }
    @Test
    public void shouldReturnSameAsSet_getAppUser() {
        Person p = new Person("mick", "kinneberg", "mic@hooole.com");
        AppUser user = new AppUser("ee","dd", AppRole.APP_ROLE_USER);
        p.setAppUser(user);
        Assert.assertEquals(user, p.getAppUser());
    }
    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnException_setAppuserWithNullValue(){
        Person p = new Person("mick", "kinneberg", "mic@hooole.com");
        p.setAppUser(null);
    }
}