package com.yahya.Day6;

import com.yahya.utility.HRTestBase;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;

public class HRORDSTest extends HRTestBase {

    @Test
    public void testJobs(){

        JsonPath jsonPath = given().log().uri()
                .when().get("/jobs")
                .prettyPeek().jsonPath();

        // de-serialize first json object from json array
        // follow java naming convention for the pojo fields
        // ignore the json fields we don't want : link field
    }
}
