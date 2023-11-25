package com.loop.test.day03_locators_css_xpath;

import com.loop.test.utilities.LoopCampConstants;
import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2GetTextGetAttribute {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://loopcamp.vercel.app/registration_form.html");
        driver.manage().window().maximize();
        WebElement headerForForm = driver.findElement(By.tagName("h2"));
        String actualHeaderForForm = headerForForm.getText();
        if (actualHeaderForForm.equals(LoopCampConstants.EXPECTED_HEADER_FOR_FORM)) {
            System.out.println("They're matching. ---> TEST PASSED!");
        } else {
            System.err.println("They're not matching. ---> TEST FAILED!");
        }
        WebElement usernamePlaceholder = driver.findElement(By.name("username"));
        String actualPlaceholder = usernamePlaceholder.getAttribute("placeholder");
        if (actualPlaceholder.equals(LoopCampConstants.EXPECTED_PLACEHOLDER_USERNAME)) {
            System.out.println("They're matching. ---> TEST PASSED!");
        } else {
            System.err.println("They're not matching. ---> TEST FAILED!");
        }
        System.exit(0);
    }
}