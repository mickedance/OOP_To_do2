package org.example.model;

import org.example.model.sequencer.ToDoItemIdSequencer;
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

    @Test
    public void shouldReturnSameTitle_getTitle() {
        ToDoItem item = new ToDoItem("hiking", "5km", new Person("m", "e", "@com"), LocalDate.now());
        Assert.assertEquals("hiking", item.getTitle());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnException_setTitleWithNullValue() {
        ToDoItem item = new ToDoItem("hiking", "5km", new Person("m", "e", "@com"), LocalDate.now());
        item.setTitle(null);
    }

    @Test
    public void shouldReturnSameTitleAsSet_setTitleWithValue() {
        ToDoItem item = new ToDoItem("hiking", "5km", new Person("m", "e", "@com"), LocalDate.now());
        item.setTitle("new Title");
        Assert.assertEquals("new Title", item.getTitle());
    }

    @Test
    public void shouldReturnSameDescription_setDescription() {
        ToDoItem item = new ToDoItem("hiking", "5km", new Person("m", "e", "@com"), LocalDate.now());
        item.setDescription("new Desc");
        Assert.assertEquals("new Desc", item.getDescription());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnNull_setDeadlineWithNullValue() {
        ToDoItem item = new ToDoItem("hiking", "5km", new Person("m", "e", "@com"), LocalDate.now());
        item.setDeadline(null);
    }

    @Test
    public void shouldReturnSameDeadline_setDeadlineWithValue() {
        LocalDate date = LocalDate.now().minusDays(10);
        ToDoItem item = new ToDoItem("hiking", "5km", new Person("m", "e", "@com"), date);
        Assert.assertEquals(date, item.getDeadline());
    }

    @Test
    public void shouldReturnFalse_isDone() {
        LocalDate date = LocalDate.now().minusDays(10);
        ToDoItem item = new ToDoItem("hiking", "5km", new Person("m", "e", "@com"), date);
        Assert.assertFalse(item.isDone());
    }

    @Test
    public void shouldReturnTrue_setDone() {
        LocalDate date = LocalDate.now().minusDays(10);
        ToDoItem item = new ToDoItem("hiking", "5km", new Person("m", "e", "@com"), date);
        item.setDone(true);
        Assert.assertTrue(item.isDone());
    }

    @Test
    public void shouldReturnFalse_setDone2() {
        LocalDate date = LocalDate.now().minusDays(10);
        ToDoItem item = new ToDoItem("hiking", "5km", new Person("m", "e", "@com"), date);
        item.setDone(false);
        Assert.assertFalse(item.isDone());
    }

    @Test
    public void shouldReturnPersonAsSet_setCreatorWithValue() {
        Person p = new Person("jj", "ooo", "f@.com");
        ToDoItem item = new ToDoItem("hiking", "5km", new Person("m", "e", "@com"), LocalDate.now());
        item.setCreator(p);
        Assert.assertEquals(p, item.getCreator());
    }
    @Test
    public void shouldReturnPersonAsSetInConstructor_setCreatorWithValue() {
        Person p = new Person("jj", "ooo", "f@.com");
        ToDoItem item = new ToDoItem("hiking", "5km", p, LocalDate.now());
        item.setCreator(p);
        Assert.assertEquals(p, item.getCreator());
    }
    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnException_setCreatorWithNullValue() {
        Person p = new Person("jj", "ooo", "f@.com");
        ToDoItem item = new ToDoItem("hiking", "5km", p, LocalDate.now());
        item.setCreator(null);
    }
}