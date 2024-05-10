package com.yahya.Day3;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

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

        // Get response from Response object and log everything about the request
        Response response = given().log().all().when().get("/jobs");

        response.prettyPrint();

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals(ContentType.JSON.toString(), response.contentType());
        // to get something from the body, you simply use the path to the response
        int countValue = response.path("count");
        Assertions.assertEquals(19, countValue);

        String jobID = response.path("items[1].job_id");
        System.out.println("jobID = " + jobID);

        int fourthMinSalary = response.path("items[3].min_salary");
        System.out.println("fourthMinSalary = " + fourthMinSalary);

        List<String> jobs = response.path("items.job_title");
        System.out.println("jobs = " + jobs);
    }

    /**
     * 4. Create a test called testJobsWithQueryParam
     *    1. Send request to `GET /jobs?limit=5`
     *    2. log everything about the request
     *    3. verify `count` value is `5`
     *    4. verify the value of last `job_title` is `AD_VP`
     */

    @Test
    public void testJobsWithQueryParam(){

        Response response = given().log().all().queryParam("limit", 5).when().get("/jobs");

        int countValue = response.path("count");
        Assertions.assertEquals(5, countValue);

        String lastJob = response.path("items[-1].job_id");
        System.out.println("lastJob = " + lastJob);
        Assertions.assertEquals("AD_VP", lastJob);

    }

    /**
     * create a test called testSingleJobWithPathParam
     *      *    1. Send request to `GET /jobs/AD_VP`
     *      *    2. log everything about the request
     *      *    3. verify response is json and `job_title` is `Administration Vice President`
     */
    @Test
    public void testSingleJobWithPathParam(){

        Response response = given().log().all().pathParam("job_id", "AD_VP").when().get("/jobs/{job_id}").prettyPeek();
        // response.prettyPrint();
        // response.prettyPeek();

        Assertions.assertEquals(ContentType.JSON.toString(), response.contentType());
        String jobTitle = response.path("job_title");
        System.out.println(jobTitle);
        Assertions.assertEquals("Administration Vice President", jobTitle);


    }
}
