package com.yahya.tests.Day6;

import com.yahya.POJO.DriverPojo;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

public class FormulaOneApi {


    @BeforeAll
    public static void setup(){

        RestAssured.baseURI = "http://ergast.com";
        RestAssured.basePath = "/api/f1";
    }

    @AfterAll
    public static void cleanUp(){
        RestAssured.reset();
    }

    @Test
    public void testDriverDeserialization(){

        JsonPath jsonPath = get("/drivers.json")
                .prettyPeek().jsonPath();

        DriverPojo driverPojo1 = jsonPath.getObject("MRData.DriverTable.Drivers[0]", DriverPojo.class);
        System.out.println("driverPojo1 = " + driverPojo1);

        // get all drivers using a list and print them
        List<DriverPojo> allDrivers = jsonPath.getList("MRData.DriverTable.Drivers", DriverPojo.class);
        System.out.println("allDrivers = " + allDrivers);

        // Find all the drivers with italian nationality
        // Loop through driver list and get their name if nationality is Italian
        for (DriverPojo eachDriver : allDrivers){
            if (eachDriver.getNationality().equals("Italian")){
                System.out.println("eachDriver.getGivenName() = " + eachDriver.getGivenName());
            }
        }
    }

}
