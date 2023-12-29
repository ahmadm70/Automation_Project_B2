package com.loop.test.day09_config_driver;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class T4JavaFaker {
    @Test
    public void javaFaker() {
        Faker faker = new Faker();
        System.out.println(faker.name().fullName());
        System.out.println(faker.numerify("###-###-##-##"));
        System.out.println(faker.numerify("865-###-##-##"));
        System.out.println(faker.letterify("?????"));
        System.out.println(faker.bothify("?????##"));
        System.out.println(faker.address().fullAddress());
        System.out.println(faker.finance().creditCard());
        System.out.println(faker.chuckNorris().fact());
        System.out.println(faker.chuckNorris().fact().replace("Chuck Norris", "Feyruz"));
    }
}