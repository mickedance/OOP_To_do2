package org.example.util;

import org.example.App;
import org.example.model.AppRole;
import org.example.model.AppUser;
import org.example.model.Person;
import org.example.model.ToDoItem;

import java.time.LocalDate;
import java.util.function.BiConsumer;

public interface Validation {

    BiConsumer<String, String> stringIsNotNullAndNotEmpty = (value, paramName) -> {
        if (value == null) throw new IllegalArgumentException(paramName + " was null");
        if (value.isEmpty()) throw new IllegalArgumentException(paramName + " was empty");
    };
    BiConsumer<AppRole, String> AppRoleIsNotEmpty = (value, paramName) -> {
        if (value == null) throw new IllegalArgumentException(paramName + " was null");
    };
    BiConsumer<AppUser, String> appUSerIsNotNull = (value, paramName) -> {
        if (value == null) throw new IllegalArgumentException(paramName + " was null");
    };
    BiConsumer<LocalDate, String> localDateIsNotNull = (value, paramName) -> {
        if (value == null) throw new IllegalArgumentException(paramName + " was null");
    };
    BiConsumer<Person, String> personIsNotNull = (value, paramName) -> {
        if (value == null) throw new IllegalArgumentException(paramName + " was null");
    };
    BiConsumer<ToDoItem[], String> manytoDoItemIsNotNull = (value, paramName) -> {
        if (value == null) throw new IllegalArgumentException(paramName + " was null");
    };
}
