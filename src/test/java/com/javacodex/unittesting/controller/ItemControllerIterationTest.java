package com.javacodex.unittesting.controller;

import com.javacodex.unittesting.UnitTestingApplication;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

/*@SpringBootTest(
        classes = UnitTestingApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)*/
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerIterationTest {
    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    public void contextLoads() throws JSONException {
        String response = restTemplate.getForObject("/all-items-from-database", String.class);
        JSONAssert
                .assertEquals("[{id:10001},{id:10002},{id:10003},{id:10004}]",response,false);
    }
    }

