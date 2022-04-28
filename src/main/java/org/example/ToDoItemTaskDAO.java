package org.example;

import org.example.Models.ToDoItemTask;

import java.util.List;

public interface ToDoItemTaskDAO extends CrudInterface<ToDoItemTask, Integer> {

    List<ToDoItemTask> findByAssignedStatus(boolean b);
    List<ToDoItemTask> findByPersonId(Integer id);
    ToDoItemTask findById(Integer id);
}
