package com.javacodex.unittesting.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JasonAssertTest {
    String actualResponse="{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
    @Test
    public void jsonAssert_StrictTrue_ExactMatchExceptSpace() throws JSONException {
        String expectedResponse="{\"id\": 1,\"name\": \"Ball\",\"price\": 10,\"quantity\": 100}";
        JSONAssert.assertEquals(expectedResponse,actualResponse,true);
    }

    @Test
    public void jsonAssert_StrictFalse_ExactMatchExceptSpace() throws JSONException {
        String expectedResponse="{\"id\": 1,\"name\": \"Ball\",\"price\": 10}";
        JSONAssert.assertEquals(expectedResponse,actualResponse,false);
    }
    @Test
    public void jsonAssert_WithoutEscape_Character() throws JSONException {
        String expectedResponse= "{id: 1, name:\"Ball\", price: 10}";
        JSONAssert.assertEquals(expectedResponse,actualResponse,false);
    }
}
