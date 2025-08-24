package org.example.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.ScreenShotUtility;

import java.time.Duration;

public class BaseTest {

    @BeforeSuite
    protected void folderCleanUp(){
        ScreenShotUtility.cleanScreenshotFolder();
    }

    @BeforeMethod
    protected void setUp() {
        DriverFactory.initDriver();
        DriverFactory.getDriver().navigate().to("https://www.saucedemo.com/");
    }

    @AfterMethod
    protected void tearDown() {
        DriverFactory.quitDriver();
    }
}
