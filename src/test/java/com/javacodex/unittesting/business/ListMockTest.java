package com.javacodex.unittesting.business;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {
    @Mock
    List<String> mock=mock(List.class);
    @Test
    public void size_basic(){
       // List mock=mock(List.class);
        when(mock.size()).thenReturn(5);
        assertEquals(5,mock.size());
    }
    @Test
    public void returnDiffrentValues(){
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5,mock.size());
        assertEquals(10,mock.size());
    }
    @Test
    public void returnWithParameter(){
        when(mock.get(0)).thenReturn("HelloJunit");
        assertEquals("HelloJunit",mock.get(0));
        assertEquals(null,mock.get(1));
    }
    @Test
    public void returnWithGenericParameter(){
        when(mock.get(anyInt())).thenReturn("HelloJunit");
        assertEquals("HelloJunit",mock.get(0));
        assertEquals("HelloJunit",mock.get(1));
    }
    @Test
    public void verificationBasics(){
        String value=mock.get(0);
        String value2=mock.get(1);

        verify(mock).get(0);
      //  verify(mock).get(anyInt());
        verify(mock,times(2)).get(anyInt());
        verify(mock,atLeastOnce()).get(anyInt());
        verify(mock,atMost(2)).get(anyInt());
        verify(mock,never()).get(2);

    }
    @Test
    public void argumentCapturing(){
        mock.add("HelloJunit");
        ArgumentCaptor<String> captor=ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());
        assertEquals("HelloJunit",captor.getValue());
    }
}
