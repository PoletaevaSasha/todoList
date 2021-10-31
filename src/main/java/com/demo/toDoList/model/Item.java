package com.demo.toDoList.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document(collection = "Item")
public class Item {
    @Transient
    public static final String SEQUENCE_NAME = "item_sequence";
    @Id
    private long id;
    private String name;
    private int count;
    private boolean checked;
}
