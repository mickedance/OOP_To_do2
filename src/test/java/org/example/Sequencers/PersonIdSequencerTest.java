package org.example.Sequencers;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class PersonIdSequencerTest {

    @Test
    public void nextIdShouldBeOneMore(){
        int currentId = PersonIdSequencer.getCurrentId();
        Assert.assertEquals(currentId+1, PersonIdSequencer.nextId());
    }
    @Test
    public void shouldReturnNewSetValueOf25(){
        PersonIdSequencer.setCurrentId(25);
        Assert.assertEquals(25, PersonIdSequencer.getCurrentId());
    }
}