package com.loop.test.day09_config_driver;

public class T1SingletonPatternExample {
    //We have to have a private constructor for preventing external instantiation
    private T1SingletonPatternExample() {
    }
    private static String word;
    public static String getWord() {
        if (word == null) {
            System.out.println("First time calling, object is null, assigning now");
            word = "driver";
        } else {
            System.out.println("Word is already assigned and has a value");
        }
        return word;
    }
}