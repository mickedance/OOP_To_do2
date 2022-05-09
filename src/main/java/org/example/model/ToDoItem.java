package org.example.model;


import org.example.model.sequencer.ToDoItemTaskIdSequencer;
import org.example.util.Validation;

import java.time.LocalDate;
import java.util.Objects;

public class ToDoItem {
    private static int idCount;
    private Integer id;


    private String title;
    private String description;
    private LocalDate deadline;
    private boolean done;
    private Person creator;

    /**
     * Constructor throws an Exception if someone of the parameters are null
     *
     * @param title
     * @param description
     * @param creator
     * @param deadline
     */
    public ToDoItem(String title, String description, Person creator, LocalDate deadline) {
        setTitle(title);
        setCreator(creator);
        setDescription(description);
        setDeadline(deadline);
        setId();
    }

    /**
     * See if deadline has passed for this task
     *
     * @return
     */
    public boolean isOverdue() {
        return LocalDate.now().isAfter(this.deadline);
    }

    @Override
    public String toString() {
        return "ToDoItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", done=" + done +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        Validation.stringIsNotNullAndNotEmpty.accept(title, "title");
        this.title = title;
    }

    public Integer getId() {
        return id;
    }


    private void setId() {
        this.id = ToDoItemTaskIdSequencer.nextId();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        Validation.localDateIsNotNull.accept(deadline, "deadline");
        this.deadline = deadline;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {

        this.done = done;
    }

    public Person getCreator() {
        return creator;
    }

    public void setCreator(Person creator) {
        Validation.personIsNotNull.accept(creator, "creator");
        this.creator = creator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDoItem toDoItem = (ToDoItem) o;
        return done == toDoItem.done && title.equals(toDoItem.title) && description.equals(toDoItem.description) && deadline.equals(toDoItem.deadline) && creator.equals(toDoItem.creator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, deadline, done, creator);
    }
}


