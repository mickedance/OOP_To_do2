package org.example.model;


import org.junit.Assert;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import java.time.LocalDate;

public class ToDoItemTaskTest {
    private LocalDate date1 = LocalDate.now().minusDays(10);
    private Person p1 = new Person("micke", "jj", "ii@.comcom");
    private ToDoItem item1 = new ToDoItem("Cykla", "uphill", p1, date1);
    private ToDoItem item2 = new ToDoItem("Cykla with friends", "uphill 7km", p1, date1);
    private ToDoItemTask task1 = new ToDoItemTask(new ToDoItem[]{item1, item2}, p1);

    @Test(expected = Exception.class)
    public void _null_values_should_be_declined_0_param() {
        ToDoItemTask task = new ToDoItemTask(null, null);
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

    @Test
    public void shouldReturnNull_getAssignee() {
        ToDoItemTask task = new ToDoItemTask(new ToDoItem[]{item1, item2});
        Assert.assertNull(task.getAssignee());
    }
    @Test
    public void shouldReturnNull_getAssignee2() {
        ToDoItemTask task = new ToDoItemTask(new ToDoItem[]{item1, item2}, p1);
        task.setAssignee(null);
        Assert.assertNull(task.getAssignee());
    }

    @Test
    public void shouldReturnSetAssignee_getAssignee() {
        ToDoItemTask task = new ToDoItemTask(new ToDoItem[]{item1, item2});
        task.setAssignee(p1);
        Assert.assertEquals(p1, task.getAssignee());
    }

    @Test
    public void shouldReturnAssignee_getAssignee() {
        ToDoItemTask task = new ToDoItemTask(new ToDoItem[]{item1, item2}, p1);
        Assert.assertEquals(p1, task.getAssignee());
    }

    @Test
    public void shouldReturnFalse_isAssignee() {
        ToDoItemTask task = new ToDoItemTask(new ToDoItem[]{item1, item2});
        Assert.assertFalse(task.isAssigned());
    }

    @Test
    public void shouldReturnTrue_isAssignee() {
        ToDoItemTask task = new ToDoItemTask(new ToDoItem[]{item1, item2}, p1);
        Assert.assertTrue(task.isAssigned());
    }

    @Test
    public void shouldReturnTrue_isAssignee2() {
        ToDoItemTask task = new ToDoItemTask(new ToDoItem[]{item1, item2});
        task.setAssignee(p1);
        Assert.assertTrue(task.isAssigned());
    }
}