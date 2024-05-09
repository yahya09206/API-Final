package com.yahya.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;

public class TestOneSpartan2 {

    // GET http://44.211.192.252:8000/api/spartans/1

    // We can break down above url into 3 parts and tell RestAssured to append it at the end of our endpoints

    /**
     * BaseURI : http://44.211.192.252:8000
     * BasePath : /api
     * Anything else comes after actual resources
     *
     * For RA the whole URL will be BaseURI + BasePath + what you put in get("here")
     */
    @BeforeAll
    public static void setup(){

        RestAssured.baseURI = "http://44.211.192.252:8000";
        RestAssured.basePath = "/api";
    }

    // Test for checking the GET api/hello Endpoint
    // Verify status code is 200, content type is text/plain, body is hello from Sparta
    @Test
    public void testHelloAgain(){

        Response response = get("/hello");

        Assertions.assertEquals(200, response.statusCode());
        // This did not work because the actual response had extra text at the end
        // Assertions.assertEquals(ContentType.TEXT.toString(), response.contentType());
        // use string instead
        Assertions.assertEquals("text/plain;charset=UTF-8", response.contentType());
        Assertions.assertEquals("Hello from Sparta", response.asString());

    }

    @Test
    public void testOneSpartan(){

        // Sending a get request to this url and saving the response into Response code
        Response response = get("/spartans/1");

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
        // Response response = get("http://44.211.192.252:8000/api/spartans/1");
        Response response = get("/spartans/1");

        // RestAssured special support for common headers like content-type
        System.out.println("response.contentType() = " + response.contentType());
        System.out.println("response.getContentType() = " + response.getContentType());

        // Assertion to verify that the contentType() = application/json
        Assertions.assertEquals("application/json", response.contentType());

        // Import io.restassured.http.ContentType;
        System.out.println("ContentType.JSON = " + ContentType.JSON);
        System.out.println("ContentType.XML = " + ContentType.XML);
        System.out.println("ContentType.TEXT = " + ContentType.TEXT);
        System.out.println("ContentType.URLENC = " + ContentType.URLENC);

        Assertions.assertEquals(ContentType.JSON.toString() , response.contentType());
    }

    /**
     * {
     *     "id": 1,
     *     "name": "Meade",
     *     "gender": "Male",
     *     "phone": 3584128232
     * }
     */
    @Test
    public void testJSONBody(){

        // Sending a get request to this url and saving the response into Response code
        Response response = get("/spartans/1");

        response.prettyPrint();

        // Just like navigating through html using xpath to get to certain elements
        // you can navigate through json to get the value of certain keys using jsonpath
        // the easiest way to get the value is using jsonpath is using path method from response object
        System.out.println("response.path(\"id\") = " + response.path("id"));
        System.out.println("response.path(\"name\") = " + response.path("name"));
        System.out.println("response.path(\"gender\") = " + response.path("gender"));
        System.out.println("response.path(\"phone\") = " + response.path("phone"));

        /**
         * response.path("id") = 1
         * response.path("name") = Meade
         * response.path("gender") = Male
         * response.path("phone") = 3584128232
         */
        // Save the json values you get from the key into variables
        int myId = response.path("id");
        String myName = response.path("name");
        String myGender = response.path("gender");
        long myPhone = response.path("phone");

        System.out.println("myId = " + myId);
        System.out.println("myName = " + myName);
        System.out.println("myGender = " + myGender);
        System.out.println("myPhone = " + myPhone);

        // Assertions to verify the json body
        Assertions.assertEquals(1, myId);
        Assertions.assertEquals("Meade", myName);
        Assertions.assertEquals("Male", myGender);
        Assertions.assertEquals(3584128232L, myPhone);

    }
}
