package com.yahya.Day6;

import com.yahya.POJO.ArticlePojo;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

public class NewsAPIDeserialization {


    @BeforeAll
    public static void setup(){

        baseURI = "https://newsapi.org";
        basePath = "/v2";
    }

    @AfterAll
    public static void cleanUp(){
        RestAssured.reset();
    }

    /**
     * GET
     * https://newsapi.org/v2/top-headlines?country=us
     * Header: Authorization = Bearer 0b42f37dd32d4c70911a063c275005b0
     */
    @Test
    public void testNews(){

        JsonPath jsonPath = given().log().all()
                .queryParam("country", "us")
                .header("authorization", "Bearer 0b42f37dd32d4c70911a063c275005b0")
                .when().get("/top-headlines").jsonPath();

        // Try to get first article into Pojo
        ArticlePojo articlePojo = jsonPath.getObject("articles[0]", ArticlePojo.class);
        System.out.println("articlePojo = " + articlePojo);

        // check if the source id is null or not
        // the source id is inside the source map field
        // can use a getter to get the map
        // using this map method to get the value of the key
        System.out.println("articlePojo.getSource().get(\"id\") = " + articlePojo.getSource().get("id"));

        // get a List<Articles> from json array
        List<ArticlePojo> allArticles = jsonPath.getList("articles", ArticlePojo.class);

        for (ArticlePojo allArticle : allArticles) {
            if (allArticle.getSource().get("id") != null){
                System.out.println("allArticle.getAuthor() = " + allArticle.getAuthor());
            }
        }
    }
}
