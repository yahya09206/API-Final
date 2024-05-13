package com.yahya.utility;

import com.github.javafaker.Faker;

import java.util.LinkedHashMap;
import java.util.Map;

public class SpartanUtil {
    public static Map<String, Object> getRandomSpartanMapBody(){

        Faker faker = new Faker();

        Map<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("name", faker.name().firstName());
        bodyMap.put("gender", faker.demographic().sex());
        // get a number between 500,000,0000 - 999,999,9999
        bodyMap.put("phone", faker.number().numberBetween(5000000000L, 9999999999L));
        System.out.println("bodyMap = " + bodyMap);

        return bodyMap;

    }
}
