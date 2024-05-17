package com.yahya.tests.Day5;

import com.github.javafaker.Faker;
import com.yahya.POJO.Spartan;
import org.junit.jupiter.api.*;

import com.yahya.utility.SpartanTestBase;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

@Tag("tc1")
public class PostPutRequestWithPOJOTests extends SpartanTestBase{


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
