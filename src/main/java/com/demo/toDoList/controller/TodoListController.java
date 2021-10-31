package com.demo.toDoList.controller;

import com.demo.toDoList.model.Item;
import com.demo.toDoList.model.TodoList;
import com.demo.toDoList.service.TodoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lists")
@RequiredArgsConstructor
public class TodoListController {
    private final TodoListService todoListService;

    @PostMapping
    public TodoList addTodoList(@RequestBody TodoList todoList) {
        return todoListService.save(todoList);
    }

    @GetMapping
    public List<TodoList> getAll(@RequestParam(value = "name", required = false) String name) {
        return todoListService.findByRegexpName(name);
    }

    @GetMapping("/{id}")
    public TodoList getTodoList(@PathVariable long id) {
        return todoListService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTodoList(@PathVariable int id) {
        todoListService.deleteById(id);
    }
}
