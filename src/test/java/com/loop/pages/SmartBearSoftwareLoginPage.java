package com.loop.pages;

import com.loop.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartBearSoftwareLoginPage {
    @FindBy(id = "ctl00_MainContent_username")
    public WebElement usernameBar;
    @FindBy(id = "ctl00_MainContent_password")
    public WebElement passwordBar;
    @FindBy(id = "ctl00_MainContent_login_button")
    public WebElement loginButton;
    public SmartBearSoftwareLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}