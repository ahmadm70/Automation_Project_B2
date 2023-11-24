package com.loop.test.day03_locators_css_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Actual title: \"" + actualTitle + "\", matches with expected title: \"" +
                    expectedTitle + "\". ---> TEST PASSED!");
        } else {
            System.err.println("Actual title: \"" + actualTitle + "\", doesn't match with expected title: \"" +
                    expectedTitle + "\". ---> TEST FAILED!");
        }
        String expectedURL = "https://www.google.com/";
        String actualURL = driver.getCurrentUrl();
        if (actualURL.contains(expectedURL)) {
            System.out.println("Actual URL: \"" + actualURL + "\", matches with expected URL: \"" +
                    expectedURL + "\". ---> TEST PASSED!");
        } else {
            System.err.println("Actual URL: \"" + actualURL + "\", doesn't match with expected URL: \"" +
                    expectedURL + "\". ---> TEST FAILED!");
        }
        driver.quit();
    }
}