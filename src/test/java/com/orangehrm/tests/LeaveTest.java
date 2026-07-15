package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.DashboardPage;
import com.orangehrm.pages.LeavePage;


public class LeaveTest extends BaseTest {

	@Test
    public void verifyLeaveHeaderAndNavigateToLeaveList() {
		
		DashboardPage dashboardPage =
	            loginAsAdmin();

	    LeavePage leavePage =
	            dashboardPage.clickLeaveMenu();

	    String header =
	            leavePage.getLeaveHeader();

	    Assert.assertEquals(header, "Leave");
	    
//	    Assert.assertEquals( header, "Wrong Header");   

	     // Navigate to Leave List
        leavePage.navigateToLeaveList();

        // Optional: Click Apply button
          // leavePage.clickApplyButton();
    }
	
}
