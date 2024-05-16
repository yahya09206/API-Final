package com.yahya.Day8;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.equalTo;

public class MathCSV {

    @ParameterizedTest
    @CsvFileSource(resources = "/math.csv", numLinesToSkip = 1)
    public void testMath(int num1, int num2, int expectedResult){

        System.out.println(num1 + " " + num2 + " should be " + expectedResult);
        assertThat(num1 + num2, equalTo(expectedResult));
    }

    /**
     * Another way of providing a source for a @ParameterizedTest is @MethodSource
     */
}
