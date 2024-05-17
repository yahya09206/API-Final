package com.yahya.tests.Day8;

import com.yahya.utility.SpartanAuthTestBase;
import org.junit.jupiter.api.Test;
import com.yahya.utility.SpartanUtil;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;

public class BaseAuthTest extends SpartanAuthTestBase {

    // Spartan App that runs on port 7000 requires basic auth to make authorized requests
    // 3 roles with different authority levels admin/admin editor/editor user/user
    // In query param or header according to the docs

    /**
     * Create a test testPublicUser
     * Send a request GET /spartans without any authentication
     * should get a 401
     */

    @Test
    public void testPublicUser(){

        given().log().uri()
                .when().get("/spartans")
                .then().log().all().statusCode(401);
    }

    /**
     * Create a test testPublicUser
     * Send a request GET /spartans without any authentication
     * should get a 200
     */
    @Test
    public void testAuthenticatedUser(){

        given().log().all()
                .auth().basic("user", "user")
                .when().get("/spartans")
                .then().log().ifValidationFails().statusCode(200);
    }

}
