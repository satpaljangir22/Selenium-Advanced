package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

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
        getElement(locator).click();
    }

    public void enterText(By locator, String text){
        getElement(locator).sendKeys(text);
    }

    public String getPageTitle(){
        return this.driver.getTitle();
    }

    public String getCurrentUrl(){
        return this.driver.getCurrentUrl();
    }
}
