package org.example.Models;


import org.example.Models.Person;
import org.example.Models.ToDoItem;
import org.example.Models.ToDoItemTask;
import org.junit.Assert;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import java.time.LocalDate;

public class ToDoItemTaskTest {
    @Test(expected = Exception.class)
    public void _null_values_should_be_declined_0_param() {
        ToDoItemTask task = new ToDoItemTask(null, null);
    }

    @Test(expected = Exception.class)
    public void _null_values_should_be_declined_1_param() {
        Person person1 = new Person("Micke", "Alvarsson", "email.email.com");
        ToDoItem[] item = new ToDoItem[1];
        item[0] = new ToDoItem("Cykla", "5km", person1, LocalDate.now());
        ToDoItemTask task = new ToDoItemTask(item, null);
    }

    @Test
    public void _all_values_should_be_fine() {
        ToDoItemTask task = null;
        Person person1 = new Person("Micke", "Alvarsson", "email.email.com");
        ToDoItem[] item = new ToDoItem[1];
        item[0] = new ToDoItem("Cykla", "5km", person1, LocalDate.now());
        try {
            task = new ToDoItemTask(item, person1);
        } catch (Exception e) {
        }
        Assert.assertNotNull("Should not be null", task);
    }
}