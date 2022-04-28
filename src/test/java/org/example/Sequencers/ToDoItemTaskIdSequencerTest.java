package org.example.Sequencers;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class ToDoItemTaskIdSequencerTest{

    @Test
    public void nextIdShouldBeOneMore(){
        int currentId = ToDoItemTaskIdSequencer.getCurrentId();
        Assert.assertEquals(currentId+1, ToDoItemTaskIdSequencer.nextId());
    }
    @Test
    public void shouldReturnNewSetValueOf25(){
        ToDoItemTaskIdSequencer.setCurrentId(25);
        Assert.assertEquals(25, ToDoItemTaskIdSequencer.getCurrentId());
    }

}