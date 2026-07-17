package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.WaitUtils;

public class PIMPage {

    private WebDriver driver;

    public PIMPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h6[text()='PIM']")
    private WebElement pimHeader;

    public String getPIMHeader() {
        WaitUtils.waitForVisibility(driver, pimHeader, 10);
        return pimHeader.getText();
    }
}