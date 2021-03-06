package org.example.model;

import org.example.model.sequencer.PersonIdSequencer;
import org.example.util.Validation;

import java.util.Objects;

public class Person {
    //private static int idCount;
    private Integer id;
    private String firstName;

    private String lastName;
    private String email;
    private AppUser appUser;

    /**
     * Constructor. Values has to be Non-null values, otherwise constructor throws an Exception
     */
    public Person(String firstName, String lastName, String email) {
        // Validate
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setId();
    }

    public String getFirstName() {
        return firstName;
    }

    private void setId() {
        this.id = PersonIdSequencer.nextId();
    }

    public Integer getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        Validation.stringIsNotNullAndNotEmpty.accept(firstName, "firstName");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        Validation.stringIsNotNullAndNotEmpty.accept(lastName, "lastName");

        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        Validation.stringIsNotNullAndNotEmpty.accept(email, "email");

        this.email = email;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        Validation.appUSerIsNotNull.accept(appUser, "appUser");
        this.appUser = appUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return firstName.equals(person.firstName) && lastName.equals(person.lastName) && email.equals(person.email) && appUser.equals(person.appUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, appUser);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", appUser=" + appUser +
                '}';
    }
}


