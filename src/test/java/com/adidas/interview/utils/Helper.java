package com.adidas.interview.utils;

import com.github.javafaker.Faker;

import java.util.Random;

public class Helper {

    public static long generateRandom() {
        Random random = new Random();
        return random.nextLong() * 4;
    }

    public static String generateRandomString() {
        Faker faker = new Faker();
        return faker.name().firstName();
    }


}
