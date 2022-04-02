package com.gulbalasalamov.softwareengineerassignment.service;

import com.gulbalasalamov.softwareengineerassignment.entity.ToDoItem;
import com.gulbalasalamov.softwareengineerassignment.repository.ToDoItemRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE) // https://projectlombok.org/features/experimental/FieldDefaults
public class ToDoServiceImpl implements ToDoService {

    Logger logger = LoggerFactory.getLogger(ToDoServiceImpl.class);
    ToDoItemRepository toDoItemRepository;

    public ToDoServiceImpl(ToDoItemRepository toDoItemRepository) {
        this.toDoItemRepository = toDoItemRepository;
    }

    @Override
    public List<ToDoItem> getToDos() {
        //return (List<ToDoItem>) toDoItemRepository.findAll(); /
        return Streamable.of(toDoItemRepository.findAll()).toList();
    }

    @Override
    public ToDoItem createNewToDo(ToDoItem toDoItem) {
        toDoItemRepository.save(toDoItem);
        return toDoItem;
    }

    @Override
    public void deleteToDo(Long id) {
        try {
            toDoItemRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("deleteTodo {}", e.getMessage());
        }
    }

    @Override
    public Optional<ToDoItem> getToDo(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(ToDoItem toDoItem) {
        toDoItemRepository.save(toDoItem);
    }
}
