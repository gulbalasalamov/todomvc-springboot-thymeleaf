package com.gulbalasalamov.softwareengineerassignment.service;

import com.gulbalasalamov.softwareengineerassignment.entity.ToDoItem;

import java.util.List;
import java.util.Optional;

public interface ToDoService {
    List<ToDoItem> getToDos();
    ToDoItem createNewToDo(ToDoItem toDoItem);
    void deleteToDo(Long id);
    Optional<ToDoItem> getToDo(Long id);
    void save(ToDoItem toDoItem);
}
