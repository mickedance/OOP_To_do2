package org.example.dao;

import org.example.model.Person;
import org.example.model.ToDoItem;
import org.example.model.ToDoItemTask;
import org.example.dao.ToDoItemTaskDAOImplement;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class ToDoItemTaskDAOImplementTest {

    private ToDoItemTaskDAOImplement toDoItemTaskDAOImplement = new ToDoItemTaskDAOImplement();

    private Person p1 = new Person("Micke", "sve", "mi@.com");
    private LocalDate date = LocalDate.parse("2020-04-02");

    private ToDoItem item1 = new ToDoItem("cykla", "go 5km", p1, date);
    private ToDoItem item2 = new ToDoItem("walk", "going 5km", p1, date);
    private ToDoItem item3 = new ToDoItem("skiing", "uphill 5km", p1, date);

    private ToDoItemTask task1 = new ToDoItemTask(new ToDoItem[]{item1, item2, item3}, p1);

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnException_persistWithNullValue() {
        toDoItemTaskDAOImplement.persist(null);
    }

    @Test
    public void shouldReturnSameValue_persistWithValue() {
        toDoItemTaskDAOImplement.reset();
        ToDoItem[] list1 = {item1, item2};
        ToDoItemTask task1 = new ToDoItemTask(list1, p1);

        Assert.assertEquals(task1, toDoItemTaskDAOImplement.persist(task1));
    }

    @Test
    public void shouldReturnNotSameValue_persistWith2Values() {
        toDoItemTaskDAOImplement.reset();
        ToDoItem[] list1 = {item1, item2};
        ToDoItemTask task1 = new ToDoItemTask(list1, p1);
        ToDoItem[] list2 = {item1, item2, item3};
        Person p = new Person("Mickeee", "sve", "mi444@.com");

        ToDoItemTask task2 = new ToDoItemTask(list2, p);
        Assert.assertNotSame(task2, toDoItemTaskDAOImplement.persist(task1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnException_findByIdWithNullValue() {
        toDoItemTaskDAOImplement.findById(null);
    }

    @Test
    public void shouldReturnNull_findByIdWithNonExistingValue() {
        Assert.assertNull(toDoItemTaskDAOImplement.findById(-1));
    }

    @Test
    public void shouldReturnSameObject_findByIdWithValue() {
        toDoItemTaskDAOImplement.reset();
        toDoItemTaskDAOImplement.persist(task1);
        Assert.assertEquals(task1, toDoItemTaskDAOImplement.findById(task1.getId()));
    }

    @Test
    public void shouldReturnNotNullObject_findAll() {
        List<ToDoItemTask> list = toDoItemTaskDAOImplement.findAll();
        Assert.assertNotNull(list);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnException_removeWithNullValue() {
        toDoItemTaskDAOImplement.remove(null);
    }

    @Test
    public void shouldReturnFalse_removeWithNonExistingValue() {
        Assert.assertFalse(toDoItemTaskDAOImplement.remove(-1));
    }

    @Test
    public void shouldReturnTrue_removeWithValue() {
        toDoItemTaskDAOImplement.reset();
        toDoItemTaskDAOImplement.persist(task1);
        Assert.assertTrue(toDoItemTaskDAOImplement.remove(task1.getId()));
    }

    @Test
    public void shouldReturn1LengthObject_findByAssignedStatusWithValue() {
        toDoItemTaskDAOImplement.reset();
        task1.setAssignee(null);
        toDoItemTaskDAOImplement.persist(task1);
        Person pTmp = new Person("mi", "ddd", "ee@ggg.com");
        ToDoItemTask tmpTask = new ToDoItemTask(new ToDoItem[]{item1, item2}, pTmp);
        toDoItemTaskDAOImplement.persist(tmpTask);
        Assert.assertEquals(1, toDoItemTaskDAOImplement.findByAssignedStatus(true).size());
    }

    @Test
    public void shouldReturn2LengthObject_findByAssignedStatusWithValue() {
        toDoItemTaskDAOImplement.reset();
        task1.setAssignee(null);
        toDoItemTaskDAOImplement.persist(task1);
        Person pTmp = new Person("mi", "ddd", "ee@ggg.com");
        ToDoItemTask tmpTask = new ToDoItemTask(new ToDoItem[]{item1, item2}, pTmp);
        tmpTask.setAssignee(null);
        toDoItemTaskDAOImplement.persist(tmpTask);
        Assert.assertEquals(2, toDoItemTaskDAOImplement.findByAssignedStatus(false).size());
    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnException_findByPersonIdWithNullValue() {
        toDoItemTaskDAOImplement.findByPersonId(null);
    }

    @Test
    public void shouldReturn1LengthObject_findByPersonIdWithValue() {

        Person pTmp = new Person("mi", "ddd", "ee@ggg.com");
        ToDoItemTask tmpTask = new ToDoItemTask(new ToDoItem[]{item1, item2}, pTmp);
        toDoItemTaskDAOImplement.reset();
        toDoItemTaskDAOImplement.persist(task1);
        toDoItemTaskDAOImplement.persist(tmpTask);

        Assert.assertEquals(1, toDoItemTaskDAOImplement.findByPersonId(pTmp.getId()).size());
    }

    @Test
    public void shouldReturn2LengthObject_findByPersonIdWithValue() {
        toDoItemTaskDAOImplement.reset();
        ToDoItemTask tmpTask = new ToDoItemTask(new ToDoItem[]{item1, item2}, p1);
        toDoItemTaskDAOImplement.reset();
        toDoItemTaskDAOImplement.persist(task1);
        toDoItemTaskDAOImplement.persist(tmpTask);

        Assert.assertEquals(2, toDoItemTaskDAOImplement.findByPersonId(p1.getId()).size());
    }



}