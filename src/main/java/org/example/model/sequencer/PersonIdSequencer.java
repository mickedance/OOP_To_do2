package org.example.model.sequencer;

public class PersonIdSequencer {

    private static Integer currentId = 0;

    public static int nextId() {
        return ++currentId;
    }

    public static Integer getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(Integer newId) {
        if (newId == null) throw new IllegalArgumentException("newId was null");
        currentId = newId;

    }
}
