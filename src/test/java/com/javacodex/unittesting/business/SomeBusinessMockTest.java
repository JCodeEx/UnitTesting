package com.javacodex.unittesting.business;

import com.javacodex.unittesting.data.SomeDataService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/*class SomeDataServiceStub implements SomeDataService{
    @Override
    public int[] retriveAllData() {return new int[]{1,2,3};
    }
}*/
/*
class SomeDataServiceEmptyStub implements SomeDataService{
    @Override
    public int[] retriveAllData() {return new int[]{};
    }
}
class SomeDataServiceOneElementStub implements SomeDataService{
    @Override
    public int[] retriveAllData() {return new int[]{1};
    }
}*/
/*
* in the above we created a stub class for each requirement  it is ok
* but maintaining  these all stub class will be difficult
* and let's say if any new requirements we change in our interface by adding a new method
* then all the implementation will throw compilation error as need to implement the new method
*   */
/* So to handle these above we need Mocking */

@ExtendWith(MockitoExtension.class)
class SomeBusinessMockTest {
    @InjectMocks
    SomeBusinessMockImpl business = new SomeBusinessMockImpl();
   // SomeDataService mockDataService = mock(SomeDataService.class);
   /* @BeforeEach
    public void before(){

        business.setSomeDataService(mockDataService);
    }*/
    @Mock
   SomeDataService mockDataService;
    @Test
public void calculateSumUsingDataService_basic(){
       /* SomeBusinessMockImpl business = new SomeBusinessMockImpl();
        SomeDataService mockDataService = mock(SomeDataService.class);
        //mockDataService retriveAllData() this will return new int[]{1,2,3}
        when(mockDataService.retriveAllData()).thenReturn(new int[]{1,2,3});
        //business.setSomeDataService(new SomeDataServiceStub());
        business.setSomeDataService(mockDataService);*/
        when(mockDataService.retriveAllData()).thenReturn(new int[]{1,2,3});
        int actualResult=business.calculateSumUsingDataService();
         int expectedResult=6;
        assertEquals(expectedResult,actualResult);
}
    @Test
    public void calculateSumUsingDataService_empty(){
       // SomeBusinessMockImpl business = new SomeBusinessMockImpl();
       // SomeDataService mockDataService = mock(SomeDataService.class);
///mockDataService retriveAllData() this will return new int[]{}
        when(mockDataService.retriveAllData()).thenReturn(new int[]{});
       // business.setSomeDataService(mockDataService); -- this is used in @Before but in junit 5 it is @BeforeEach
        int actualResult=business.calculateSumUsingDataService();//new int[]{}
        int expectedResult=0;
        assertEquals(expectedResult,actualResult);
    }
    @Test
    public void calculateSumUsingDataService_OneValue(){
       /* SomeBusinessMockImpl business = new SomeBusinessMockImpl();
        SomeDataService mockDataService = mock(SomeDataService.class);*/
        when(mockDataService.retriveAllData()).thenReturn(new int[]{5});
        //business.setSomeDataService(mockDataService);//used in @Before when Junit 5 we used
        int actualResult=business.calculateSumUsingDataService();//new int []{5}
        int expectedResult=5;
        assertEquals(expectedResult,actualResult);
    }

}