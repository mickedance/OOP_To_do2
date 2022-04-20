package org.example;

import java.util.Arrays;
import java.util.Objects;

public class ToDoItemTask {
    public static int idCount;
    private int id;
    private boolean assigned;
    private ToDoItem[] todoItem;
    private Person assignee;

    /**
     * Constructor throws an Exception if someone of the params are null.
     *
     * @param item
     * @param assignee
     */
    public ToDoItemTask(ToDoItem[] item, Person assignee) {
        setAssignee(assignee);
        setTodoItem(item);
        this.id = idCount++;
        todoItem = new ToDoItem[0];
    }

    public boolean isAssigned() {
        return assigned;
    }

    public ToDoItem[] getTodoItem() {
        return todoItem;
    }

    public void setTodoItem(ToDoItem[] todoItem) {
        if (todoItem == null) {
            throw new IllegalArgumentException("TodoItem cannot be null");
        }
        this.todoItem = todoItem;
    }

    public Person getAssignee() {
        return assignee;
    }

    public int getId() {
        return id;
    }

    /**
     * When task is assigned with a non-null person we also set assigned boolean to true. If task is assigned with a null
     * value the assigned is set to false
     *
     * @param assignee
     */
    public void setAssignee(Person assignee) {
        if (assignee == null) {
            this.assigned = false;
            throw new IllegalArgumentException("Assignee cannot be null");
        } else {
            this.assigned = true;
            this.assignee = assignee;

        }
    }

    @Override
    public String toString() {
        return "ToDoItemTask{" +
                "id=" + id +
                ", assigned=" + assigned +
                ", todoItem=" + Arrays.toString(todoItem) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDoItemTask that = (ToDoItemTask) o;
        return Arrays.equals(todoItem, that.todoItem) && assignee.equals(that.assignee);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(assignee);
        result = 31 * result + Arrays.hashCode(todoItem);
        return result;
    }
}
