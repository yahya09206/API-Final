package com.yahya.Day6;

import com.yahya.POJO.CarLombok;
import com.yahya.POJO.Jobs;
import com.yahya.utility.HRTestBase;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

public class HRORDSTest extends HRTestBase {

    @Test
    public void testJobs(){

        JsonPath jsonPath = given().log().uri()
                .when().get("/jobs")
                //.prettyPeek()
                .jsonPath();

        // de-serialize first json object from json array
        // follow java naming convention for the pojo fields
        // ignore the json fields we don't want : link field
        Jobs j1 = jsonPath.getObject("items[0]", Jobs.class);
        System.out.println("j1 = " + j1);

        // save all the results into List<job>
        List<Jobs> allJobs = jsonPath.getList("items", Jobs.class);
        System.out.println("allJobs = " + allJobs);
    }

    @Test
    public void testCarPojo(){

        CarLombok carLombok1 = new CarLombok("Model3", "Tesla", 2020, true);
        System.out.println("carLombok1 = " + carLombok1);

        carLombok1.setModel("CyberTruck");
        System.out.println(carLombok1);
    }
}
