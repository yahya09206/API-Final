package com.yahya.tests.Day5;

import com.yahya.POJO.SpartanWithID;
import com.yahya.utility.SpartanTestBase;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;
import com.yahya.utility.SpartanTestBase;
import com.yahya.utility.SpartanUtil;

import java.util.LinkedHashMap;
import java.util.List;
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
        int myId = response.path("id");

        // Get the jsonPath object from response
        JsonPath jsonPath = response.jsonPath();
        int myId2 = jsonPath.getInt("id");
        System.out.println("myId2 = " + myId2);
        String myName = jsonPath.getString("name");
        System.out.println("myName = " + myName);
        long phoneNumber = jsonPath.getLong("phone");
        System.out.println("phoneNumber = " + phoneNumber);

        // store this json result into a Map object
        // the path to get entire body would be an empty string because
        // the entire response is json object already!
        // no need for a path to navigate to this json
        // this will create a map object
        // and all the key and value pairs of json as a value
        Map<String, Object> responseBodyAsMap = jsonPath.getMap("");
        System.out.println("responseBodyAsMap = " + responseBodyAsMap);
        // access phone number field out of this map

    }

    // Send Request GET /spartans/search?nameContains=Ea&gender=Male
    // get JsonPath object out of response so I can use specialized methods
    // get totalElement field value using getX method
    // get 3rd element phone using getX method
    // get last element name using getX method
    // save first json in json array into Map using getX method
    @Test
    public void testExtractingDataFromSearch(){

        Response response = given()
                .log().all()
                .queryParam("nameContains", "Ea")
                .queryParam("gender", "Male")
                .when()
                .get("/spartans/search")
                .prettyPeek();

        JsonPath jsonPath = response.jsonPath();
        System.out.println("jsonPath.getInt(\"totalElement\") = " + jsonPath.getInt("totalElement"));
        System.out.println("jsonPath.getLong(\"phone\") = " + jsonPath.getLong("content[2].phone"));
        System.out.println("jsonPath.getInt(\"id[-1]\") = " + jsonPath.getString("content[-1].name"));

        Map<String, Object> responseBodyAsMap = jsonPath.getMap("content[0]");
        System.out.println("responseBodyAsMap = " + responseBodyAsMap);

        // Get the name of all the spartans and save it into a list : content.name
        List<String> allNames = jsonPath.getList("content.name");
        System.out.println("allNames = " + allNames);

        // continue from this task : now try to match this json objects into POJO
        // in order to match json result with 4 fields , you need to have POJO class with 4 matching fields
        // create a class called SpartanWithID
        // add encapsulated fields id, name , gender, phone
        // add no arg constructor (no need for 4 args constructor because we don't create object ourselves)
        // optionally add toString method, so we can print it worked.
        // now we can use  jp.getObject("the path here" , SpartanWithID.class)
        // to save it into  SpartanWithID object  --> another de-serialization!

        // store first json object in the result as SpartanWithID POJO : content[0]
        SpartanWithID spartan1 = jsonPath.getObject("content[0]", SpartanWithID.class);
        System.out.println("spartan1 = " + spartan1);

        // Store the entire response into List<SpartanWithID>
        List<SpartanWithID> resultList = jsonPath.getList("content", SpartanWithID.class);
        for (SpartanWithID spartan : resultList) {
            System.out.println("spartan = " + spartan);
        }
    }
}
