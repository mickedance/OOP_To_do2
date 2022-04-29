package org.example.model.sequencer;

public class ToDoItemTaskIdSequencer {

    private static int currentId = 0;

    public static int nextId() {
        return ++currentId;
    }

    public static int getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(Integer newId) {
        if (newId instanceof Integer == false) throw new IllegalArgumentException("newId was null");
        currentId = newId;
    }
}
