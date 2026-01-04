package com.javacodex.unittesting.business;

import com.javacodex.unittesting.data.SomeDataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
class SomeDataServiceStub implements SomeDataService{
    @Override
    public int[] retriveAllData() {

        return new int[]{1,2,3};
    }
}

class SomeDataServiceEmptyStub implements SomeDataService{
    @Override
    public int[] retriveAllData() {

        return new int[]{};
    }
}

/*
* in the above we created a stub class for each requirement  it is ok
* but maintaining  these all stub class will be difficult
* and let's say if any new requirements we change in our interface by adding a new method
* then all the implementation will throw compilation error as need to implement the new method
*   */

/* So to handle these above we need Mocking */

class SomeDataServiceOneElementStub implements SomeDataService{
    @Override
    public int[] retriveAllData() {

        return new int[]{1};
    }
}

class SomeBusinessStubTest {
    @Test
public void calculateSumUsingDataService_basic(){
        SomeBusinessMockImpl business = new SomeBusinessMockImpl();
        business.setSomeDataService(new SomeDataServiceStub());
    int actualResult=business.calculateSumUsingDataService();
    int expectedResult=6;
    assertEquals(expectedResult,actualResult);
}
    @Test
    public void calculateSumUsingDataService_empty(){
        SomeBusinessMockImpl business = new SomeBusinessMockImpl();
        business.setSomeDataService(new SomeDataServiceEmptyStub());
        int actualResult=business.calculateSumUsingDataService();//new int[]{}
        int expectedResult=0;
        assertEquals(expectedResult,actualResult);
    }
    @Test
    public void calculateSumUsingDataService_OneValue(){
        SomeBusinessMockImpl business = new SomeBusinessMockImpl();
        business.setSomeDataService(new SomeDataServiceOneElementStub() );
        int actualResult=business.calculateSumUsingDataService();//new int []{5}
        int expectedResult=5;
        assertEquals(expectedResult,actualResult);
    }

}