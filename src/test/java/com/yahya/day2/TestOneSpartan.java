package com.yahya.day2;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class TestOneSpartan {

    // GET http://44.211.192.252:8000/api/spartans/1
    @Test
    public void testOneSpartan(){

        // Sending a get request to this url and saving the response into Response code
        Response response = get("http://44.211.192.252:8000/api/spartans/1");

        System.out.println("response.getStatusCode() = " + response.getStatusCode());
        response.prettyPrint();
    }

}
