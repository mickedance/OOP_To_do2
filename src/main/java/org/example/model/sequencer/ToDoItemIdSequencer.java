package org.example.model.sequencer;

public class ToDoItemIdSequencer {
    private static Integer currentId = 0;

    public static Integer nextId() {
        return ++currentId;
    }

    public static Integer getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(Integer newId) {
        if (newId instanceof Integer == false) throw new IllegalArgumentException("newId was null");
        currentId = newId;
    }
}
