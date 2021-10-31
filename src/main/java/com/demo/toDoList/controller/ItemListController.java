package com.demo.toDoList.controller;

import com.demo.toDoList.model.Item;
import com.demo.toDoList.service.ItemListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemListController {
    private final ItemListService itemListService;

    @PutMapping("/check/{id}")
    public Item checkItem(@PathVariable long id) {
        return itemListService.toggleItem(id);
    }
}
