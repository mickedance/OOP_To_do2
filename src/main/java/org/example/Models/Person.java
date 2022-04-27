package org.example.Models;

import java.util.Objects;

public class Person {
    private static int idCount;
    private Integer id;
    private String firstName;

    private String lastName;
    private String email;
    private AppUser appUser;

    /**
     * Constructor. Values has to be Non-null values, otherwise constructor throws an Exception
     *
     * @param firstName
     * @param lastName
     * @param email
     */
    public Person(String firstName, String lastName, String email) {
        // Validate
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);

        this.id = idCount++;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", appUser=" + appUser +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public Integer getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) {
            System.out.println("namefirst is null");
            throw new IllegalArgumentException("FirstName cannot be null");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) {
            throw new IllegalArgumentException("Lastname cannot be null");
        }
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException("Email cannot be null");
        }
        this.email = email;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        if (appUser == null) throw new IllegalArgumentException("appUser cannot be null");
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
}


