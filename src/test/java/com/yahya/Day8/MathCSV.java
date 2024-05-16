package com.yahya.Day8;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class MathCSV {

    @ParameterizedTest
    @CsvFileSource(resources = "/math.csv", numLinesToSkip = 1)
    public void testMath(int num1, int num2, int expectedResult){

        System.out.println(num1 + " " + num2 + " should be " + expectedResult);
    }
}
