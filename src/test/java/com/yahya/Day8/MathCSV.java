package com.yahya.Day8;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

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
     * It allows you to provide the returned value from the static method with no param
     * as the source for your parameterized test
     */
    @ParameterizedTest
    @MethodSource("getTenNumbers")
    public void testWithMethodSourceDDT(int num){
        System.out.println("num = " + num);
    }
    public static List<Integer> getTenNumbers(){

        // This list could have been the result of some very long code
        List<Integer> myList = Arrays.asList(1,2,3,4,5,6,7,8,9);
        return myList;
    }

    @ParameterizedTest
    @MethodSource("com.yahya.Day8.MethodSourceUtil#getSomeNames")
    public void testNamesWithMethodSourceDDT(String name){
        System.out.println("name = " + name);
    }
}
