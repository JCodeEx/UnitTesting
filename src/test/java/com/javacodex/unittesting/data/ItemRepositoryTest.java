package com.javacodex.unittesting.data;

import com.javacodex.unittesting.model.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;


@SpringBootTest
//@DataRedisTest
public class ItemRepositoryTest {
    @Autowired
    private ItemRepository repository;

    @Test
    public void testFindAll() {
List<Item>items=repository.findAll();
assertEquals(4,items.size());
    }
}
