package org.example;


import org.example.Models.Person;

public class App {

    private static Person person1;
    private static Person person2;

    public static void main(String[] args) {
        try {
            person1 = new Person("Micke", "Svensson", "micke@micke.com");
            person2 = new Person("Nise", "Ecresson", "micke@micdslfkke.com");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println(person1);
        System.out.println(person2);
    }
}
