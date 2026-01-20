package com.javacodex.unittesting.controller;

import com.javacodex.unittesting.business.ItemBusinessService;
import com.javacodex.unittesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class ItemController {

    @Autowired
    private ItemBusinessService businessService;
    @GetMapping("/dummy-item")
    public Item dummyItem(){

        return new Item(1,"Ball",10,100);
    }
    @GetMapping("/item-from-business-service")
    public Item itemFromBusinessService(){
        return businessService.retriveHardCodeItem();
    }
    @GetMapping("/all-items-from-database")
    public List<Item> retrieveAllItems(){
        List<Item> items = businessService.retrieveAllItems();
        for (Item item:items){
            item.setValue(item.getPrice() * item.getQuantity());
        }
        return items;
    }
}
