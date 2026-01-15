package com.javacodex.unittesting.business;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.stubbing.OngoingStubbing;

import java.util.ArrayList;
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
    public void returnDifferentValues(){
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
        mock.add("HelloJunit1");
        ArgumentCaptor<String> captor=ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());
        assertEquals( "HelloJunit1",captor.getValue());
    }
    @Test
    public void multipleArgumentCapturing(){
        mock.add("HelloJunit1");
        mock.add("HelloJunit2");
        ArgumentCaptor<String> captor=ArgumentCaptor.forClass(String.class);
        verify(mock,times(2)).add(captor.capture());
        List<String> allValues=captor.getAllValues();
        assertEquals( "HelloJunit1",allValues.get(0));
        assertEquals( "HelloJunit2",allValues.get(1));
    }
    @Test
    public void mocking(){
        ArrayList mockArrayList=mock(ArrayList.class);
        System.out.println(mockArrayList.get(0));
        System.out.println(mockArrayList.size());
        System.out.println(mockArrayList.add(1));
        System.out.println(mockArrayList.add("abc"));
        System.out.println(mockArrayList.size());
        when(mockArrayList.size()).thenReturn(2);
        System.out.println(mockArrayList.size());
        OngoingStubbing<String> stubbing = when(mock.get(0));
        System.out.println(stubbing);
    }
    @Test
    public void spying(){
        ArrayList spyArrayList=spy(ArrayList.class);
        //System.out.println(spyArrayList.get(0));
        /*
        this will throw ArrayIndexBoundException bcoz when we do spy
        the original Arraylist behaviour will retain so when we try to get an
        element but the Arraylist does not have then it will throw ArrayIndexBoundException
         */
        spyArrayList.add("abcd");
        System.out.println(spyArrayList.get(0)); // out- abcd
        System.out.println(spyArrayList.size());
        System.out.println(spyArrayList.add(1));
        System.out.println(spyArrayList.add("abc"));
        System.out.println(spyArrayList.size());
        when(spyArrayList.size()).thenReturn(2);
        System.out.println(spyArrayList.size());

        spyArrayList.add(23);
        System.out.println(spyArrayList.size());
        /*here we have added 3 element normal the size will be 3 but it will return 2 because when we
        when(spyArrayList.size()).thenReturn(2); do this we are tking the control of its behaviour
        so the size will not change even we add new elements.
         */

    }
}
