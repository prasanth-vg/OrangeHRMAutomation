package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.DashboardPage;
import com.orangehrm.pages.PIMPage;

public class PIMTest extends BaseTest {

    @Test
    public void verifyPIMHeader() {

        DashboardPage dashboardPage =
                loginAsAdmin();

        PIMPage pimPage =
                dashboardPage.clickPIMMenu();

        Assert.assertEquals(
                pimPage.getPIMHeader(),
                "PIM");
    }
}