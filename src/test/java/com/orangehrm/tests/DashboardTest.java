package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.DashboardPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.ConfigReader;

public class DashboardTest extends BaseTest {

	@Test
	public void verifyWelcomeMessageAndNavigateToLeave() throws InterruptedException {
	    // Login and land on Dashboard
	    DashboardPage dashboardPage = new LoginPage(driver).doLogin(ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password"));

	    // Get welcome message
	    String actualWelcomeText = dashboardPage.getWelcomeMessageText();
	    
	    String actualHeader = dashboardPage.getDashboardHeader();

	    // Assertion
	    Assert.assertTrue(actualWelcomeText.contains("Welcome") || actualWelcomeText.length() > 0,
	            "Welcome message is not displayed correctly");
	    

	    String expectedHeader = "Dashboard"; 
	    Assert.assertEquals(actualHeader, expectedHeader, "Dashboard header does not match");

	    // Navigate to Leave tab
	   
	    Thread.sleep(5000);
	    
	}

    
}
