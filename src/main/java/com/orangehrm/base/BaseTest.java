package com.orangehrm.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.orangehrm.pages.DashboardPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.ConfigReader;
import com.orangehrm.utils.DriverManager;

public class BaseTest {

	protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.getDriver();
        //driver.get("https://opensource-demo.orangehrmlive.com/");
        
        driver.get(ConfigReader.getProperty("url"));
        
      //  driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
    	DriverManager.quitDriver();
    	
//    	if (driver != null) {
//            driver.quit();
//        }
    }
    

    public WebDriver getDriver() {
        return driver;
    }
    
    protected DashboardPage loginAsAdmin() {

        return new LoginPage(driver)
                .doLogin(
                    ConfigReader.getProperty("username"),
                    ConfigReader.getProperty("password"));
    }
    
    
    
}
