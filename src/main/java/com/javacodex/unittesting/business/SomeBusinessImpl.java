package com.javacodex.unittesting.business;

import java.util.Arrays;
import java.util.OptionalInt;

public class SomeBusinessImpl {
    public int calculateSum(int [] data){
        //reduce to one value: 1,2,3,4 => 1+2+3+4....
       /* OptionalInt result = Arrays.stream(data).reduce(Integer::sum);
        return result.orElse(0);*/
        return Arrays.stream(data).reduce(Integer::sum).orElse(0);
    }
}
