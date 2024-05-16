package com.yahya.Day8;

import com.github.javafaker.Faker;
import com.yahya.utility.LibraryTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class LibraryLoginTest extends LibraryTestBase {


    @ParameterizedTest
    @CsvFileSource(resources = "/librarycredentials.csv", numLinesToSkip = 1)
    public void testLogin(String username, String password){

        System.out.println("username = " + username);
        System.out.println("password = " + password);

        given().log().all()
                .contentType(ContentType.URLENC)
                .formParam("email", username)
                .formParam("password", password)
                .when().post("/login")
                .then().log().ifValidationFails().statusCode(200);
    }

    @DisplayName("Librarian Should be able to add book")
    @Test
    public void testAddBook(){

        String libraryToken = getToken(); // call the method here
        System.out.println("libraryToken = " + libraryToken);

        // first get library token by sending POST /login request
        // and save it(eventually will make a method out of it

        Faker faker = new Faker();

        // if you have many form parameters as the body
        // you can use formParams method and pass map object instead
        Map<String, Object> bookMap = new LinkedHashMap<>();
        bookMap.put("name", faker.book().title());
        bookMap.put("isbn", faker.code().isbn10());
        bookMap.put("year", faker.number().numberBetween(1000, 2024));
        bookMap.put("author", faker.book().author());
        bookMap.put("book_category_id", faker.number().numberBetween(1, 20));
        bookMap.put("description", faker.chuckNorris().fact());

        System.out.println("bookMap = " + bookMap);

        // send request to POST /add_book
        given().log().all().header("X-LIBRARY-TOKEN", libraryToken)
                .contentType(ContentType.URLENC)
                .formParams(bookMap)
                .when().post("/add_book")
                .then().log().all().body("message", is("The book has been created."));

    }
}
