package com.orangehrm.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.orangehrm.base.BaseTest;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentTestNGListener implements ITestListener {

    private static ExtentReports extent = ExtentReportManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static ExtentTest getTest() {
        return test.get();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        getTest().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	 System.out.println("Inside onTestFailure");
        getTest().log(Status.FAIL, result.getThrowable());
        
       
        try {

            Object currentClass =
                    result.getInstance();

            WebDriver driver =
                    ((BaseTest) currentClass)
                            .getDriver();

            String screenshotPath =
                    ScreenshotUtil.captureScreenshot(
                            driver,
                            result.getMethod().getMethodName());

            getTest().addScreenCaptureFromPath(
                    screenshotPath);

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        getTest().log(Status.SKIP, "Test skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
