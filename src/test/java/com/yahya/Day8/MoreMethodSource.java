package com.yahya.Day8;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoreMethodSource {

    // If we want to provide more than one value for each test in a parameterized test
    // List<String> will only store 1 string per element
    // In order to have more than one value
    // We can use List<Map<String, Object>>

    @ParameterizedTest
    @MethodSource("getAllStudentInfo")
    public void testStudentDDT(Map<String, Object> studentInfo){

        System.out.println(studentInfo);
    }

    // Creating a static method that returns List<Map<String, Object>>
    // Map object should have key: name, gender, phone
    public static List<Map<String, Object>> getAllStudentInfo(){

        List<Map<String, Object>> allInfoMapList = new ArrayList<>();

        // Add 3 items into this list
        Map<String, Object> studentMap1 = new HashMap<>();
        studentMap1.put("name", "Mousa");
        studentMap1.put("gender", "Male");
        studentMap1.put("phone", "1234567890");

        Map<String, Object> studentMap2 = new HashMap<>();
        studentMap1.put("name", "Mucahit");
        studentMap1.put("gender", "Male");
        studentMap1.put("phone", "1234567890");

        Map<String, Object> studentMap3 = new HashMap<>();
        studentMap1.put("name", "Feruza");
        studentMap1.put("gender", "Female");
        studentMap1.put("phone", "1234567890");

        allInfoMapList.add(studentMap1);
        allInfoMapList.add(studentMap2);
        allInfoMapList.add(studentMap3);

        return allInfoMapList;
    }
}
