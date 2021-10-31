package com.demo.toDoList.repository;

import com.demo.toDoList.model.TodoList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TodoListRepository extends MongoRepository<TodoList, Long> {
    @Query("{ 'name' : { $regex: ?0 } }")
    List<TodoList> findByRegexpName(String regexp);
}
