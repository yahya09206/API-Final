package com.yahya.tests.Day11;

import com.yahya.utility.SpartanTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;

public class XMLResponseTest {

    @BeforeAll
    public static void setUp(){
        baseURI = "http://ergast.com";
        basePath = "api/f1";
    }

    @AfterAll
    public static void tearDown(){
        reset();
    }

    @DisplayName("Test GET /drivers/{drivers{id} xml response")
    @Test
    public void testSingleDriverXMLResponse(){

        given()
                .pathParam("driverId", "abate")
                .log().uri()
                .when().get("/drivers/{driverId}")
                .then().log().all()
                .statusCode(200)
                .contentType(ContentType.XML)
                .body("MRData.DriverTable.Driver.GivenName", is("Carlo"));
    }
}
