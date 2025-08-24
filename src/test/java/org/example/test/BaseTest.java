package org.example.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    protected void setUp() {
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.navigate().to("https://www.saucedemo.com/");
    }

    @AfterMethod
    protected void tearDown() {
        DriverFactory.quitDriver();
    }
}
