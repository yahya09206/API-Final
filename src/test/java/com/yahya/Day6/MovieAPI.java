package com.yahya.Day6;

import com.yahya.POJO.Movie;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.*;

public class MovieAPI {

    @BeforeAll
    public static void setup(){

        baseURI = "http://www.omdbapi.com/?s=The%20Mandalorian&apikey=";

    }

    @AfterAll
    public static void tearDown(){

        reset();
    }

    @Test
    public void testMovies(){

        JsonPath jsonPath = given().log().uri()
                .queryParam("apikey", "f90e5bb4")
                .queryParam("s", "The Mandalorian")
                .when().get("")
                .prettyPeek()
                .jsonPath();

        // get the data from the first object using the jsonpath
        Movie m1 = jsonPath.getObject("Search[0]", Movie.class);
        System.out.println("m1 = " + m1);


    }
}
