package com.gulbalasalamov.softwareengineerassignment.service;

import com.gulbalasalamov.softwareengineerassignment.entity.ToDoItem;
import com.gulbalasalamov.softwareengineerassignment.repository.ToDoRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE) // https://projectlombok.org/features/experimental/FieldDefaults
public class ToDoServiceImpl implements ToDoService{

    ToDoRepository toDoRepository;

    public ToDoServiceImpl(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @Override
    public List<ToDoItem> getToDos() {
        return null;
    }

    @Override
    public ToDoItem createNewToDo(ToDoItem toDoItem) {
        return null;
    }

    @Override
    public void deleteToDo(Long id) {

    }

    @Override
    public Optional<ToDoItem> getToDo(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(ToDoItem toDoItem) {

    }
}
