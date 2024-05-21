package com.yahya.tests.Day11;

import com.yahya.POJO.Spartan;
import com.yahya.utility.SpartanTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static org.hamcrest.Matchers.*;

public class NegativeTest extends SpartanTestBase {

    /**
     * Post /spartans request json payload have below requirements
     * name  : 2-15 chars
     * gender : Male or Female
     * phone  : 10 - 13 digit
     * Knowing that we already tested all positive scenario
     * make sure it generates error with proper json body to reflect the error
     * according to the negative test data you provided.
     * for example :
     * {
     *     "name":"A",
     *     "gender":"Male",
     *     "phone":1231231231
     * }
     * we should expect 400 response
     * {
     *     "message": "Invalid Input!",
     *     "errorCount": 1,
     *     "errors": [
     *         {
     *             "errorField": "name",
     *             "rejectedValue": "A",
     *             "reason": "name should be at least 2 character and max 15 character"
     *         }
     *     ]
     * }
     * error count should be 1
     * "message": "Invalid Input!",
     * "errorField": "name"
     *  from the response
     */
    @DisplayName("POST /spartan invalid payload should return error")
    @Test
    public void testAdd1NegativeDataScenario(){

        // prepare test body
        Spartan invalidBody = new Spartan("A", "Male", 1234567890L);

        given().log().all()
                .contentType(ContentType.JSON)
                .body(invalidBody)
                .when().post("/spartans")
                .then().log().all()
                .statusCode(400)
                .body("message", is("Invalid Input!"))
                .body("errorCount", equalTo(1))
                .body("errors[0].errorField", is("name"));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/negativePostData.csv", numLinesToSkip = 1)
    public void testNegativeTestPayload(String nameParam, String genderParam, long phoneParam, int expectedCount){

        Spartan invalidBody = new Spartan(nameParam, genderParam, phoneParam);

        given().log().all()
                .contentType(ContentType.JSON)
                .body(invalidBody)
                .when().post("/spartans")
                .then().log().all()
                .statusCode(400)
                .body("message", is("Invalid Input!"))
                .body("errorCount", equalTo(expectedCount));
    }
}
