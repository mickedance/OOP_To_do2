package org.example.dao.Implement;

import org.example.dao.ToDoItemTaskDAO;
import org.example.model.ToDoItemTask;

import java.util.ArrayList;
import java.util.List;

public class ToDoItemTaskDAOImplement implements ToDoItemTaskDAO {
    private List<ToDoItemTask> taskList;

    public ToDoItemTaskDAOImplement(){
        taskList = new ArrayList<>();
    }
    public void reset(){
        taskList.clear();
    }
    @Override
    public ToDoItemTask persist(ToDoItemTask toDoItemTask) {
        if (toDoItemTask == null) throw new IllegalArgumentException("TodoItemTask was null");
        if (taskList == null) taskList = new ArrayList<>();
        if (taskList.add(toDoItemTask))
            return toDoItemTask;

        return null;
    }

    @Override
    public ToDoItemTask findById(Integer id) {
        if (id == null) throw new IllegalArgumentException("id was null");
        for (ToDoItemTask t : taskList) {
            if (t.getId().intValue() == id.intValue())
                return t;
        }
        return null;
    }

    @Override
    public List<ToDoItemTask> findAll() {
        return taskList;
    }

    @Override
    public boolean remove(Integer id) {
        if (id == null) throw new IllegalArgumentException("Id was null");
        ToDoItemTask t = findById(id);
        if (t != null) return taskList.remove(t);
        return false;
    }

    @Override
    public List<ToDoItemTask> findByAssignedStatus(boolean b) {
        List<ToDoItemTask> listToReturn = new ArrayList<>();
        for (ToDoItemTask task : taskList) {
            if (task.isAssigned() == b)
                listToReturn.add(task);
        }
        return listToReturn;
    }

    @Override
    public List<ToDoItemTask> findByPersonId(Integer id) {
        if (id == null) throw new IllegalArgumentException("id was null");
        List<ToDoItemTask> listToReturn = new ArrayList<>();
        for (ToDoItemTask task : taskList) {
            if (task.getAssignee().getId().intValue() == id.intValue())
                listToReturn.add(task);
        }
        return listToReturn;
    }
}
