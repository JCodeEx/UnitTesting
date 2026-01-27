package com.javacodex.unittesting.spike;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.*;

public class AssertJTest {
    List<Integer> numbers = Arrays.asList(12, 23, 45, 50);

    @Test
    public void learnAssertJ() {
//        assertThat(numbers,hasSize(4));
        assertThat(numbers).hasSize(4)
                .contains(12, 45);
//        assertThat(numbers, hasItem(23));

//        assertThat("",isEmptyString());
    }

    @Test
    public void learnAssertJ_allMatch() {
        //        assertThat(numbers,hasSize(4));
        //        assertThat(numbers, contains(12, 23, 45, 50));
        //        assertThat(numbers, everyItem(greaterThan(10)));
        assertThat(numbers).hasSize(4)
                .contains(12, 23, 45, 50)
                .allMatch(x -> x > 10);
        assertThat(numbers).hasSize(4)
                .contains(12, 23, 45, 50)
                .allMatch(x -> x > 10);
    }

    @Test
    public void learnAssertJ_nonMatch() {
        assertThat(numbers).hasSize(4)
                .noneMatch(x -> x < 0);
    }
    @Test
    public void learnAssertJ_string() {
        assertThat("").isEmpty();
        assertThat("ABCD").isNotEmpty();
        assertThat("ABCD").contains("ABC");
        assertThat("ABCD").contains("ABC").startsWith("A");
        assertThat("ABCD").contains("ABC").startsWith("AB").endsWith("CD");
    }


}
