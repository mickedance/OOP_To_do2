package org.example;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class ToDoItemTest {
    @Test(expected = Exception.class)
    public void _null_values_should_be_declined_todoItem_0_param() {
        ToDoItem item = new ToDoItem("", "", null, null);
    }

    @Test(expected = Exception.class)
    public void _null_values_should_be_declined_todoItem_1_param() {
        ToDoItem item = new ToDoItem("Cykla", "", null, null);
    }

    @Test(expected = Exception.class)
    public void _null_values_should_be_declined_todoItem_2_param() {
        ToDoItem item = new ToDoItem("Cykla", "5km uphill", null, null);
    }

    @Test(expected = Exception.class)
    public void _null_values_should_be_declined_todoItem_3_param() {
        Person creator1 = new Person("Nisse", "ALvarsson", "a@awesome.com");
        ToDoItem item = new ToDoItem("Cykla", "5km uphill", creator1, null);
    }

    @Test
    public void _all_values_Should_be_fine_todoItem() {
        Person creator1 = new Person("Nisse", "ALvarsson", "a@awesome.com");
        LocalDate d = LocalDate.now();
        ToDoItem item = new ToDoItem("Cykla", "5km uphill", creator1, d);
        Assert.assertNotNull("Should not be null", item);
    }

    @Test
    public void _overdue_should_return_true() {
        Person creator1 = new Person("Nisse", "ALvarsson", "a@awesome.com");
        LocalDate date = LocalDate.now();
        date = date.minusDays(1);
        ToDoItem item = new ToDoItem("Cykla", "5km uphill", creator1, date);
        Assert.assertTrue(item.isOverdue());
    }

    @Test
    public void _overdue_should_return_false() {
        Person creator1 = new Person("Nisse", "ALvarsson", "a@awesome.com");
        LocalDate date = LocalDate.now();
        date = date.plusDays(+1);
        ToDoItem item = new ToDoItem("Cykla", "5km uphill", creator1, date);
        Assert.assertFalse(item.isOverdue());
    }
}