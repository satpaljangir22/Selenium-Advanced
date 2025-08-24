package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    By userName = By.id("user-name");
    By password = By.id("password");
    By loginButton = By.id("login-button");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void LoginToApp(String loginUserName, String loginUserPassword){
        this.driver.findElement(userName).sendKeys(loginUserName);
        this.driver.findElement(password).sendKeys(loginUserPassword);
        this.driver.findElement(loginButton).click();
    }
}
