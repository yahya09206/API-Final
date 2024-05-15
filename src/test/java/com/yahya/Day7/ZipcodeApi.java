package com.yahya.Day7;

import com.yahya.POJO.CarLombok;
import com.yahya.POJO.Jobs;
import com.yahya.utility.HRTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.List;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ZipcodeApi {

    @BeforeAll
    public static void setup(){

        baseURI = "http://api.zippopotam.us";
        basePath = "/us";

    }

    @AfterAll
    public static void tearDown(){

        reset();
    }

    @Test
    public void testZipToCity(){

        // log request, provide 22030 as path variable
        // send get request and assert status is 200
        // assert response is in json format
        // assert "country": "United States"
        // assert "state": "Virginia"
        given().log().all()
                .pathParams("zip", 22030)
                .when().get("/{zip}")
                .then().log().all().statusCode(is(200))
                .contentType(ContentType.JSON)
                .body("country", is("United States"))
                .body("places[0].state", is("Virginia"));
    }
}
