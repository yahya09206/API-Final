package com.yahya.Day5;

import com.yahya.utility.SpartanTestBase;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class PostRequestWithObject extends SpartanTestBase {

    /**
     * Serialization : Process of converting Java Object to JSON(or any other text)
     * De-Serialization : Process of Converting from JSON(any text) to Java Object
     *
     * Post /spartans
     * content type is JSON
     * body is
     * {
     *     "name": "API POST",
     *     "gender": "Male",
     *     "phone": 1231231234
     * }
     * Instead of providing above body in a String
     * We want to be able to provide the body as a java object(like a map)
     * and let any kind of Serialization library convert that into a string for us while sending the request
     */
    @Test
    public void testPostRequestWithAMap(){

        Map<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("name", "API-2 Post");
        bodyMap.put("gender", "Male");
        bodyMap.put("phone", "5554447777");
        System.out.println("bodyMap = " + bodyMap);

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(bodyMap)
                .when()
                .post("/spartans")
                .then().log().all()
                .statusCode(201);
    }

}
