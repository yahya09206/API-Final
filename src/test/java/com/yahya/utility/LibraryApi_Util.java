package com.yahya.utility;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class LibraryApi_Util {

    public static String getToken(){

        return given().log().all()
                .contentType(ContentType.URLENC)
                .formParam("email", "librarian3@library")
                .formParam("password", "libraryUser")
                .when().post("/login").path("token");
    }

    // create a method to generate random book
    public static Map<String, Object> getRandomBookMap(){

        Faker faker = new Faker();
        Map<String, Object> bookMap = new LinkedHashMap<>();
        bookMap.put("name", faker.book().title());
        bookMap.put("isbn", faker.code().isbn10());
        bookMap.put("year", faker.number().numberBetween(1000, 2024));
        bookMap.put("author", faker.book().author());
        bookMap.put("book_category_id", faker.number().numberBetween(1, 20));
        bookMap.put("description", faker.chuckNorris().fact());

        System.out.println("bookMap = " + bookMap);

        return bookMap;
    }
}
