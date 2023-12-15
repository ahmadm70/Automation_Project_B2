package com.loop.test.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Set;

public class BrowserUtilities {
    /**
     * Validates if driver switched to expected URL and title
     * @param driver
     * @param expectedURL
     * @param expectedTitle
     * @author Ahmad
     */
    public static void switchWindowAndValidate(WebDriver driver, String expectedURL, String expectedTitle) {
        expectedURL = expectedURL.toLowerCase();
        expectedTitle = expectedTitle.toLowerCase();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String each : windowHandles) {
            driver.switchTo().window(each);
            if (driver.getCurrentUrl().toLowerCase().contains(expectedURL)) {
                break;
            }
        }
        Assert.assertTrue(driver.getTitle().toLowerCase().contains(expectedURL));
    }
}