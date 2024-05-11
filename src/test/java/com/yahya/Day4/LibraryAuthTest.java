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
                .contentType(ContentType.URLENC)
                .formParam("email", "librarian1@library")
                .formParam("password", "libraryUser")
                .when().post("/login")
                .then().log().all().statusCode(200);
    }

    @Test
    public void testDashboardStats(){

        Response response = given().log().all()
                //.header("Content-Type", "application/x-www-form-urlencoded")
                .contentType(ContentType.URLENC)
                .formParam("email", "librarian1@library")
                .formParam("password", "libraryUser")
                .when().post("/login");

        String tokenFromResp = response.path("token");
        System.out.println("tokenFromResp = " + tokenFromResp);

        given()
                .log().all()
                .header("x-library-token", tokenFromResp)
                .when().get("/dashboard_stats")
                .then().log().all().statusCode(200);
    }
}
