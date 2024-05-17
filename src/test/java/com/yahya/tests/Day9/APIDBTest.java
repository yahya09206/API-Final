package com.yahya.tests.Day9;

import com.yahya.utility.DB_Util;
import com.yahya.utility.HRTestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class APIDBTest extends HRTestBase {

    @Test
    public void testRegion(){


        DB_Util.runQuery("SELECT * FROM REGIONS");
        // find the row count
        System.out.println("DB_Util.getRowCount() = " + DB_Util.getRowCount());
        DB_Util.displayAllData();
    }

    /**
     * Send API request to http://44.211.192.252:1000/ords/hr/regions
     * Get your response
     * Get the expected count from Database
     * Assert the api request response has some count as database row count
     */
    @DisplayName("Test Region Count from API with Database Matches")
    @Tag("db")
    @Test
    public void testRegionsCount(){

        // Prepare expected result here
        DB_Util.runQuery("SELECT * FROM REGIONS");
        int expectedCount = DB_Util.getRowCount();

        given().log().uri()
                .when().get("/regions")
                .then().log().ifValidationFails()
                .statusCode(200)
                .body("count", is(expectedCount))
                .body("items", hasSize(expectedCount));

    }

    /**
     * Send request to GET /regions/{region_id} region_id = 1
     * prepare expected result from the database by running
     * SELECT * FROM REGIONS WHERE REGION_ID = 1
     * Save the result of the query as a map
     * then verify the region_id and region_name match between api and db response
     */
    @Test
    public void testSingleRegion(){

        DB_Util.runQuery("SELECT * FROM REGIONS WHERE REGION_ID = 1");
        Map<String, String> dbResultMap = DB_Util.getRowMap(1);
        System.out.println("dbResultMap = " + dbResultMap);

        int expectedRegionID = Integer.parseInt(dbResultMap.get("REGION_ID"));
        String expectedRegionName = dbResultMap.get("REGION_NAME");

        given().pathParam("region_id", 1)
                .log().uri()
                .when().get("/regions/{region_id}")
                .then().log().all().statusCode(200);
    }
}
