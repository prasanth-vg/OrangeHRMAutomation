package com.orangehrm.tests;


import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.ConfigReader;


import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
      //  loginPage.login("Admin", "Test@12345");  // 🔁 Use actual credentials for OrangeHRM
        loginPage.login(
        	    ConfigReader.getProperty("username"),
        	    ConfigReader.getProperty("password")
        	);
        
        Assert.assertTrue(loginPage.isDashboardVisible(), "Login failed - Dashboard not visible");
        System.out.println(" completed");
    }
}
