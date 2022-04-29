package org.example;


import org.example.model.Person;
import org.example.model.ToDoItem;
import org.example.model.ToDoItemTask;

import java.time.LocalDate;

public class App {


    public static void main(String[] args) {
        try {
            Person person1 = new Person("Micke", "Svensson", "micke@micke.com");
            Person person2 = new Person("Nise", "Ecresson", "micke@micdslfkke.com");

            ToDoItem item1 = new ToDoItem("Bike", "4km", person1, LocalDate.now());
            ToDoItem item2 = new ToDoItem("Bike with friend", "14km", person1, LocalDate.now());

            ToDoItemTask task1 = new ToDoItemTask(new ToDoItem[]{item1, item2}, person1);
            ToDoItemTask task2 = new ToDoItemTask(new ToDoItem[]{item1, item2});
            System.out.println("task1 = " + task1);
            System.out.println("task2 = " + task2);
            task2.setAssignee(person2);
            System.out.println("task2 = " + task2);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
