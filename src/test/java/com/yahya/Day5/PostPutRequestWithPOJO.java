package com.yahya.Day5;

import com.github.javafaker.Faker;
import com.yahya.POJO.Spartan;
import org.junit.jupiter.api.Test;

import com.yahya.utility.SpartanTestBase;
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

public class PostPutRequestWithPOJO extends SpartanTestBase{


    @Test
    public void testPostWithPojoAsBody(){

        Faker faker = new Faker();
        Spartan spartan1 = new Spartan(faker.name().firstName(), faker.demographic().sex(), 5555555555L);
        System.out.println("spartan1 = " + spartan1);

        given().log().all()
                .contentType(ContentType.JSON)
                .body(spartan1)
                .when().post("/spartans")
                .then().log().all()
                .statusCode(201);
    }

}
