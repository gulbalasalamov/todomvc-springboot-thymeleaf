package com.gulbalasalamov.softwareengineerassignment.controller;

import com.gulbalasalamov.softwareengineerassignment.service.ToDoService;
import com.gulbalasalamov.softwareengineerassignment.service.ToDoServiceImpl;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * To wrap repository with a web layer, you must turn to Spring MVC.
 * API layer: The class that have all resources for API
 * */


@RestController
@RequestMapping("api/v1/todo")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ToDoController {
    Logger logger = LoggerFactory.getLogger(ToDoServiceImpl.class);
    final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping()
    public String mainPage(Model model){
        model.addAttribute("item",new ToDoItemFormData());
    }


}
