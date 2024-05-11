package com.yahya.Day3;

import com.yahya.utility.SpartanTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class SpartanPostPutPatchRequestTest extends SpartanTestBase{

    @Test
    public void testAddingOneNewSpartanStringBody(){

        // Post /spartans
        /**
         * PUT /spartans/{id}
         * content type is JSON
         * body is
         * {
         *     "name": "API POST",
         *     "gender": "Male",
         *     "phone": 1231231234
         * }
         */
        String strBody = "{\n" +
                "        \"name\": \"B23 ADD DATA-4\",\n" +
                "        \"gender\": \"Female\",\n" +
                "        \"phone\": 1231234123\n" +
                "}";
        given().log().all().contentType(ContentType.JSON)// selecting content-type set to json --> type of data we are sending
                .body(strBody)// this is how we provide the body
                .post("/spartans")
                .then().log().all().statusCode(201)
                .contentType(ContentType.JSON)
                .body("success", is("A Spartan is Born!"))
                .body("data.name", is("B23 ADD DATA-4"))
                .body("data.phone", is(1231234123));
    }
}
