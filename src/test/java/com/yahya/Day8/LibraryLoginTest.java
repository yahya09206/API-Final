package com.yahya.Day8;

import com.yahya.utility.LibraryTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static io.restassured.RestAssured.*;

public class LibraryLoginTest extends LibraryTestBase {


    @ParameterizedTest
    @CsvFileSource(resources = "/librarycredentials.csv", numLinesToSkip = 1)
    public void testLogin(String username, String password){

        System.out.println("username = " + username);
        System.out.println("password = " + password);

        given().log().all()
                .contentType(ContentType.URLENC)
                .formParam("email", username)
                .formParam("password", password)
                .when().get("/login")
                .then().log().ifValidationFails().statusCode(200);
    }
}
