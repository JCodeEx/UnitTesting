package com.javacodex.unittesting.business;

import com.javacodex.unittesting.data.ItemRepository;
import com.javacodex.unittesting.data.SomeDataService;
import com.javacodex.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
class ItemBusinessServiceTest {
    @InjectMocks
    private ItemBusinessService business ;
    @Mock
   private ItemRepository repository;
    @Test
public void businessLayerRetrieveAll_test(){

        when(repository.findAll()).thenReturn(
                Arrays.asList(new Item(1,"Ball",10,10),
                new Item(2,"Toy",15,10)));
        List<Item> items = business.retrieveAllItems();
        assertEquals(100,items.get(0).getValue());
        assertEquals(150,items.get(1).getValue());
    }
    /*@Test
    public void calculateSumUsingDataService_empty(){
     ///mockDataService retriveAllData() this will return new int[]{}
        when(mockDataService.retriveAllData()).thenReturn(new int[]{});
       // business.setSomeDataService(mockDataService); -- this is used in @Before but in junit 5 it is @BeforeEach
        int actualResult=business.calculateSumUsingDataService();//new int[]{}
        int expectedResult=0;
        assertEquals(expectedResult,actualResult);
    }
    @Test
    public void calculateSumUsingDataService_OneValue(){
        when(mockDataService.retriveAllData()).thenReturn(new int[]{5});        int actualResult=business.calculateSumUsingDataService();//new int []{5}
        int expectedResult=5;
        assertEquals(expectedResult,actualResult);
    }*/

}