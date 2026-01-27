package com.javacodex.unittesting.business;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
public class HamcrestMatchersTest {
    @Test
public void learnHamcrest(){

        List<Integer> numbers= Arrays.asList(12,23,45,50);

        assertThat(numbers,hasSize(4));
        assertThat(numbers, hasItem(23));
        assertThat(numbers, everyItem(greaterThan(10)));
        assertThat(numbers, contains(12, 23, 45, 50));

        assertThat("",isEmptyString());
}

}
