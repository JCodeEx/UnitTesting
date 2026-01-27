package com.javacodex.unittesting.spike;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonPathTest {
    @Test
    public  void learningJsonPath(){
        String responseFromService = "[\n" +
                "  {\"id\":\"100\",\"name\":\"pen\",\"quantity\":\"10\"},\n" +
                "  {\"id\":\"101\",\"name\":\"pencil\",\"quantity\":\"15\"},\n" +
                "  {\"id\":\"102\",\"name\":\"eraser\",\"quantity\":\"20\"}\n" +
                "]";
        DocumentContext context = JsonPath.parse(responseFromService);

        Integer length = context.read("$.length()");
        assertThat(length).isEqualTo(3);

        List<Integer> ids=context.read("$..id");
        System.out.println("Ides are"+ids);
        System.out.println(context.read("$..id").toString());

        System.out.println(context.read("$.[1]").toString());
        System.out.println(context.read("$.[0:1]").toString());
        System.out.println(context.read("$.[?(@.name=='eraser')]").toString());
        System.out.println(context.read("$..name").toString());
        System.out.println(context.read("$..quantity").toString());

    }
}
