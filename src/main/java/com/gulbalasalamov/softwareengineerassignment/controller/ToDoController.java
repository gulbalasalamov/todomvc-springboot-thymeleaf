package com.gulbalasalamov.softwareengineerassignment.controller;

import com.gulbalasalamov.softwareengineerassignment.entity.ToDoItem;
import com.gulbalasalamov.softwareengineerassignment.exceptions.NotFoundException;
import com.gulbalasalamov.softwareengineerassignment.service.ToDoService;
import com.gulbalasalamov.softwareengineerassignment.service.ToDoServiceImpl;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * To wrap repository with a web layer, you must turn to Spring MVC.
 * API layer: The class that have all resources for API
 */


@Controller
@RequestMapping("api/v1/todo/")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ToDoController {
    Logger logger = LoggerFactory.getLogger(ToDoServiceImpl.class);
    final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping()
    public String mainPage(Model model) {
        model.addAttribute("item", new ToDoItemFormData());
        model.addAttribute("todos", toDoService.getToDos());
        model.addAttribute("totalNumberOfItems", toDoService.getToDos().size());
        return "index";
    }

    @PostMapping
    public String addNewTodoItem(@Valid @ModelAttribute("item") ToDoItemFormData todoItem) {
        toDoService.createNewToDo(new ToDoItem(todoItem.getTitle(), false));
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteTodoItem(@PathVariable("id") Long id) {
        toDoService.deleteToDo(id);
        return "redirect:/";
    }

    @PutMapping("/{id}/toggle")
    public String toggleSelection(@PathVariable("id") Long id) {
        ToDoItem toDoItem = toDoService.getToDo(id).orElseThrow(() -> new NotFoundException(id));
        toDoItem.setCompleted(!toDoItem.isCompleted());
        toDoService.save(toDoItem);
        return "redirect:/";
    }

    @PutMapping("/toggle-all")
    public String toggleAll() {
        List<ToDoItem> todoItems = toDoService.getToDos();
        for (ToDoItem todoItem : todoItems) {
            todoItem.setCompleted(!todoItem.isCompleted());
            toDoService.save(todoItem);
        }
        return "redirect:/";

    }
}
