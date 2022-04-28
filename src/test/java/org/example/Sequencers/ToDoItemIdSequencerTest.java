package org.example.Sequencers;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class ToDoItemIdSequencerTest{
    @Test
    public void nextIdShouldBeOneMore(){
        int currentId = ToDoItemIdSequencer.getCurrentId();
        Assert.assertEquals(currentId+1, ToDoItemIdSequencer.nextId());
    }
    @Test
    public void shouldReturnNewSetValueOf25(){
        ToDoItemIdSequencer.setCurrentId(25);
        Assert.assertEquals(25, ToDoItemIdSequencer.getCurrentId());
    }
}