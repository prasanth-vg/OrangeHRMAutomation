package com.orangehrm.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    private WebDriver driver;
    private WebDriverWait wait;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

   
    
    public static void waitForVisibility(WebDriver driver, WebElement element, int timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForClickability(WebDriver driver, WebElement element, int timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    
    // Non static wait methods,  can be used for constructor-based Page Object injection 
    
//    public void waitForVisibility(WebElement element) {
//        wait.until(ExpectedConditions.visibilityOf(element));
//    }
//
//    public void waitForClickability(WebElement element) {
//        wait.until(ExpectedConditions.elementToBeClickable(element));
//    }
    
    
}
