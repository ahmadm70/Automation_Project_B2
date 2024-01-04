package com.loop.pages;

import com.loop.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoopPracticeDynamicLoadingPage7 {
    @FindBy(xpath = "//div[@id='alert']")
    public WebElement doneMessage;
    @FindBy(xpath = "//img[@alt='square pants']")
    public WebElement image;
    public LoopPracticeDynamicLoadingPage7() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}