package utils;

import com.github.javafaker.Faker;
import models.SignupRequest;

public class TestDataGenerator {

    private static final Faker faker = new Faker();

    public static SignupRequest generateSignupRequest() {
        return new SignupRequest.Builder()
                .username(faker.name().username())
                .password("Cybage@123") // or faker.internet().password()
                .email(faker.internet().emailAddress())
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .mobileNumber(faker.phoneNumber().cellPhone())
                .build();
    }
}
