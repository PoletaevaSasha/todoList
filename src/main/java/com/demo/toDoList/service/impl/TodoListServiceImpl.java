package com.demo.toDoList.service.impl;

import com.demo.toDoList.model.Item;
import com.demo.toDoList.model.TodoList;
import com.demo.toDoList.repository.ItemRepository;
import com.demo.toDoList.repository.TodoListRepository;
import com.demo.toDoList.service.SequenceGeneratorService;
import com.demo.toDoList.service.TodoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class TodoListServiceImpl implements TodoListService {

    private static final String NOT_EXISTS = "There is no TodoList with given id";
    private final TodoListRepository todoListRepository;
    private final ItemRepository itemRepository;
    private final SequenceGeneratorService sequenceGenerator;

    @Override
    public TodoList save(TodoList todoList) {
        initIds(todoList);
        itemRepository.saveAll(todoList.getItems());
        return todoListRepository.save(todoList);
    }

    @Override
    public TodoList getById(long id) {
        Optional<TodoList> todoList = todoListRepository.findById(id);
        if (!todoList.isPresent()) {
            throw new IllegalArgumentException(NOT_EXISTS);
        }
        return todoList.get();
    }

    @Override
    public List<TodoList> findByRegexpName(String name) {
        if (name == null) {
            return todoListRepository.findAll();
        }
        return todoListRepository.findByRegexpName(name);
    }

    @Override
    public List<TodoList> getAll() {
        return todoListRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        Optional<TodoList> todoList = todoListRepository.findById(id);
        if (!todoList.isPresent()) {
            throw new IllegalArgumentException(NOT_EXISTS);
        }
        itemRepository.deleteAll(todoList.get().getItems());
        todoListRepository.deleteById(id);
    }

    private void initIds(TodoList todoList) {
        todoList.setId(sequenceGenerator.generateSequence(TodoList.SEQUENCE_NAME));
        for (Item item : todoList.getItems()) {
            item.setId(sequenceGenerator.generateSequence(Item.SEQUENCE_NAME));
        }
    }
}
