package com.yahya.Day3;

import com.yahya.utility.SpartanTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class SpartanMethodChainTest extends SpartanTestBase {

    @Test
    public void getOneSpartanTest(){

        // in one shot send GET request /spartans/{id} with id of 1
        // log everything and verify response code is 200 content type is JSON, json body :id is 1, OliverTheKing,
        given().log().all().pathParams("id", 1).accept(ContentType.JSON)
                .when().get("/spartans/{id}")
                .then().statusCode(is(200))
                .header("Content-Type", ContentType.JSON.toString())
                .body("id", is(1))
                .body("name", is("Meade")); // asserting status is 200 and header is application/json


    }

    @Test
    public void testSearch(){
        /**
         * http://44.211.192.252:8000/api/spartans/search?nameContains=Ea
         * verify status code is 200
         * totalElements : 3
         * jsonArray has size of 3
         * all names have item Sean
         * every gender is male
         * every name should contain ignoring case "ea"
         */
        given().log().all()
                .queryParam("nameContains", "Ea")
                .queryParam("gender", "Male")
                .when().get("/spartans/search").then().log().all()
                .statusCode(is(200))
                .contentType(ContentType.JSON)
                .body("totalElement", is(3))
                .body("content", hasSize(3))
                .body("content.name", hasItem("Sean"))
                .body("content.gender", everyItem(is("Male")))
                .body("content.name", everyItem(containsStringIgnoringCase("ea")));
    }
}
