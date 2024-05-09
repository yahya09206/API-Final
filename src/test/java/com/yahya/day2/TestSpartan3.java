package com.yahya.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class TestSpartan3 {

    // Set up and teardown
    @BeforeAll
    public static void setup(){

        RestAssured.baseURI = "http://44.211.192.252:8000";
        RestAssured.basePath = "/api";
    }

    @AfterAll
    public static void tearDown(){

        // In order to avoid the static value accidentally being carried over to different classes when using different
        // apis, it's better to set the baseURI basePATH back to its original value using reset method
        // RestAssured.rest()
        reset();

    }

    // Test for getting all spartans
    @Test
    public void testGettingAllSpartans(){

        Response response = get("/spartans");
        response.prettyPrint();
        Assertions.assertEquals(200, response.statusCode());
    }
}
