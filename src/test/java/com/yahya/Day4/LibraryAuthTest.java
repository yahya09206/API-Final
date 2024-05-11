package com.yahya.Day4;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class LibraryAuthTest {


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

    @Test
    public void testLogin(){

        /**
         *
         * POST https://library2.cydeo.com/login.html
         * content type: application/x-www-form-urlencoded
         * body:
         * email:   librarian1@library
         * password: libraryUser
         *
         * According to the doc we are expecting a 200 status code
         * json body with 2 keys: token, redirect_url
         * content-type json
         */

        given().log().all()
                //.header("Content-Type", "application/x-www-form-urlencoded")
                .contentType(ContentType.JSON)
                .formParam("email", "librarian1@library")
                .formParam("password", "libraryUser")
                .when().get("/login")
                .then().log().all().statusCode(200);
    }
}
