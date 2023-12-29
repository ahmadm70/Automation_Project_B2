package com.loop.test.day09_config_driver;

import org.testng.annotations.Test;

public class T2SingletonPatternPractice {
    @Test
    public void singletonPatternTest() {
        String str1 = T1SingletonPatternExample.getWord();
        System.out.println(str1);
        //--------------------------------------------------------------------------------------------------------------
        String str2 = T1SingletonPatternExample.getWord();
        System.out.println(str2);
    }
}