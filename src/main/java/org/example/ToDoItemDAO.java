package org.example;

import org.example.Models.Person;
import org.example.Models.ToDoItem;
import org.omg.CORBA.INTERNAL;

import java.time.LocalDate;
import java.util.List;

public interface ToDoItemDAO extends CrudInterface<ToDoItem, Integer> {



    List<ToDoItem> findAllByDoneStatus();
    List<ToDoItem> findByTitleContains(String title);
    List<ToDoItem> findByPersonId(Integer id);
    List<ToDoItem> findByDeadlineBefore(LocalDate date);
    List<ToDoItem> findByDeadlineAfter(LocalDate date);
    ToDoItem  findById(Integer id);



}
