package org.example;

public class Person {
    private static int idCount;
    private int id;
    private String firstName;
    private String lastName;
    private String email;

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

    /**
     * @return a string with summary of instance
     */
    public String getSummary() {
        return "Id: " + id + " Name: " + firstName + " " + lastName + " Email: " + email;
    }

    public String getFirstName() {
        return firstName;
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
}


