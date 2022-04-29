package org.example.model.sequencer;

import org.example.model.sequencer.ToDoItemIdSequencer;
import org.junit.Assert;
import org.junit.Test;

public class ToDoItemIdSequencerTest{
    @Test
    public void nextIdShouldBeOneMore(){
        int currentId = ToDoItemIdSequencer.getCurrentId();
        Assert.assertEquals(currentId+1, ToDoItemIdSequencer.nextId().intValue());
    }
    @Test
    public void shouldReturnNewSetValueOf25(){
        ToDoItemIdSequencer.setCurrentId(25);
        Assert.assertEquals(25, ToDoItemIdSequencer.getCurrentId().intValue());
    }
}