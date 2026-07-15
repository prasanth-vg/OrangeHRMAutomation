package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.orangehrm.utils.WaitUtils;

public class DashboardPage {

    private WebDriver driver;

    // Constructor
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Elements
    @FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
    private WebElement welcomeMessage;

   
    @FindBy(xpath = "//span[text()='Time']")
    private WebElement timeTab;
    
    @FindBy(xpath = "//h6[normalize-space()='Dashboard']")
    private WebElement dashboardHeader;

    @FindBy(xpath = "//span[text()='Leave']")
    private WebElement leaveMenu;
    
    // Actions
    public String getWelcomeMessageText() {
        return welcomeMessage.getText();
    }

   
    public void clickTimeTab() {
        timeTab.click();
    }
    
    public String getDashboardHeader() {
        WaitUtils.waitForVisibility(driver, dashboardHeader, 10);
        return dashboardHeader.getText();
    }
    
    public LeavePage clickLeaveMenu() {

        leaveMenu.click();

        return new LeavePage(driver);
    }
  
}
