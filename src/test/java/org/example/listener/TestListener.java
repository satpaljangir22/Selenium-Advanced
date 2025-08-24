package org.example.listener;

import org.example.test.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ScreenShotUtility;

public class TestListener implements ITestListener {

    protected WebDriver driver;

    @Override
    public void onTestFailure(ITestResult result) {
        driver = DriverFactory.getDriver();
        if(driver != null){
            String testName = result.getMethod().getMethodName();
            ScreenShotUtility.captureScreenShot(driver, testName);
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        driver = DriverFactory.getDriver();
        if(driver != null){
            String testName = result.getMethod().getMethodName();
            String instanceName = result.getMethod().getDataProviderMethod().getName();
            ScreenShotUtility.captureScreenShot(driver, testName);
        }
    }
}
