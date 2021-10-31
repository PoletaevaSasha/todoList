package com.demo.toDoList.repository;

import com.demo.toDoList.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, Long> {
}

