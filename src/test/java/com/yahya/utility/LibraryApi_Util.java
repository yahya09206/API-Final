package com.yahya.utility;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class LibraryApi_Util {

    public static String getToke(){

        return given().log().all()
                .contentType(ContentType.URLENC)
                .formParam("email", "librarian3@library")
                .formParam("password", "libraryUser")
                .when().post("/login").path("token");
    }
}
