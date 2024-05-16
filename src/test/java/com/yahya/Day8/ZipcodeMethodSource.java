package com.yahya.Day8;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ZipcodeMethodSource {

    /**
     * Write a method that returns all zipcodes for Fairfax VA
     * using https://api.zippopotam.us/us/va/fairfax
     * and return List<String>
     *
     *     Write a parameterized test to test each and every zipcode in Fairfax VA
     *     using GET https://api.zippopotam.us/us/{zip}
     */

    @BeforeAll
    public static void setup(){

        baseURI = "http://api.zippopotam.us";
        basePath = "/us";

    }

    @AfterAll
    public static void tearDown(){
        reset();
    }

    @ParameterizedTest
    @MethodSource("getAllZipcodes")
    public void testAllZipcodes(String zipCodeParam){
        System.out.println("zipCodeParam = " + zipCodeParam);
    }

    public static List<String> getAllZipcodes(){

        // Send GET to https://api.zippopotam.us/us/va/fairfax and store all the zipcodes
        // since this is not a @Test method, @BeforeAll will not affect this
        // one way to do this is to provide full url directly
        // or we have to use .baseURI and .basePath in the given section for one time use
        List<String> allZips = get("https://api.zippopotam.us/us/va/fairfax").path("places.'post code'");
        return allZips;
    }
}
