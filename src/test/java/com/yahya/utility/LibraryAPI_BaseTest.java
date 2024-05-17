package com.yahya.utility;

import com.yahya.utility.DB_Util;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;

public class LibraryAPI_BaseTest {

    @BeforeAll
    public static void setup(){

        baseURI = "https://library2.cydeo.com/";
        basePath = "/rest/v1";

        DB_Util.createLibraryConnection();
    }

    @AfterAll
    public static void tearDown(){

        reset();
        DB_Util.destroy();
    }
}
