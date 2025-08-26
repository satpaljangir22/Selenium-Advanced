package org.example.listener;

import io.qameta.allure.Allure;
import org.example.test.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    protected WebDriver driver;

    private void attachScreenShot(String testName){
        driver = DriverFactory.getDriver();
        if (driver != null && driver instanceof TakesScreenshot){
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(testName + " Screenshot", "image/png",
                    new java.io.ByteArrayInputStream(screenshot), ".png");

        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        attachScreenShot(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        attachScreenShot(result.getMethod().getMethodName());
    }
}
