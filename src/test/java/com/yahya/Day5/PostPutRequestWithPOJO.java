package com.yahya.Day5;

import com.github.javafaker.Faker;
import com.yahya.POJO.Spartan;
import org.junit.jupiter.api.Test;

public class PostPutRequestWithPOJO {


    @Test
    public void testPostWithPojoAsBody(){

        Faker faker = new Faker();
        Spartan spartan1 = new Spartan(faker.name().fullName(), faker.demographic().sex(), 5555555555L);
        System.out.println("spartan1 = " + spartan1);
    }

}
