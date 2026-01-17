package com.javacodex.unittesting.controller;


import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static java.lang.Boolean.TRUE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//@WebMvcTest(HelloWorldController.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void dummyItem_basic() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\": 1 ,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
                .andReturn();
        String expected="{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
       JSONAssert.assertEquals(expected,mvcResult.getResponse().getContentAsString(),false);
        //assertEquals("Hello World", mvcResult.getResponse().getContentAsString());


    /* call to url -- /hello-world via GET method and response will be like
    Application/json .
    // need verify the return is HelloWorld
    To call the url we have mockMvc.perform() method.
    we need to create the RequestBuilder object to send the URI
    the method is GET
    this will accept media type is Application JSON
    We have the MockMvcRequestBuilders class
    MvcResult mvcResult = mockMvc.perform(request).andReturn(); -- we can do more with perform() like above

    */


    }
}
