package org.example.test;

import org.testng.annotations.*;
import utils.ScreenShotUtility;

public class BaseTest {

    @BeforeSuite
    protected void folderCleanUp(){
        ScreenShotUtility.cleanScreenshotFolder();
    }

    @Parameters({"browser"})
    @BeforeMethod
    protected void setUp(String browser) {
        DriverFactory.initDriver(browser);
        DriverFactory.getDriver().navigate().to("https://www.saucedemo.com/");
    }

    @AfterMethod
    protected void tearDown() {
        DriverFactory.quitDriver();
    }
}
