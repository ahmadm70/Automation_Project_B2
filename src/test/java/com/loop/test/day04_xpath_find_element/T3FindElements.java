package com.loop.test.day04_xpath_find_element;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class T3FindElements {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.nba.com");
        List<WebElement> nbaLinks = driver.findElements(By.tagName("a"));
        System.out.println(nbaLinks.size());
        List<WebElement> nbaLinksXpath = driver.findElements(By.xpath("//a"));
        System.out.println(nbaLinksXpath.size());
        for (WebElement each : nbaLinks) {
            if (!each.getText().isEmpty()) {
                System.out.println(each.getText());
            }
            System.out.println(each.getAttribute("href"));
        }
        for (int i = 0; i < nbaLinks.size(); i++) {
            if (!nbaLinks.get(i).getText().equals("")) {
                System.out.println(nbaLinks.get(i).getText());
            }
        }
        driver.quit();
    }
}