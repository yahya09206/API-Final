package com.yahya;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class TestSpartanApi {

    @Test
    public void testHello(){
        // RestAssured.get("http://44.211.192.252:8000/api/hello");
        // the result of sending request can be stored in Response object coming from RestAssured
        Response response = get("http://44.211.192.252:8000/api/hello");

        System.out.println("response.statusCode() = " + response.statusCode());

        // there are many ways to print the response, use prettyPrint
        response.prettyPrint();

        // Verify that status code is 200
        Assertions.assertEquals(200, response.statusCode());
    }

}
