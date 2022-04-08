package org.example;


import java.time.LocalDate;

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

    /**
     * @return String of this instance information as a message
     */
    public String getSummary() {
        return "Title: " + title + " description: " + description + " deadline: " + deadline + " is completed: " + done + " by: " + creator.getFirstName() + "" + creator.getLastName();
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
}


/*
* id (private) is an int representing
each TodoItem object.
• title representing a title like
‘Change tires.’ Not allowed to be
null or empty
• description is used to hold further
information
• deadLine TodoItem is overdue if
current date > deadline. Not
allowed to be null
• done represent if task is finished
• creator represent who created this
task.*/