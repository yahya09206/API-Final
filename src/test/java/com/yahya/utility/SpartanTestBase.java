package com.yahya.utility;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.reset;

/**
 * This class will serve as Base Class to set up BaseURI and BasePATH
 * and clean up after all the tests for any Spartan related test classes
 */

public class SpartanTestBase {

    @BeforeAll
    public static void setup(){

        RestAssured.baseURI = "http://44.211.192.252:1000";
        RestAssured.basePath = "/ords/hr";
    }

    @AfterAll
    public static void tearDown(){

        // In order to avoid the static value accidentally being carried over to different classes when using different
        // apis, it's better to set the baseURI basePATH back to its original value using reset method
        // RestAssured.rest()
        reset();

    }
}
