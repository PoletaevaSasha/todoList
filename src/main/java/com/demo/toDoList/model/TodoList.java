package com.demo.toDoList.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@ToString
@Document(collection = "List")
public class TodoList {
    @Transient
    public static final String SEQUENCE_NAME = "todoList_sequence";

    @Id
    private long id;
    private String name;
    @DBRef
    private List<Item> items;
}
