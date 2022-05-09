package org.example.model;

import org.example.model.sequencer.ToDoItemTaskIdSequencer;
import org.example.util.Validation;

import java.util.Arrays;
import java.util.Objects;

public class ToDoItemTask {

    private Integer id;
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
        setId();
        setTodoItem(item);
    }

    /**
     * Constructor throws an Exception if someone of the params are null.
     *
     * @param item
     */
    public ToDoItemTask(ToDoItem[] item) {
        setTodoItem(item);
        setId();
    }

    /**
     * Constructor throws an Exception if someone of the params are null.
     *
     * @param assignee
     */
    public ToDoItemTask(Person assignee) {
        setAssignee(assignee);
        setId();
    }

    public boolean isAssigned() {
        return assigned;
    }

    public ToDoItem[] getTodoItem() {
        return todoItem;
    }

    public void setTodoItem(ToDoItem[] todoItem) {
        Validation.manytoDoItemIsNotNull.accept(todoItem, "todoItem ");
        this.todoItem = todoItem;
    }

    public Person getAssignee() {
        return assignee;
    }

    public Integer getId() {
        return id;
    }
    private void setId() {
        this.id = ToDoItemTaskIdSequencer.nextId();
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
        } else {
            this.assigned = true;
        }
        this.assignee = assignee;
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
