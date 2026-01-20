package com.javacodex.unittesting.business;

import com.javacodex.unittesting.model.Item;
import org.springframework.stereotype.Service;

@Service
public class ItemBusinessService {

    public Item retriveHardCodeItem() {
return  new Item(1,"Ball",10,100);
    }
}
