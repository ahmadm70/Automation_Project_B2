package com.loop.test.day03_locators_css_xpath;

import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.LoopCampConstants;
import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3GetAttributeCss {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://beta.docuport.app/login?redirect=%2F");
        driver.manage().window().maximize();
        WebElement logo = driver.findElement(By.cssSelector("img[src='/img/logo.d7557277.svg']"));
        String docuport = logo.getAttribute("alt");
        if (docuport.equals(DocuportConstants.LOGO_DOCUPORT)) {
            System.out.println("They're matching. ---> TEST PASSED!");
        } else {
            System.err.println("They're not matching. ---> TEST FAILED!");
        }
        System.exit(0);
    }
}