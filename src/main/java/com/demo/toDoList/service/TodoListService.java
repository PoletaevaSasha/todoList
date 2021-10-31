package com.demo.toDoList.service;

import com.demo.toDoList.model.TodoList;

import java.util.List;

public interface TodoListService {
    TodoList save(TodoList todoList);
    TodoList getById(long id);
    List<TodoList> findByRegexpName(String name);
    List<TodoList> getAll();
    void deleteById(long id);
}
