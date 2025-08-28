package org.example.test;

import org.testng.annotations.*;
import utils.AllureLogger;

public class BaseTest {

    private static final AllureLogger log = AllureLogger.getLogger(BaseTest.class);

    @Parameters({"browser"})
    @BeforeMethod
    protected void setUp(String browser) {
        log.info("Launching the " + browser + " browser instance");
        try{
            DriverFactory.initDriver(browser);
            DriverFactory.getDriver().navigate().to("https://www.saucedemo.com/");
            log.info("Navigated to url: https://www.saucedemo.com/");
        } catch (Exception e){
            log.error("Failed to launch browser instance", e);
            throw e;
        }

    }

    @AfterMethod
    protected void tearDown() {
        try{
        DriverFactory.quitDriver();
        log.info("Closed browser instance");
    } catch (Exception e){
            log.error("Failed to close the browser instance", e);
            throw e;
        }
    }
}
