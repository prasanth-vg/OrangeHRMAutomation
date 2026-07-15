package com.orangehrm.pages;

import com.orangehrm.utils.WaitUtils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;
    
    @FindBy(xpath = "//h6[text()='Dashboard']")
    private WebElement dashboardHeader;
    
    
    // ----- Actions ----------
    

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        WaitUtils.waitForVisibility(driver, usernameField, 10);
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
        try {
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert text: " + alert.getText());
            alert.accept(); // click OK
        } catch (Exception e) {
            System.out.println("No alert displayed");
        }
    }
    
    public boolean isDashboardVisible() {
        WaitUtils.waitForVisibility(driver, dashboardHeader, 10);
        return dashboardHeader.isDisplayed();
    }
    
    public DashboardPage doLogin(String username, String password) {
        login(username, password);
        return new DashboardPage(driver);
    }
    
}
