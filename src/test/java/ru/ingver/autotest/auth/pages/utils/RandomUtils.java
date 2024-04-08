package ru.ingver.autotest.auth.pages.utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomUtils {
    static Faker faker = new Faker(Locale.ENGLISH);

    public static String getUserName() {
        return faker.options().option("standard_user", "locked_out_user", "problem_user", "performance_glitch_user", "error_user", "visual_user");
    }
}
