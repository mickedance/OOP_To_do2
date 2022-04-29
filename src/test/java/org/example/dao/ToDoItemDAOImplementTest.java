package org.example.dao;

import org.example.model.Person;
import org.example.model.ToDoItem;
import org.example.model.ToDoItemTask;
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
        item3.setDone(false);
        ToDoItem item4 = new ToDoItem("test-4", "ooo4", p1, date);
        item4.setDone(true);
        toDoItemDAOImplement.persist(item1);
        toDoItemDAOImplement.persist(item2);
        toDoItemDAOImplement.persist(item3);
        toDoItemDAOImplement.persist(item4);

        Assert.assertEquals(3, toDoItemDAOImplement.findAllByDoneStatus().size());
    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnException_findByTitleContainsWithNullValue() {
        toDoItemDAOImplement.findByTitleContains(null);
    }

    @Test
    public void shouldReturnThreeObject_findByTitleContainsWithValue() {
        toDoItemDAOImplement.reset();
        ToDoItem item1 = new ToDoItem("test-1", "ooo1", p1, date);
        ToDoItem item2 = new ToDoItem("test-2", "ooo2", p1, date);
        ToDoItem item3 = new ToDoItem("test-3", "ooo3", p1, date);
        ToDoItem item4 = new ToDoItem("test-4", "ooo4", p1, date);
        toDoItemDAOImplement.persist(item1);
        toDoItemDAOImplement.persist(item2);
        toDoItemDAOImplement.persist(item3);
        toDoItemDAOImplement.persist(item4);

        List<ToDoItem> list = toDoItemDAOImplement.findByTitleContains("test");
        Assert.assertEquals(4, list.size());
    }

    @Test
    public void shouldReturnZeroLengthObject_findByTitleContainsWithValue() {
        toDoItemDAOImplement.reset();
        ToDoItem item1 = new ToDoItem("test-1", "ooo1", p1, date);
        ToDoItem item2 = new ToDoItem("test-2", "ooo2", p1, date);
        ToDoItem item3 = new ToDoItem("test-3", "ooo3", p1, date);
        ToDoItem item4 = new ToDoItem("test-4", "ooo4", p1, date);
        toDoItemDAOImplement.persist(item1);
        toDoItemDAOImplement.persist(item2);
        toDoItemDAOImplement.persist(item3);
        toDoItemDAOImplement.persist(item4);
        List<ToDoItem> list = toDoItemDAOImplement.findByTitleContains("p");
        Assert.assertEquals(0, list.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnException_findByPersonIdWithNullValue() {
        toDoItemDAOImplement.findByPersonId(null);
    }

    @Test
    public void shouldReturnZeroLengthObject_findByPersonIdWithNonExistingValue() {
        List<ToDoItem> list = toDoItemDAOImplement.findByPersonId(-1);
        Assert.assertEquals(0, list.size());
    }

    @Test
    public void shouldReturnFourLengthObject_findByPersonIdWithValue() {
        toDoItemDAOImplement.reset();
        Person p2 = new Person("Micke3", "sve3", "md3i@.com");

        ToDoItem item1 = new ToDoItem("test-1", "ooo1", p1, date);
        ToDoItem item2 = new ToDoItem("test-2", "ooo2", p1, date);
        ToDoItem item3 = new ToDoItem("test-3", "ooo3", p2, date);
        ToDoItem item4 = new ToDoItem("test-4", "ooo4", p1, date);
        toDoItemDAOImplement.persist(item1);
        toDoItemDAOImplement.persist(item2);
        toDoItemDAOImplement.persist(item3);
        toDoItemDAOImplement.persist(item4);
        List<ToDoItem> list = toDoItemDAOImplement.findByPersonId(p1.getId());
        Assert.assertEquals(3, list.size());
    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnException_findByDeadlineBeforeWithNullValue() {
        toDoItemDAOImplement.findByDeadlineBefore(null);
    }

    @Test
    public void shouldReturn2LengthObject_findByDeadlineBeforeWithValue() {
        toDoItemDAOImplement.reset();
        LocalDate newDate = date.minusDays(10);
        ToDoItem item1 = new ToDoItem("test-1", "ooo1", p1, date);
        ToDoItem item2 = new ToDoItem("test-2", "ooo2", p1, newDate);
        ToDoItem item3 = new ToDoItem("test-3", "ooo3", p1, date);
        ToDoItem item4 = new ToDoItem("test-4", "ooo4", p1, newDate);
        toDoItemDAOImplement.persist(item1);
        toDoItemDAOImplement.persist(item2);
        toDoItemDAOImplement.persist(item3);
        toDoItemDAOImplement.persist(item4);
        List<ToDoItem> result = toDoItemDAOImplement.findByDeadlineBefore(date);
        Assert.assertEquals(2, result.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnException_findByDeadlineAfterWithNullValue() {
        toDoItemDAOImplement.findByDeadlineAfter(null);
    }

    @Test
    public void shouldReturn2LengthObject_findByDeadlineAfterWithValue() {
        toDoItemDAOImplement.reset();
        LocalDate newDate = date.minusDays(10);
        ToDoItem item1 = new ToDoItem("test-1", "ooo1", p1, date);
        ToDoItem item2 = new ToDoItem("test-2", "ooo2", p1, newDate);
        ToDoItem item3 = new ToDoItem("test-3", "ooo3", p1, date);
        ToDoItem item4 = new ToDoItem("test-4", "ooo4", p1, newDate);
        ToDoItem item5 = new ToDoItem("test-5", "ooo5", p1, date);

        toDoItemDAOImplement.persist(item1);
        toDoItemDAOImplement.persist(item2);
        toDoItemDAOImplement.persist(item3);
        toDoItemDAOImplement.persist(item4);
        toDoItemDAOImplement.persist(item5);


        List<ToDoItem> result = toDoItemDAOImplement.findByDeadlineAfter(newDate.plusDays(1));
        Assert.assertEquals(3, result.size());
    }

    public static class ToDoItemTaskDAOImplementTest {
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

        public void testFindByPersonId() {
        }
    }
}