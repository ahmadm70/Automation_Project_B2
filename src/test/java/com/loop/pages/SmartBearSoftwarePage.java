package com.loop.pages;

import com.loop.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SmartBearSoftwarePage {
    @FindBy(xpath = "//a")
    public List<WebElement> linksList;
    public SmartBearSoftwarePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}