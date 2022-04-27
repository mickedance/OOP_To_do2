package org.example;

import java.util.List;

public interface CrudInterface<T, idType> {

    T persist(T t);
    T findById(idType id);
    List<T> findAll();
    boolean remove(idType id);
}
