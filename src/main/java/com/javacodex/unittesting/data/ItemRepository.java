package com.javacodex.unittesting.data;

import com.javacodex.unittesting.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository  extends JpaRepository<Item,Integer> {
    //public Item findById();
}
