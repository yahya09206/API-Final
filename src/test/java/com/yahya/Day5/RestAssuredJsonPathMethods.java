package com.yahya.Day5;

import com.yahya.utility.SpartanTestBase;
import org.junit.jupiter.api.Test;
import com.yahya.utility.SpartanTestBase;
import com.yahya.utility.SpartanUtil;

import java.util.LinkedHashMap;
import java.util.Map;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;


public class RestAssuredJsonPathMethods extends SpartanTestBase {

    /**
     * There are two ways to get the response and extract the json data
     * path("you jsonpath goes here") return type is T(generic)
     * and decided by your variable data type you store
     *  int myId = response.path("path")
     *
     *  There is a type(class) in RestAssured : JsonPath
     *  that have lots of methods to extract json body from the response
     *  like getInt getString getDouble getObject getList and so on
     *  In order to get JsonPath object out of response
     *  we call a method called jsonPath() from the response
     *  for example :
     *  JsonPath jp = response.jsonPath("your actual path goes here")
     *  jp.getInt() jp.getLong() and so on
     *
     *  The meaning of the word json path when we use it in different places
     *  json path : --> when inside the " " means the actual path to get the value(like xpath)
     *  JsonPath : --> the RestAssured class that has lots of methods
     *  jsonPath() : --> the method of Response objects to obtain JsonPath object out of the response
     *
     */

    // Send Request to GET /spartans/{id}
    // and extract the data id, name and phone
    @Test
    public void testOneSpartan(){

        // get the first id in the system
        int firstId = get("/spartans").path("id[0]");
        System.out.println("firstId = " + firstId);

        Response response = given().log().uri()
                .pathParams("id", firstId)
                .when().get("/spartans/{id}")
                .prettyPeek();
        // save the id from the response
    }
}
