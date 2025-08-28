package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AllureLogger;

import java.time.Duration;
import java.util.List;

public class BasePage {

    private static final AllureLogger log = AllureLogger.getLogger(BasePage.class);
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    private WebElement getElement(By locator){
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> getAllElements(By locator){
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void clickElement(By locator){
        try{
            getElement(locator).click();
            log.info("Clicked on: " + locator);
        } catch (Exception e){
            log.error("Failed to click on element: " + locator, e);
            throw e;
        }

    }

    public void enterText(By locator, String text){
        try{
            getElement(locator).sendKeys(text);
            log.info("Entered " + text + "on element: " + locator);
        } catch (Exception e) {
            log.error("Failed to enter " + text + "on element " + locator, e);
        }

    }

    public String getPageTitle(){
        String pageTitle;
        try{
            pageTitle = this.driver.getTitle();
            log.info("Got Page Title");
        } catch (Exception e) {
            log.error("Failed to get page title", e);
            throw e;
        }
        return pageTitle;
    }

    public String getCurrentUrl(){
        String currentUrl;
        try{
            currentUrl = this.driver.getCurrentUrl();
            log.info("Got Current Url");
        } catch (Exception e) {
            log.error("Failed to get current url", e);
            throw e;
        }
        return currentUrl;
    }
}
