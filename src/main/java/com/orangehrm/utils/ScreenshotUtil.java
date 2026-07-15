package com.orangehrm.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String testName) {

        File screenshotDir = new File("screenshots");

        if (!screenshotDir.exists()) {
            screenshotDir.mkdirs();
        }

        String screenshotPath =
                "screenshots/" + testName + ".png";

        File srcFile =
                ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.FILE);

        File destFile = new File(screenshotPath);

        try {
            Files.copy(
                    srcFile.toPath(),
                    destFile.toPath(),
                    StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Screenshot saved at: "
                    + destFile.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }

      //  return screenshotPath;
        return destFile.getAbsolutePath();
        
    }
}