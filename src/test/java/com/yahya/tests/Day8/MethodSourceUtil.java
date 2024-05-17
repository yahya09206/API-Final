package com.yahya.tests.Day8;

import java.util.Arrays;
import java.util.List;

/**
 * The only purpose of this class is to demonstrate the @MethodSource
 * for a parameterized test and the method exists outside of the test class
 */
public class MethodSourceUtil {

    // Create a static method that returns a list of names
    // So we can use the return value as a data source for our parameterized test
    public static List<String> getSomeNames(){

        return Arrays.asList("Furkan", "Abbos", "Yevhniia", "Shazia", "Tugba");
    }
}
