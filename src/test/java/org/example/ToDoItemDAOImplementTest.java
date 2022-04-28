package org.example;

import junit.framework.TestCase;
import org.example.Models.Person;
import org.example.Models.ToDoItem;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class ToDoItemDAOImplementTest {
    private ToDoItemDAOImplement toDoItemDAOImplement = new ToDoItemDAOImplement();
    private Person p1 = new Person("Micke", "sve", "mi@.com");
    private LocalDate date = LocalDate.parse("2020-04-02");
    ToDoItem item1 = new ToDoItem("cykla", "5km", p1, date);


    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnException_persistWithNullValue() {
        toDoItemDAOImplement.persist(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnException_persistWithDuplicateValues() {
        ToDoItem item = new ToDoItem("XXXX-X", "desc", p1, date);
        toDoItemDAOImplement.persist(item);
        toDoItemDAOImplement.persist(item);
    }

    @Test
    public void shouldReturnSameObject_persistWithValue() {
        ToDoItem item = new ToDoItem("title", "desc", p1, date);
        Assert.assertEquals(item, toDoItemDAOImplement.persist(item));
    }

    @Test
    public void shouldReturnNull_findByIdWithNonExistingValue() {
        Assert.assertNull(toDoItemDAOImplement.findById(-1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnException_findByIdWithNullValue() {
        toDoItemDAOImplement.findById(null);
    }

    @Test
    public void shouldReturnObject_findByIdWithValue() {
        ToDoItem item = new ToDoItem("ppp", "ddd", p1, date);
        Assert.assertEquals(item, toDoItemDAOImplement.persist(item));
    }

    @Test
    public void shouldReturnListOfToDoItems_findAll() {
        List<ToDoItem> list = toDoItemDAOImplement.findAll();
        Assert.assertNotNull(list);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnException_removeWithNullValue() {
        toDoItemDAOImplement.remove(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnException_removeWithNonExistingValue() {
        toDoItemDAOImplement.remove(-1);
    }

    @Test
    public void shouldReturnTrue_removeWithValue() {
        ToDoItem item = new ToDoItem("ii", "ddd", p1, date);
        toDoItemDAOImplement.persist(item);
        Assert.assertTrue(toDoItemDAOImplement.remove(item.getId()));
    }


    @Test
    public void shouldReturnThreeObject_findByDoneStatusTrue() {
        toDoItemDAOImplement.reset();
        ToDoItem item1 = new ToDoItem("test-1", "ooo1", p1, date);
        item1.setDone(true);
        ToDoItem item2 = new ToDoItem("test-2", "ooo2", p1, date);
        item2.setDone(true);
        ToDoItem item3 = new ToDoItem("test-3", "ooo3", p1, date);
        item3.setDone(true);
        toDoItemDAOImplement.persist(item1);
        toDoItemDAOImplement.persist(item2);
        toDoItemDAOImplement.persist(item3);

        Assert.assertEquals(3, toDoItemDAOImplement.findAllByDoneStatus().size());
    }

    public void testFindAllByDoneStatus() {
    }

    public void testFindByTitleContains() {
    }

    public void testFindByPersonId() {
    }

    public void testFindByDeadlineBefore() {
    }

    public void testFindByDeadlineAfter() {
    }
}