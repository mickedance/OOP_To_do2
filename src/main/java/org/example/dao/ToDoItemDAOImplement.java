package org.example.dao;

import org.example.model.ToDoItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ToDoItemDAOImplement implements ToDoItemDAO {

    List<ToDoItem> toDoItemList;

    public ToDoItemDAOImplement(){
        toDoItemList = new ArrayList<>();
    }
    public void reset(){
        toDoItemList.clear();
    }
    @Override
    public ToDoItem persist(ToDoItem toDoItem) {
        if (toDoItem == null) throw new IllegalArgumentException("item to add was null");
        //Prevent duplicates
        for(ToDoItem item: toDoItemList){
            if(item.equals(toDoItem))
                throw new IllegalArgumentException("User already has that item in todolist, dupliactes not allowed");
        }
        if (toDoItemList == null) toDoItemList = new ArrayList<>();

        if (toDoItemList.add(toDoItem)) return toDoItem;

        return null;
    }

    @Override
    public ToDoItem findById(Integer id) {
        if (id == null) throw new IllegalArgumentException("id was null");

        for (ToDoItem item : toDoItemList) {
            if (item.getId().intValue() == id.intValue())
                return item;
        }
        return null;
    }

    @Override
    public List<ToDoItem> findAll() {
        return toDoItemList;
    }

    @Override
    public boolean remove(Integer id) {
        if (id == null) throw new IllegalArgumentException("id was null");
        ToDoItem itemToRemove = findById(id);
        if (itemToRemove == null)
            throw new IllegalArgumentException("could not find item with id: " + id + " to remove");
        return toDoItemList.remove(itemToRemove);
    }

    @Override
    public List<ToDoItem> findAllByDoneStatus() {
        List<ToDoItem> listToReturn = new ArrayList<>();
        for(ToDoItem item: toDoItemList){
            if(item.isDone())
                listToReturn.add(item);
        }
        return listToReturn;
    }

    @Override
    public List<ToDoItem> findByTitleContains(String title) {
        if(title==null) throw new IllegalArgumentException("title was null");
        List<ToDoItem> listToReturn = new ArrayList<>();
        for(ToDoItem item: toDoItemList){
            if(item.getTitle().contains(title))
                listToReturn.add(item);
        }
        return listToReturn;
    }

    @Override
    public List<ToDoItem> findByPersonId(Integer id) {
        if(id == null) throw new IllegalArgumentException("id was null");
        List<ToDoItem> listToReturn = new ArrayList<>();
        for(ToDoItem item: toDoItemList){
            if(item.getCreator().getId().intValue() == id.intValue() )
                listToReturn.add(item);
        }
        return listToReturn;
    }

    @Override
    public List<ToDoItem> findByDeadlineBefore(LocalDate date) {
        if(date==null) throw new IllegalArgumentException("date was null");
        List<ToDoItem> listToReturn = new ArrayList<>();
        for(ToDoItem item: toDoItemList){
            if(item.getDeadline().isBefore(date) )
                listToReturn.add(item);
        }
        return listToReturn;
    }

    @Override
    public List<ToDoItem> findByDeadlineAfter(LocalDate date) {
        if(date==null) throw new IllegalArgumentException("date was null");
        List<ToDoItem> listToReturn = new ArrayList<>();
        for(ToDoItem item: toDoItemList){
            if(!item.getDeadline().isBefore(date) )
                listToReturn.add(item);
        }
        return listToReturn;
    }
}
