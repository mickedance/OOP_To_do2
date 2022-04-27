package org.example.Sequencers;

public class ToDoItemIdSequencer {
    private static int currentId;

    public static int nextId() {
        return ++currentId;
    }

    public static int getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(Integer newId) {
        if(newId instanceof  Integer==false) throw new IllegalArgumentException("newId was null");
        currentId = newId;
    }
}
