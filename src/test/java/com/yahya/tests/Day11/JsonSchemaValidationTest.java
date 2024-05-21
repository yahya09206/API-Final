package com.yahya.tests.Day11;

import com.yahya.utility.SpartanTestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class JsonSchemaValidationTest extends SpartanTestBase {

    @DisplayName("Test GET /spartans/search schema")
    @Test
    public void testSearchSpartan(){

        // When there are more than a couple of key value pairs like headers, or query params, form params
        // RestAssured provides methods to let you pass it as a map in one shot
        Map<String, Object> queryMap = new LinkedHashMap<>();
        queryMap.put("nameContains", "Ea");
        queryMap.put("gender", "Male");

        given().log().uri()
                .queryParams(queryMap)
                .when().get("/spartans/search")
                .then().statusCode(200)
                .body(matchesJsonSchema("SearchSpartanSchema.json"));
    }
}
