package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.WaitUtils;

public class LeavePage {

	private WebDriver driver;

    // Constructor
    public LeavePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ====== WebElements ======
    @FindBy(xpath = "//h6[text()='Leave']")  // Example header
    private WebElement leaveHeader;

    @FindBy(xpath = "//a[text()='Leave List']")
    private WebElement leaveListMenu;
    
   

    @FindBy(xpath = "//button[@type='submit']")  // Example apply button
    private WebElement applyButton;

    // ====== Methods ======
    public String getLeaveHeader() {
        WaitUtils.waitForVisibility(driver, leaveHeader, 10);
        return leaveHeader.getText();
    }

    public void navigateToLeaveList() {
        WaitUtils.waitForClickability(driver, leaveListMenu, 10);
        leaveListMenu.click();
    }

    public void clickApplyButton() {
        WaitUtils.waitForClickability(driver, applyButton, 10);
        applyButton.click();
    }
	
	
}
