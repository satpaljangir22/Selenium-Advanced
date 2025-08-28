package org.example.test;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.AllureLogger;

import java.time.Duration;

public class DriverFactory {

    private static final AllureLogger log = AllureLogger.getLogger(DriverFactory.class);
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public static WebDriver getDriver(){
        return threadDriver.get();
    }

    public static synchronized void initDriver(String browser){
        if(browser == null){
            browser = "chrome";
        }
        try {
            if (browser.equalsIgnoreCase("firefox")) {
                threadDriver.set(new FirefoxDriver(setFirefoxOptions()));
                log.info(browser + " browser is initialized");
            } else {
                threadDriver.set(new ChromeDriver(setChromeOptions()));
                log.info(browser + " browser is initialized");
            }
        } catch (Exception e) {
            log.error("Failed to initialize WebDriver Instance", e);
            throw e;
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
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.setExperimentalOption("prefs", new java.util.HashMap<String, Object>() {{
            put("credentials_enable_service", false);
            put("profile.password_manager_enabled", false); // Optional: for older versions or additional control
        }});
        return chromeOptions;
    }

    private static FirefoxOptions setFirefoxOptions(){
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS);
        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        firefoxOptions.setPageLoadTimeout(Duration.ofSeconds(30));
        firefoxOptions.addArguments("headless");
        firefoxOptions.addArguments("--disable-gpu");
        return firefoxOptions;
    }
}
