package com.demo.toDoList.service;

import com.demo.toDoList.model.Item;

public interface ItemListService {
    Item toggleItem(long id);
}
