package com.yahya.tests.Day9;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("smokeAll")
public class TaggingInJunit5Tests {

    @Tag("smoke1")
    @Test
    public void testOne(){
        System.out.println("Test 1 is running");
    }

    @Tag("smoke2")
    @Test
    public void testTwo(){
        System.out.println("Test 2 is running");
    }
    @Test
    public void testThree(){
        System.out.println("Test 3 is running");
    }
}
