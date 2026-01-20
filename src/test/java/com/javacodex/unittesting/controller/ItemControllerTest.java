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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static java.lang.Boolean.TRUE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


//@WebMvcTest(ItemController.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ItemBusinessService businessService;

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

    @Test
    public void retrieveAllItems_basic() throws Exception {
        when(businessService.retrieveAllItems())
                .thenReturn(Arrays.asList(new Item(1,"Ball",10,100),
                        new Item(2,"Toy",15,10)));
        RequestBuilder request = MockMvcRequestBuilders
                .get("/all-items-from-database")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content()
                        .json("[{id:1,name:Ball,price:10,quantity:100},{id:2,name:Toy,price:15,quantity:10}]"))
                .andReturn();

        String expected = "[{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100},{\"id\":2,\"name\":\"Toy\",\"price\":15,\"quantity\":10}]";

        JSONAssert.assertEquals(expected, mvcResult.getResponse().getContentAsString(), false);

    }


    @Test
    public void retrieveAllItems_basic2() throws Exception {
       /* when(businessService.retrieveAllItems())
                .thenReturn(Arrays.asList(new Item(1,"Ball",10,100)));*/
        RequestBuilder request = MockMvcRequestBuilders
                .get("/all-items-from-database")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(4))
                .andExpect(jsonPath("$[0].name").value("Item1"))
                .andExpect(jsonPath("$[1].name").value("Item2"))
                .andExpect(jsonPath("$[2].name").value("Item3"))
                .andExpect(jsonPath("$[3].name").value("Item4"))
                .andReturn();
        // .andExpect(content().json("[{id:1,name:Ball,price:10,quantity:100}]"))
        // .andReturn();

        //String expected = "[{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}]";

        // below tax format from java 15
        String expected =
                """
                        [
                         {"name":"Item1"},
                         {"name":"Item2"},
                         {"name":"Item3"},
                         {"name":"Item4"}
                        ]
                        """;

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

Java 8/11
String expected =
        "[\n" +
        "  { \"name\": \"Item1\" },\n" +
        "  { \"name\": \"Item2\" },\n" +
        "  { \"name\": \"Item3\" },\n" +
        "  { \"name\": \"Item4\" }\n" +
        "]";
        Java 15 :
        String expected =
                """
                        [
                         {"name":"Item1"},
                         {"name":"Item2"},
                         {"name":"Item3"},
                         {"name":"Item4"}
                        ]
                        """;

    */


}

