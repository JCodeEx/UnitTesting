package com.javacodex.unittesting.controller;


import com.javacodex.unittesting.business.ItemBusinessService;
import com.javacodex.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static java.lang.Boolean.TRUE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//@WebMvcTest(ItemController.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;
    //@MockBean
    //private ItemBusinessService businessService;

    @Test
    public void dummyItem_basic() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\": 1 ,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
                .andReturn();
        String expected = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
        JSONAssert.assertEquals(expected, mvcResult.getResponse().getContentAsString(), false);
        //assertEquals("Hello World", mvcResult.getResponse().getContentAsString());

    }
    @Test
    public void itemFromBusinessService_basic() throws Exception {
        // Before Junit5  we need below code
        /*when(businessService.retriveHardCodeItem())
                .thenReturn(new Item(2,"Toy",101,10));*/
        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\": 1 ,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
                .andReturn();
        String expected = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
        JSONAssert.assertEquals(expected, mvcResult.getResponse().getContentAsString(), false);

    }

    @Test
    public void itemFromBusinessService_basic2() throws Exception {
        // Before Junit5  we need below code
        /*when(businessService.retriveHardCodeItem())
                .thenReturn(new Item(2,"Toy",101,10));*/
        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{id:1,name:Ball,price:10}"))
                .andReturn();
        String expected = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
        JSONAssert.assertEquals(expected, mvcResult.getResponse().getContentAsString(), false);

    }

    /* call to url -- /hello-world via GET method and response will be like
    Application/json .
    // need verify the return is HelloWorld
    To call the url we have mockMvc.perform() method.
    we need to create the RequestBuilder object to send the URI
    the method is GET
    this will accept media type is Application JSON
    We have the MockMvcRequestBuilders class
    MvcResult mvcResult = mockMvc.perform(request).andReturn();
    -- we can do more with perform() like above

    if we are using like -- @WebMvcTest(HelloWorldController.class) on top of our class to
    mock the service , then we have to use the below code to get the mock object
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ItemBusinessService businessService;
    in teh method of public void itemFromBusinessService_basic() use
  when(businessService.retriveHardCodeItem())
                .thenReturn(new Item(2,"Toy",10,25));

if we use ://@SpringBootTest
//@AutoConfigureMockMvc
then we dont need them as well
 @MockBean private ItemBusinessService businessService;
when(businessService.retriveHardCodeItem()).thenReturn(new Item(2,"Toy",10,25));


    */


    }

