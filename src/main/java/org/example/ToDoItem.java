package org.example;


import java.time.LocalDate;
import java.util.Objects;

public class ToDoItem {
    private static int idCount;
    private int id;
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
     * @param person
     * @param deadline
     */
    public ToDoItem(String title, String description, Person creator, LocalDate deadline) {
        id = idCount++;
        setTitle(title);
        setCreator(creator);
        setDescription(description);
        setDeadline(deadline);
        id = idCount++;
    }

    /**
     * See if deadline has passed for this task
     *
     * @return
     */
    public boolean isOverdue() {
        LocalDate date = LocalDate.now();
        if (date.isAfter(this.deadline)) {
            return true;
        }
        return false;
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
        if (title == null) {
            throw new IllegalArgumentException("title cannot be null");
        }
        this.title = title;
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
        if (deadline == null) {
            throw new IllegalArgumentException("Deadline cannot be null");
        }
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
        if (creator == null) {
            throw new IllegalArgumentException("creator cannot be null");
        }
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


