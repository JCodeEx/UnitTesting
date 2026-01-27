package com.javacodex.unittesting.business;

import com.javacodex.unittesting.data.SomeDataService;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SomeBusinessMockImpl {
    private SomeDataService someDataService;
    /*
     * we need to set the SomeDataService so we use setter method  */

    public void setSomeDataService(SomeDataService someDataService) {

        this.someDataService = someDataService;
    }


    /*public int calculateSum(int [] data){
        int sum=0;
        for (int value:data ) {
            sum +=value;
        }
        return sum;
    }*/
   /* public int calculateSumUsingDataService(){
        int sum = 0;
        int [] data=someDataService.retriveAllData();
        for (int value :data) {
            sum +=value;
        }
        return sum;
    }*/
    public int calculateSumUsingDataService() {
        int[] data = someDataService.retriveAllData();
        return Arrays.stream(data).reduce(0, Integer::sum);
    }
}
