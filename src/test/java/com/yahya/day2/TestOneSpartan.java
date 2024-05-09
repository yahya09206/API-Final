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
        // Easier way to read in JSON format
        response.prettyPrint();

        // Getting header from the response using response.getHeader()
        System.out.println("response.getHeader(\"Content-Type\") = " + response.getHeader("Content-Type"));

        // Another way of getting the header info
        System.out.println("response.header(\"Content-Type\") = " + response.header("Content-Type"));


        // Get the date header
        System.out.println("response.getHeader(\"Date\") = " + response.getHeader("Date"));

        // Get the Keep-Alive header
        System.out.println("response.getHeader(\"Keep-Alive\") = " + response.getHeader("Keep-Alive"));
        // Get the Connection header
        System.out.println("response.getHeader(\"Connection\") = " + response.getHeader("Connection"));
    }

    @Test
    public void testContentTypeHeader(){

        // Sending a get request to this url and saving the response into Response code
        Response response = get("http://44.211.192.252:8000/api/spartans/1");

        // RestAssured special support for common headers like content-type
        System.out.println("response.contentType() = " + response.contentType());
        System.out.println("response.getContentType() = " + response.getContentType());
    }
}
