package com.yahya.Day3;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.reset;

public class HR_ORDS_API_Test {

    /**
     * Open a new TestClass called HR_ORDS_API_Test
     * 2. Create @BeforeAll @AfterAll methods for setting up and tearing down
     *    1. baseURI  = http://44.211.192.252:1000
     *    2. basePath = /ords/hr/
     * 3. Create a test called testGetAllJobs
     *    1. Send request to GET /jobs
     *    2. Save the response
     *    3. Check status code is 200
     *    4. Content type is json
     *    5. count value is 19
     *    6. save second job_id into String
     *    7. print 4th mix_salary and
     *    8. save all of the job_title into List<String>
     */

    // Set up and teardown
    @BeforeAll
    public static void setup(){

        RestAssured.baseURI = "http://44.211.192.252:1000";
        RestAssured.basePath = "/ords/hr";
    }

    @AfterAll
    public static void tearDown(){

        // In order to avoid the static value accidentally being carried over to different classes when using different
        // apis, it's better to set the baseURI basePATH back to its original value using reset method
        // RestAssured.rest()
        reset();

    }

    @Test
    public void testGetAllJobs(){

        Response response = get("/jobs");

        response.prettyPrint();
    }


}
