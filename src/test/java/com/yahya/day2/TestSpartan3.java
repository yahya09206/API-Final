package com.yahya.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        Assertions.assertEquals(ContentType.JSON.toString(), response.contentType());

        // Get gender of first item in the array
        System.out.println("response.path(\"[0].gender\") = " + response.path("[0].gender"));

        System.out.println("response.path(\"gender[0]\") = " + response.path("gender[0]"));

        // Get all the ids and store them into List<Integer>
        List<Integer> idList = response.path("id");
        System.out.println("idList = " + idList);
    }

    @Test
    public void testGetXMLResponse(){

        // RestAssured use method chaining extensively to combine all parts of the request
        // and very the response in one shot
        // need to provide extra header information to get xml response
        // will start using some method chaining to see how I can get additional information to the request
        Response response = given()
                .header("Accept", "application/xml")
                .when()
                .get("/spartan");
    }
}
