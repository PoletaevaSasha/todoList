package com.demo.toDoList.service.impl;

import com.demo.toDoList.model.Item;
import com.demo.toDoList.repository.ItemRepository;
import com.demo.toDoList.service.ItemListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemListServiceImpl implements ItemListService {
    private static final String NOT_EXISTS = "There is no item with the given id";
    private final ItemRepository itemRepository;

    @Override
    public Item toggleItem(long id) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        if (!optionalItem.isPresent()) {
            throw new IllegalArgumentException(NOT_EXISTS);
        }
        Item item = optionalItem.get();
        item.setChecked(!item.isChecked());
        return itemRepository.save(item);
    }
}
