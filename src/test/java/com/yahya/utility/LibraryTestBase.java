package com.yahya.utility;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.reset;

public class LibraryTestBase {

    @BeforeAll
    public static void setup(){

        // baseURI : https://library2.cydeo.com/login.html
        // basePath : /rest/v1
        RestAssured.baseURI = "https://library2.cydeo.com/";
        RestAssured.basePath = "/rest/v1";
    }

    @AfterAll
    public static void tearDown(){
        reset();
    }
}
