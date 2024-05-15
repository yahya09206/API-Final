package com.yahya.Day7;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class JunitFiveDataDrivenTest {

    // Given this data of Strings
    // "Furkan", "Abbos", "Yevheniia", "Shazia", "Tugba", "Mohamed", "Kimberley"
    // Test to check the length of all the names longer than 5 characters

    @ParameterizedTest
    @ValueSource(strings = {"Abboss", "Yevheniia", "Shazia", "Tugbas", "Mohamed", "Kimberley"})
    public void testNameLength(String eachName){
        System.out.println("eachName = " + eachName);
        assertTrue(eachName.length() > 5);
    }

}