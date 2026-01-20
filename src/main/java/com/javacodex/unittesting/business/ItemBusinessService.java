package com.javacodex.unittesting.business;

import com.javacodex.unittesting.data.ItemRepository;
import com.javacodex.unittesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemBusinessService {
    @Autowired
    private ItemRepository itemRepository;

    public Item retriveHardCodeItem() {
        return new Item(1, "Ball", 10, 100);
    }

    public List<Item> retrieveAllItems() {
        return itemRepository.findAll();
    }
}
