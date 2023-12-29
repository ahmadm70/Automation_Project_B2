package com.loop.test.day09_config_driver;

import com.loop.test.utilities.ConfigurationReader;

public class T0TestConfiguration {
    public static void main(String[] args) {
        System.out.println(ConfigurationReader.getProperty("browser"));
    }
}