package com.yahya.Day5;

import com.github.javafaker.Faker;
import com.yahya.utility.SpartanTestBase;
import com.yahya.utility.SpartanUtil;
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
        bodyMap.put("phone", 5554447777L);
        System.out.println("bodyMap = " + bodyMap);

        /**
         * Jackson-databind is the library for serialization and de-serialization
         * rest assured needs it in the dependency, so it can automatically convert the java object
         * to json with additional code
         */

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(bodyMap)
                .when()
                .post("/spartans")
                .then().log().all()
                .statusCode(201);
    }

    @Test
    public void testPostRequestWithAMapAndRandomData(){

//        Faker faker = new Faker();
//
//        Map<String, Object> bodyMap = new LinkedHashMap<>();
//        bodyMap.put("name", faker.name().firstName());
//        bodyMap.put("gender", faker.demographic().sex());
//        // get a number between 500,000,0000 - 999,999,9999
//        bodyMap.put("phone", faker.number().numberBetween(5000000000L, 9999999999L));
//        System.out.println("bodyMap = " + bodyMap);

        // Call method as below once utility is set up
        Map<String, Object> bodyMap = SpartanUtil.getRandomSpartanMapBody();

        /**
         * Jackson-databind is the library for serialization and de-serialization
         * rest assured needs it in the dependency, so it can automatically convert the java object
         * to json with additional code
         */

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(bodyMap)
                .when()
                .post("/spartans")
                .then().log().all()
                .statusCode(201);
    }

    @Test
    public void testUpdateDataWithRandomBody(){

        // Instead of guessing what id exists in the server
        // I can send a request to get all spartans and get last json object id
        int lastId = get("/spartans").path("id[-1]");
        System.out.println("lastId = " + lastId);

        // Prepare updated body
        Map<String, Object> updatedBodyMap = SpartanUtil.getRandomSpartanMapBody();

        given().log().all()
                .pathParam("id", lastId)
                .contentType(ContentType.JSON)
                .body(updatedBodyMap)
                .when().put("/spartans/{id}")
                .then().log().all()
                .statusCode(204);
    }



}
