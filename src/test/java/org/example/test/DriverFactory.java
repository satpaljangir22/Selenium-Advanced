package org.example.test;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class DriverFactory {

    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public static WebDriver getDriver(){
        return threadDriver.get();
    }

    public static synchronized void initDriver(String browser){
        if(browser == null){
            browser = "chrome";
        }
        if (browser.equalsIgnoreCase("firefox")) {
            threadDriver.set(new FirefoxDriver(setFirefoxOptions()));
        } else {
            threadDriver.set(new ChromeDriver(setChromeOptions()));
        }
    }

    public static void quitDriver(){
        if (threadDriver.get() != null) {
            threadDriver.get().quit();
            threadDriver.remove();
        }
    }

    private static ChromeOptions setChromeOptions(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS);
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.setPageLoadTimeout(Duration.ofSeconds(30));
        chromeOptions.addArguments("headless");
        chromeOptions.setImplicitWaitTimeout(Duration.ofSeconds(30));
        return chromeOptions;
    }

    private static FirefoxOptions setFirefoxOptions(){
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS);
        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        firefoxOptions.setPageLoadTimeout(Duration.ofSeconds(30));
        //firefoxOptions.addArguments("headless");
        firefoxOptions.setImplicitWaitTimeout(Duration.ofSeconds(30));
        return firefoxOptions;
    }
}
