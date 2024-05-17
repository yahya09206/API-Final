package com.yahya.tests.Day3;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;


public class HamcrestTest {

    @Test
    public void testNumbers(){

        // in junit5 assertions 3 + 6 = 9
        assertEquals(9, 3 + 6);

        // Hamcrest is more readable
        assertThat(3 + 6, equalTo(9));

    }
}
